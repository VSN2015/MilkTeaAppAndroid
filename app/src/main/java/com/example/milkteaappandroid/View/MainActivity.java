package com.example.milkteaappandroid.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.milkteaappandroid.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    DatabaseReference databaseReference;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//<<<<<<< HEAD
        //setContentView(R.layout.f_danhsachsanpham);

        // demo cong nghe phan mem.

//        setContentView(R.layout.test1);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
//
//        txtten= findViewById(R.id.txtten);
//        txttuoi=findViewById(R.id.txttuoi);
//
//        btnthem=findViewById(R.id.btnAdd);
//
//        btnthem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String ten=txtten.getText().toString();
//                String tuoi=txttuoi.getText().toString();
//
//                if (ten.equals("")|| tuoi.equals("")){
//                    Toast.makeText(MainActivity.this,"Vui lòng nhập đủ thông tin!!!",Toast.LENGTH_LONG).show();
//                    return;
//                }
//                Test t= new Test(ten,Long.parseLong(tuoi));
//                databaseReference.push().setValue(t).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(MainActivity.this,"Tạo success",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//            }
//        });
//
//        testList = new ArrayList<>();
//
//        adapterTest= new AdapterTest(this,R.layout.item_test,testList);
//
//        listView=findViewById(R.id.lv);
//
//        listView.setAdapter(adapterTest);
//
//        databaseReference.addChildEventListener(this);


        // end demo cnpm






//=======
//>>>>>>> 9f673c7f8fbc3ca500c9e389c248cd32d51b7b03

        setContentView(R.layout.trangchu_layout);

        /*include nav bottom in Home*/
        bottomNavigationView =findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        /* end include nav bottom in Home*/

    }
    /*các class fragment*/
    Home homeFragment= new Home();
    GioHang gioHangFragment= new GioHang();
    DSSanPham dsSanPhamFragment= new DSSanPham();
    ThongBao thongBaoFragment= new ThongBao();
    TaiKhoan taiKhoanFragment = new TaiKhoan();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {  /*sự kiện chọn item nav*/
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.containerHome,homeFragment).commit();
                return true;
            case R.id.nav_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.containerHome,gioHangFragment).commit();
                return true;
            case R.id.nav_product:
                getSupportFragmentManager().beginTransaction().replace(R.id.containerHome,dsSanPhamFragment).commit();
                return true;
            case R.id.nav_notification:
                getSupportFragmentManager().beginTransaction().replace(R.id.containerHome,thongBaoFragment).commit();
                return true;
            case R.id.nav_account:
                getSupportFragmentManager().beginTransaction().replace(R.id.containerHome,taiKhoanFragment).commit();
                return true;

        }
        return false;
    }
}
