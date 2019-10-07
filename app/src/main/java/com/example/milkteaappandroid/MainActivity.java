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
<<<<<<< HEAD

        /*include nav bottom in Home*/

        setContentView(R.layout.trangchu_layout);

        bottomNavigationView =findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

=======
        setContentView(R.layout.trangchu_layout);

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








        /*include nav bottom in Home*/
        bottomNavigationView =findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

>>>>>>> 5ae5527696d95c1d3f53decfac838da30719e844
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
