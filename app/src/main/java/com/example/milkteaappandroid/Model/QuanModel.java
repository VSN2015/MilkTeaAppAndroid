package com.example.milkteaappandroid.Model;

import androidx.annotation.NonNull;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class QuanModel {

    public String diachi;

    public String giodongcua;

    public String giomocua;

    public double latitude;

    public double longitude;

    public String tenquan;


    public QuanModel() {

    }

    public QuanModel(String diachi, String giodongcua, String giomocua, double latitude, double longitude, String tenquan) {
        this.diachi = diachi;
        this.giodongcua = giodongcua;
        this.giomocua = giomocua;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tenquan = tenquan;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGiodongcua() {
        return giodongcua;
    }

    public void setGiodongcua(String giodongcua) {
        this.giodongcua = giodongcua;
    }

    public String getGiomocua() {
        return giomocua;
    }

    public void setGiomocua(String giomocua) {
        this.giomocua = giomocua;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTenquan() {
        return tenquan;
    }

    public void setTenquan(String tenquan) {
        this.tenquan = tenquan;
    }



}
