package com.example.milkteaappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DangNhap_Activity extends AppCompatActivity implements View.OnClickListener, FirebaseAuth.AuthStateListener {

    ImageButton btnDangNhap;
    TextView txtDangKiMoi;
    EditText emailDN, matkhauDN;
    FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap_layout);


//        tìm bên giao diện và gán vào các giá trị
       txtDangKiMoi = findViewById(R.id.txt_DangKiMoi);
       btnDangNhap = findViewById(R.id.btn_DangNhap);
        emailDN = findViewById(R.id.ed_EmailDN);
        matkhauDN = findViewById(R.id.ed_MatkhauDN);

      firebaseAuth = FirebaseAuth.getInstance();
     firebaseAuth.signOut();

   // lắng nghe sự kiện click của    image button, đăng kí mới
       txtDangKiMoi.setOnClickListener(this);

        btnDangNhap.setOnClickListener(this);

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
        if(id == R.id.btn_DangNhap){
            dangNhap();
        }
        else{

        }
    }

//    tạo hàm Đăng nhập
    private void dangNhap(){
        // lấy email, mk người dùng nhập ở bên giao diện .
        String email = emailDN.getText().toString();
        String matkhau = matkhauDN.getText().toString();
        //firebaseAuth.signOut();

        firebaseAuth.signInWithEmailAndPassword(email, matkhau);
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
