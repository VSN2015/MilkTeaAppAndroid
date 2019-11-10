package com.example.milkteaappandroid.Model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.milkteaappandroid.Controller.Interfaces.SanPhamChinaInterface;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SanPhamChinaModel {

    public String maSanPham;
    public String hinhanhsanpham;
    public String motasanpham;
    public String tensanpham;
    public Long gia;

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getHinhanhsanpham() {
        return hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        this.hinhanhsanpham = hinhanhsanpham;
    }

    public String getMotasanpham() {
        return motasanpham;
    }

    public void setMotasanpham(String motasanpham) {
        this.motasanpham = motasanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }


    DatabaseReference nodeRoot;

    public SanPhamChinaModel() {
        nodeRoot = FirebaseDatabase.getInstance().getReference();
    }

    public void getDanhSachSanPhamChina(final SanPhamChinaInterface sanPhamChinaInterface) {

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot dataSnapshotSanPham = dataSnapshot.child("sanpham");
                for (DataSnapshot valueSanPham : dataSnapshotSanPham.getChildren()) {
                    for (DataSnapshot value : valueSanPham.getChildren()) {
                        SanPhamChinaModel sanPhamChinaModel = value.getValue(SanPhamChinaModel.class);
                        sanPhamChinaInterface.getDanhSachSanPhamChinaModel(sanPhamChinaModel);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        nodeRoot.addListenerForSingleValueEvent(valueEventListener);

    }

//    public void getDanhSachSanPhamChina() {
//        Log.d("Hello","Runnnn");
//        final List<SanPhamChinaModel> chinaModelList = new ArrayList<>();
//
//        ChildEventListener childEventListener = new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                Log.d( "china:",dataSnapshot.getKey());
//
//                DataSnapshot dataSnapshotSanPham = dataSnapshot.child("sanpham");
//                for (DataSnapshot MaTheLoai : dataSnapshotSanPham.getChildren())
//                {
//                    for (DataSnapshot MaSanPham : MaTheLoai.getChildren())
//                    {
//
//                        SanPhamChinaModel sanPhamChinaModel = MaSanPham.getValue(SanPhamChinaModel.class);
//                        Log.d("china",sanPhamChinaModel.getTensanpham()+"");
//                        chinaModelList.add(sanPhamChinaModel);
//                    }
//
//
//                }
//
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        };
//        nodeRoot.addChildEventListener(childEventListener);
//        Log.d("China",chinaModelList.size()+"");
//    }
}
