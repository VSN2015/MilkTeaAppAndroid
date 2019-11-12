package com.example.milkteaappandroid.Model;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.PolyUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParserPolyline {

    public ParserPolyline(){

    }

    public static List<LatLng> LayDanhSachDuongDi(String dataJSON){
        List<LatLng> latLngs= new ArrayList<>();
        try {
            JSONObject jsonObject= new JSONObject(dataJSON);
            JSONArray routes = jsonObject.getJSONArray("routes");
            for (int i=0;i<routes.length();i++){
                JSONObject jsonObjectArray = routes.getJSONObject(i);
                JSONObject overviewPolyline = jsonObjectArray.getJSONObject("overview_polyline");
                String points = overviewPolyline.getString("points");
                latLngs= PolyUtil.decode(points);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return latLngs;
    }
}
