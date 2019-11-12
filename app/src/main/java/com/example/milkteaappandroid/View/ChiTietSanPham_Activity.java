package com.example.milkteaappandroid.View;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.milkteaappandroid.Model.SanPhamChinaModel;
import com.example.milkteaappandroid.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ChiTietSanPham_Activity extends AppCompatActivity {
    TextView tbxTensp,tbxgia,tbxMota,tbxSL;
    ImageView hinhanh;
    SanPhamChinaModel sanPhamChinaModel;
    ImageButton button,buttonAdd,buttonRemove;
    Button thanhToan;
    int sl= 0;
    float gia=0;
   RadioGroup gr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_goods);

        sanPhamChinaModel = getIntent().getParcelableExtra("sanPham");
        tbxTensp = findViewById(R.id.tbxTenSp);
        tbxgia = findViewById(R.id.tbxGia);
        tbxMota = findViewById(R.id.tbxMoTa);
        hinhanh = findViewById(R.id.imageHinhSp);
        button = findViewById(R.id.btnBack);
        buttonAdd = findViewById(R.id.imgButtonAdd);
        buttonRemove = findViewById(R.id.imgButtonRemove);
        tbxSL = findViewById(R.id.tbxSL);
        thanhToan = findViewById(R.id.btnThanhToan);
        gr = findViewById(R.id.gr);
        gr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rdL)
                {
                    tbxgia.setText(sanPhamChinaModel.getGia()+"");

                }
                if (i==R.id.rdM)
                {
                    tbxgia.setText((sanPhamChinaModel.getGia()+sanPhamChinaModel.getGia()*0.2)+"");
                }
                sl= 0;
                gia =0;
                tbxSL.setText(sl+"");
                thanhToan.setText(gia+"");
            }
        });






        //Hàm này để quay lại trang danh sách sản phẩm
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //Hàm này để tăng số lượng sản phẩm
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sl >=0)
                {
                    sl+=1;
                    tbxSL.setText(sl+"");
                    gia = sl* Float.parseFloat(tbxgia.getText().toString());
                    thanhToan.setText(gia+"");
                }
            }
        });
        //Hàm này để giảm số lượng
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sl>0)
                {
                    sl-=1;
                    tbxSL.setText(sl+"");
                    gia = sl*Float.parseFloat(tbxgia.getText().toString());
                    thanhToan.setText(gia+"");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        tbxTensp.setText(sanPhamChinaModel.getTensanpham());
        tbxgia.setText(sanPhamChinaModel.getGia().toString());
        tbxMota.setText(sanPhamChinaModel.getMotasanpham());
        StorageReference storageHinhAnh = FirebaseStorage.getInstance().getReference().child("hinhanhsp").child(sanPhamChinaModel.getHinhanhsanpham());
        storageHinhAnh.getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Use the bytes to display the image
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                //Bitmap bitmap = BitmapFactory.
                hinhanh.setImageBitmap(bitmap);
            }
            });
    }

}

