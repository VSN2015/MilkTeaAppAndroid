package com.example.milkteaappandroid.Controller;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.milkteaappandroid.Adapters.AdapterDanhSachSanPhamChina;
import com.example.milkteaappandroid.Controller.Interfaces.SanPhamChinaInterface;
import com.example.milkteaappandroid.Model.SanPhamChinaModel;
import com.example.milkteaappandroid.Model.SanPhamModel;
import com.example.milkteaappandroid.R;

import java.util.ArrayList;
import java.util.List;

public class SanPhamChinaControler {
    Context context;
    SanPhamChinaModel sanPhamChinaModel;
    AdapterDanhSachSanPhamChina adapterDanhSachSanPhamChina;

    public SanPhamChinaControler(Context context) {
        this.context = context;
        sanPhamChinaModel = new SanPhamChinaModel();

    }

    public void getDanhSachSanPham(Context context,final RecyclerView recyclerView, final ProgressBar progressBar) {
        final List<SanPhamChinaModel> sanPhamChinaModelList = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(layoutManager);

        adapterDanhSachSanPhamChina = new AdapterDanhSachSanPhamChina(context,sanPhamChinaModelList, R.layout.itemsanpham_layout);

        recyclerView.setAdapter(adapterDanhSachSanPhamChina);
        SanPhamChinaInterface sanPhamChinaInterface = new SanPhamChinaInterface() {
            @Override
            public void getDanhSachSanPhamChinaModel(SanPhamChinaModel sanPhamChinaModel) {


        sanPhamChinaModelList.add(sanPhamChinaModel);
               // Log.d("China",sanPhamChinaModel.getHinhanhsanpham()+"");
        adapterDanhSachSanPhamChina.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
            }
        };
        sanPhamChinaModel.getDanhSachSanPhamChina(sanPhamChinaInterface);
    }
}
