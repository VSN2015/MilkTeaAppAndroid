package com.example.milkteaappandroid.Model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.milkteaappandroid.Controller.Interfaces.sanphammoiInterface;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SanPhamModel {
    public  String maSanPham;
    public long gia;
    public  String hinhanhsanpham;
    public  String motasanpham;
    public  String tensanpham;


    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
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

    public SanPhamModel() {
        nodeRoot= FirebaseDatabase.getInstance().getReference();
    }

    public  void getDanhSachSanPhamMoi(final sanphammoiInterface sanphammoiInterface){

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot dataSnapshotSanPham =dataSnapshot.child("sanpham");
                for(DataSnapshot valueSanPham : dataSnapshotSanPham.getChildren()){
                    for (DataSnapshot value : valueSanPham.getChildren()){
                        SanPhamModel sanPhamModel =value.getValue(SanPhamModel.class);
                        sanPhamModel.setMaSanPham(valueSanPham.getKey());
                        //Log.d("kiemtra:",sanPhamModel.getTensanpham());
                        sanphammoiInterface.getDanhSachSanPhamMoiModel(sanPhamModel);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        nodeRoot.addListenerForSingleValueEvent(valueEventListener);

    }
}
