package com.example.milkteaappandroid.Controller;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.milkteaappandroid.Adapters.AdapterRecycler_SPMoi;
import com.example.milkteaappandroid.Controller.Interfaces.sanphammoiInterface;
import com.example.milkteaappandroid.Model.SanPhamModel;
import com.example.milkteaappandroid.R;

import java.util.ArrayList;
import java.util.List;

public class SanPhamMoiController {
    Context context;
    SanPhamModel sanPhamModel;
    AdapterRecycler_SPMoi adapterRecycler_spMoi;
    List<SanPhamModel> sanPhamModelList;

    public SanPhamMoiController(Context context){
        this.context=context;
        sanPhamModel = new SanPhamModel();
    }
    public void getDSSanPhamMoiController(RecyclerView recyclerView){
        sanPhamModelList = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager);

        adapterRecycler_spMoi = new AdapterRecycler_SPMoi(sanPhamModelList, R.layout.itemsanpham_layout);

        recyclerView.setAdapter(adapterRecycler_spMoi);

        sanphammoiInterface sanphammoiInterface = new sanphammoiInterface() {
            @Override
            public void getDanhSachSanPhamMoiModel(SanPhamModel sanPhamModel) {
                sanPhamModelList.add(sanPhamModel);
                adapterRecycler_spMoi.notifyDataSetChanged();

            }
        };
        sanPhamModel.getDanhSachSanPhamMoi(sanphammoiInterface);
    }
}
