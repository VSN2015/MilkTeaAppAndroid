package com.example.milkteaappandroid.View;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;

import com.example.milkteaappandroid.Controller.MapController;
import com.example.milkteaappandroid.Model.GPSTracker;
import com.example.milkteaappandroid.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap googleMap;
    SupportMapFragment mapFragment;
    MapController mapController;
    double latitude=0, longitude=0;
    Location vitrihientai;
    String duongdan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_map);
        mapController = new MapController();
        latitude=getIntent().getDoubleExtra("latitudequan",0);
        longitude=getIntent().getDoubleExtra("longitudequan",0);

        GPSTracker gps = new GPSTracker(MapActivity.this);
        vitrihientai= new Location("");
        vitrihientai.setLatitude(gps.getLatitude());
        vitrihientai.setLongitude(gps.getLongitude());

        duongdan="https://maps.googleapis.com/maps/api/directions/json?origin="+vitrihientai.getLatitude()+","+vitrihientai.getLongitude()+"&destination="+latitude+","+longitude+"&key=AIzaSyCSNQCX6UYnoiq-BSoaHRdQvmPovWRQeSY";
    }
    @Override
    protected void onStart() {
        super.onStart();

        mapFragment= (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        if(mapFragment!=null){
            mapFragment.getMapAsync(this);
        }

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googleMap=googleMap;

        googleMap.clear();

        LatLng latLng= new LatLng(vitrihientai.getLatitude(),vitrihientai.getLongitude());

        MarkerOptions markerOptions=new MarkerOptions();

        markerOptions.position(latLng);

        googleMap.addMarker(markerOptions);



        LatLng vitriquan= new LatLng(latitude,longitude);

        MarkerOptions markerOptionsQuan=new MarkerOptions();

        markerOptionsQuan.position(vitriquan);

        googleMap.addMarker(markerOptionsQuan);



        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng,14);

        googleMap.moveCamera(cameraUpdate);

        mapController.HienThiDuongDenQuan(googleMap,duongdan);

    }


}
