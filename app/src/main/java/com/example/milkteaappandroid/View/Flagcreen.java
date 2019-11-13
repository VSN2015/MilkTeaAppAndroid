package com.example.milkteaappandroid.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.milkteaappandroid.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Flagcreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flagcreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Flagcreen.this, DangNhap_Activity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}
