package com.example.milkteaappandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DangNhap_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnDangNhap;
    TextView txtDangKiMoi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap_layout);

//        tìm bên giao diện và gán vào các giá trị
        txtDangKiMoi = (TextView) findViewById(R.id.txt_DangKiMoi);
        btnDangNhap = (ImageButton) findViewById(R.id.btn_DangNhap);


//        lắng nghe sự kiện click của image button, đăng kí mới
        txtDangKiMoi.setOnClickListener(this);
        btnDangNhap.setOnClickListener(this);


    }

//    lắng nghe sự kiện user click vào imgbutton đăng nhập
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btn_DangNhap){
            dangNhap();

        }
    }

//    tạo hàm Đăng nhập
    private void dangNhap(){
//        đang làm tới đây
    }
}
