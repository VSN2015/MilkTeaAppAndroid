package com.example.milkteaappandroid.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.milkteaappandroid.Controller.SanPhamChinaControler;
import com.example.milkteaappandroid.Model.SanPhamChinaModel;
import com.example.milkteaappandroid.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DSSanPham extends Fragment {

    SanPhamChinaControler sanPhamChinaControler;

    RecyclerView recyclerDanhSachSanPham;

    public DSSanPham() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_dssan_pham, container, false);
        recyclerDanhSachSanPham = view.findViewById(R.id.goods);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
       sanPhamChinaControler = new SanPhamChinaControler(getContext());
        sanPhamChinaControler.getDanhSachSanPham(recyclerDanhSachSanPham);

    }
}
