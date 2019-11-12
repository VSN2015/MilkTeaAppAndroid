package com.example.milkteaappandroid.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.milkteaappandroid.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {
    BottomNavigationView bottomNavigationView;

    GoogleApiClient googleApiClient;

    SharedPreferences sharedPreferences;

    public static final int REQUEST_PERMISSION_LOCATION=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.trangchu_layout);

        sharedPreferences=getSharedPreferences("toado",MODE_PRIVATE);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        int checkPermissionLocation = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if(checkPermissionLocation!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_PERMISSION_LOCATION);
        }
        else {
            googleApiClient.connect();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        /*include nav bottom in Home*/
        bottomNavigationView =findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        /* end include nav bottom in Home*/

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_PERMISSION_LOCATION:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    googleApiClient.connect();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        googleApiClient.disconnect();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Location vitrihientai = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if(vitrihientai!=null) {
            Log.d("sang", vitrihientai.getLongitude() + " + " +vitrihientai.getLatitude());
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.putString("latitude", String.valueOf(vitrihientai.getLatitude()));
            editor.putString("longitude", String.valueOf(vitrihientai.getLongitude()));
            editor.commit();


        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
