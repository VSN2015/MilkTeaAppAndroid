package com.example.milkteaappandroid.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.milkteaappandroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class DangKi_Activity extends AppCompatActivity implements View.OnClickListener {

    // khai báo button và editText cần dùng

    Button btnDangKi;

    EditText edHoTen, edSdt, edDiaChi, edEmail, edMatKhau, edNhapLaiMK;

    TextView txtDangNhap;

    FirebaseAuth firebaseAuth; // khai báo firebaseAuth

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangki_layout);

        // khởi tạo fire baseAuth bằng getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        // tìm các control dang ki ở ngoài giao diện
        btnDangKi = findViewById(R.id.btn_DangKi);
        edHoTen = findViewById(R.id.ed_HoTen_DK);
        edDiaChi = findViewById(R.id.ed_DiaChi_DK);
        edSdt = findViewById(R.id.ed_SDT_DK);
        edEmail = findViewById(R.id.ed_Email_DK);
        edMatKhau = findViewById(R.id.ed_MatKhau_DK);
        edNhapLaiMK = findViewById(R.id.ed_NhapLaiPass_DK);

        txtDangNhap = findViewById(R.id.txtDangNhap);

        // lắng nghe sự kiện click của button tại trang đăng kí
        btnDangKi.setOnClickListener(this);
        txtDangNhap.setOnClickListener(this);
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

        String thongbao_hoten = getString(R.string.thongbaotendangki);
        String thongbao_sdt = getString(R.string.thongbaosdtdangki);
        String thongbao_diachi = getString(R.string.thongbaodiachidangki);
        String thongbao_email = getString(R.string.thongbaoemail);
        String thongbao_matkhau = getString(R.string.thongbaomatkhau);
        String thongbao_nhaplaimk = getString(R.string.thongbaonhaplaimk);
        final String thongbao_dkthanhcong = getString(R.string.thongbaodangkithanhcong);

        int id = view.getId();

        switch (id){
            case R.id.btn_DangKi:{
                // kiểm tra điều kiện
                if(hoten.trim().length() == 0){
                    edHoTen.setError("Họ tên không bỏ trống");
                    Toast.makeText(this, thongbao_hoten, Toast.LENGTH_SHORT).show();
                }
                else if(diachi.trim().length() == 0){
                    edDiaChi.setError("Địa chỉ không bỏ trống");
                    Toast.makeText(this, thongbao_diachi, Toast.LENGTH_SHORT).show();
                }
                else if(sdt.trim().length() < 10 || sdt.trim().length() > 10){
                    edSdt.setError("Số điện thoại không đúng");
                    Toast.makeText(this, thongbao_sdt, Toast.LENGTH_SHORT).show();
                }
                else if(email.trim().length() == 0){
                    edEmail.setError("Email không đúng");
                    Toast.makeText(this, thongbao_email, Toast.LENGTH_SHORT).show();
                }
                else if(matkhau.trim().length() < 6){
                    edMatKhau.setError("Mật khẩu phải lớn hơn 6 ký tự");
                    Toast.makeText(this, thongbao_matkhau, Toast.LENGTH_SHORT).show();
                }
                else if(!nhaplaimk.equals(matkhau)){
                    edNhapLaiMK.setError("Phải giống mật khẩu ở trên");
                    Toast.makeText(this, thongbao_nhaplaimk, Toast.LENGTH_SHORT).show();
                }
                else {
                    firebaseAuth.createUserWithEmailAndPassword(email, matkhau).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                firebaseAuth.signOut();
                                Toast.makeText(DangKi_Activity.this, thongbao_dkthanhcong , Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }

                break;
            }
            case R.id.txtDangNhap:{
                firebaseAuth.signOut();
                Intent dangnhap = new Intent(this, DangNhap_Activity.class);
                startActivity(dangnhap);

                break;
            }
        }


    }



}
