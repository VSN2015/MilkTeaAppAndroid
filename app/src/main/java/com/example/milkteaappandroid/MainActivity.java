package com.example.milkteaappandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    DatabaseReference databaseReference;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
