package com.example.milkteaappandroid.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.milkteaappandroid.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DSSanPham extends Fragment {


    public DSSanPham() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dssan_pham, container, false);
    }

}
