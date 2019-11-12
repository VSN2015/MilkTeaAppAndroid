package com.example.milkteaappandroid.View;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ProgressBar;
import android.widget.ViewFlipper;

import com.example.milkteaappandroid.Controller.SanPhamMoiController;
import com.example.milkteaappandroid.Model.QuanModel;
import com.example.milkteaappandroid.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    DatabaseReference databaseReference;
    ViewFlipper viewFlipper;
    SanPhamMoiController sanPhamMoiController;
    RecyclerView recyclerSanPhamMoi;
    ProgressBar progressBar;
    ImageButton imgMap;
    QuanModel quanModel;
    double latitude=0, longitude=0;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // tạo slide================================================================================
        int images[] ={R.drawable.slide1,R.drawable.slide2};

        viewFlipper= view.findViewById(R.id.slideImage);

        for (int img: images) {
            Slider(img);
        }
        // end tạo slide============================================================================
        recyclerSanPhamMoi=view.findViewById(R.id.recycler_spmoi);
        progressBar=view.findViewById(R.id.processbarhome);

        imgMap=view.findViewById(R.id.imgMap);
        quanModel= new QuanModel();
        imgMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference= FirebaseDatabase.getInstance().getReference().child("thongtinquan");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        QuanModel quanModel=dataSnapshot.getValue(QuanModel.class);
                        Intent intent = new Intent(getActivity(),MapActivity.class);
                        intent.putExtra("latitudequan",quanModel.getLatitude());
                        intent.putExtra("longitudequan",quanModel.getLongitude());
                        view.getContext().startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        sanPhamMoiController = new SanPhamMoiController(getContext());

        sanPhamMoiController.getDSSanPhamMoiController(recyclerSanPhamMoi,progressBar);

        //Log.d("vl",getLocationQuan()+"");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // not working

    }



    public void Slider(int image){
        ImageView imageView= new ImageView(getActivity());

        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);

        viewFlipper.setFlipInterval(4000);

        viewFlipper.setAutoStart(true);

        //set animation to slider
        viewFlipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getActivity(),android.R.anim.slide_out_right);
    }

    //public int getLocationQuan(){

//        final Location location = new Location("");
//        ValueEventListener valueEventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                DataSnapshot dataSnapshotTTQuan =dataSnapshot.child("thongtinquan");
//                QuanModel quanModel = dataSnapshotTTQuan.getValue(QuanModel.class);
//                Log.d("vl1",quanModel.getLatitude()+"");
//                location.setLatitude(quanModel.getLatitude());
//                location.setLongitude(quanModel.getLongitude());
//                return;
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        };
//        Log.d("vl",location.getLatitude()+"");
//        databaseReference.addListenerForSingleValueEvent(valueEventListener);
//        Log.d("vl1",location.getLatitude()+"");
//
//        return location;
        //return quanModelList.size();

    //}

}
