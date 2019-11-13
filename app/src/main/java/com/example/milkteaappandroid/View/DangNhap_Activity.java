package com.example.milkteaappandroid.View;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import com.example.milkteaappandroid.R;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

        import java.util.regex.Pattern;

public class DangNhap_Activity extends AppCompatActivity implements View.OnClickListener, FirebaseAuth.AuthStateListener {

    Button btnDangNhap, btnDangKy;
    EditText emailDN, matkhauDN;
    FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap_layout);

        btnDangNhap = findViewById(R.id.btnlogin);
        btnDangKy = findViewById(R.id.btnregister);
        emailDN = findViewById(R.id.ed_Email);
        matkhauDN = findViewById(R.id.ed_Password);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();
        btnDangNhap.setOnClickListener(this);
        btnDangKy.setOnClickListener(this);
    }


    // khi bắt đầu, gọi AuthState để kiểm tra người dùng đăng nhập hay đăng xuất.
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(this);
        //firebaseAuth.signOut();
    }

    // khi kết thúc nó sẽ xóa trạng thái của người dùng
    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btnlogin){
            dangNhap();
        }if(id == R.id.btnregister){
            Intent intent = new Intent(DangNhap_Activity.this, DangKi_Activity.class);
            startActivity(intent);
        }
        else{

        }
    }

    //    tạo hàm Đăng nhập
    private void dangNhap(){
        String email = emailDN.getText().toString();
        String matkhau = matkhauDN.getText().toString();
        if(!isValid(emailDN.getText().toString())){
            emailDN.setError("Email không được bỏ trống!");
            return;
        }
        if(matkhauDN.getText().toString().isEmpty()){
            matkhauDN.setError("Mật khẩu không để trống! ");
            return;
        }
        else {
            firebaseAuth.signInWithEmailAndPassword(email, matkhau);
        }


    }

    private boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    // khi đăng nhập thành công, hay đăng xuất thành công thì onAuthStateChanged được kích hoạt
    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        // firebaseAuth thông qua user sẽ biết được đăng nhập thành công hay thất bại,
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null){ // nếu có user - tức là đăng nhập thành công
            Intent index = new Intent(this, MainActivity.class);
            startActivity(index);
        }else{ // không có user

        }
    }
}

