package com.example.milkteaappandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class DangKi_Activity extends AppCompatActivity implements View.OnClickListener {

    // khai báo button và editText cần dùng

    Button btnDangKi;

    EditText edHoTen, edSdt, edDiaChi, edEmail, edMatKhau, edNhapLaiMK;

    FirebaseAuth firebaseAuth; // khai báo firebaseAuth

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangki_layout);

        // khởi tạo fire baseAuth bằng getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        // tìm các control dang ki ở ngoài giao diện
        btnDangKi = (Button) findViewById(R.id.btn_DangKi);
        edHoTen = findViewById(R.id.ed_HoTen_DK);
        edDiaChi = findViewById(R.id.ed_DiaChi_DK);
        edSdt = findViewById(R.id.ed_SDT_DK);
        edEmail = findViewById(R.id.ed_Email_DK);
        edMatKhau = findViewById(R.id.ed_MatKhau_DK);
        edNhapLaiMK = findViewById(R.id.ed_NhapLaiPass_DK);


        // lắng nghe sự kiện click của button tại trang đăng kí
        btnDangKi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // lấy text của các editText ngoài giao diện
        String hoten = edHoTen.getText().toString();
        String diachi = edDiaChi.getText().toString();
        String sdt = edSdt.getText().toString();
        String email = edEmail.getText().toString();
        String matkhau = edMatKhau.getText().toString();
        String nhaplaimk = edNhapLaiMK.getText().toString();

        String thongbaoloinhap = getString(R.string.thongbaoloidangki);
       // String thongbaomk = getString(R.string.thongbaonhaplaimk);

        Toast.makeText(this, hoten.trim().length() +"", Toast.LENGTH_SHORT).show();


        // kiểm tra điều kiện
        if(hoten.trim().length() == 0){
            //thongbaoloinhap += getString(R.string.hoten);
            Toast.makeText(this, hoten.trim().length(), Toast.LENGTH_SHORT).show(); // xuất thông báo bằng toast
        }
//        else if(diachi.trim().length() < 10){
//            thongbaoloinhap += getString(R.string.diachi);
//            Toast.makeText(this, thongbaoloinhap, Toast.LENGTH_SHORT).show();
//        }
//        else if(sdt.trim().length() < 10 || sdt.trim().length() > 10){
//            thongbaoloinhap += getString(R.string.sodt);
//            Toast.makeText(this, thongbaoloinhap, Toast.LENGTH_SHORT).show();
//        }
//        else if(email.trim().length() == 0){
//            thongbaoloinhap += getString(R.string.email);
//            Toast.makeText(this, thongbaoloinhap, Toast.LENGTH_SHORT).show();
//        }
//        else if(matkhau.trim().length() == 0){
//            thongbaoloinhap += getString(R.string.password);
//            Toast.makeText(this, thongbaoloinhap, Toast.LENGTH_SHORT).show();
//        }
//        else if(!nhaplaimk.equals(matkhau)){
//            Toast.makeText(this, getString(R.string.thongbaonhaplaimk), Toast.LENGTH_SHORT).show();
//        }
//        else {
//            firebaseAuth.createUserWithEmailAndPassword(email, matkhau).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if(task.isSuccessful()){
//                        Toast.makeText(DangKi_Activity.this, getString(R.string.thongbaodangkithanhcong), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
    }
}
