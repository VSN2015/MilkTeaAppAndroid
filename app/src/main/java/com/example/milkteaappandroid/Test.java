package com.example.milkteaappandroid;

public class Test {

    public Test() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    String ten;

    public Long getTuoi() {
        return tuoi;
    }

    public void setTuoi(Long tuoi) {
        this.tuoi = tuoi;
    }

    Long tuoi;

    public Test(String ten,Long tuoi){
        this.ten=ten;
        this.tuoi=tuoi;
    }
}
