package com.example.milkteaappandroid.View;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ViewFlipper;

import com.example.milkteaappandroid.Controller.SanPhamMoiController;
import com.example.milkteaappandroid.Model.SanPhamModel;
import com.example.milkteaappandroid.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    public Home() {
        // Required empty public constructor
    }
    ViewFlipper viewFlipper;
    SanPhamMoiController sanPhamMoiController;
    RecyclerView recyclerSanPhamMoi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);

        // tạo slide================================================================================
        int images[] ={R.drawable.slide1,R.drawable.slide2};

        viewFlipper= v.findViewById(R.id.slideImage);

        for (int img: images) {
                Slider(img);
        }
        // end tạo slide============================================================================
        recyclerSanPhamMoi=v.findViewById(R.id.recycler_spmoi);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        sanPhamMoiController = new SanPhamMoiController(getContext());

        sanPhamMoiController.getDSSanPhamMoiController(recyclerSanPhamMoi);
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

}
