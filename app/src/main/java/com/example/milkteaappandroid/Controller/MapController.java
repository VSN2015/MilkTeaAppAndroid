package com.example.milkteaappandroid.Controller;

import android.util.Log;

import com.example.milkteaappandroid.Model.DownloadPolyline;
import com.example.milkteaappandroid.Model.ParserPolyline;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MapController {
    ParserPolyline parserPolyline;

    DownloadPolyline downloadPolyline;

    public MapController(){

    }

    public void HienThiDuongDenQuan(GoogleMap googleMap,String path){
        parserPolyline=new ParserPolyline();

        downloadPolyline= new DownloadPolyline();

        downloadPolyline.execute(path);

        try {
            String dataJSON = downloadPolyline.get();
            List<LatLng>latLngs= ParserPolyline.LayDanhSachDuongDi(dataJSON);
            PolylineOptions polylineOptions = new PolylineOptions();
            for (LatLng toado : latLngs){
                polylineOptions.add(toado);
            }

            Polyline polyline = googleMap.addPolyline(polylineOptions);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
