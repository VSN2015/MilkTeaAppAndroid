package com.example.milkteaappandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ChildEventListener {
    DatabaseReference databaseReference;
    AdapterTest adapterTest;
    List<Test> testList;
    ListView listView;

    EditText txtten, txttuoi;
    Button btnthem;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_danhsachsanpham);

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

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        Test test =dataSnapshot.getValue(Test.class);
        testList.add(test);
        adapterTest.notifyDataSetChanged();
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        testList.clear();
        databaseReference.removeEventListener(this);
        databaseReference.addChildEventListener(this);
    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
        testList.clear();
        databaseReference.removeEventListener(this);
        databaseReference.addChildEventListener(this);
    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
