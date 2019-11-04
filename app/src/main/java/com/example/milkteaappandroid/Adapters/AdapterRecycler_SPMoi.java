package com.example.milkteaappandroid.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.milkteaappandroid.Model.SanPhamModel;
import com.example.milkteaappandroid.R;

import java.util.List;

public class AdapterRecycler_SPMoi extends RecyclerView.Adapter<AdapterRecycler_SPMoi.ViewHolder> {
    List<SanPhamModel>sanPhamModelList;
    int resource;
    public AdapterRecycler_SPMoi(List<SanPhamModel>sanPhamModelList,int resource){
        this.sanPhamModelList=sanPhamModelList;
        this.resource=resource;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenSanPham;
        TextView txtGia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenSanPham=itemView.findViewById(R.id.txttensp);
            //txtGia =itemView.findViewById(R.id.txtgia);
        }
    }

    @NonNull
    @Override
    public AdapterRecycler_SPMoi.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        ViewHolder  viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycler_SPMoi.ViewHolder holder, int position) {
        SanPhamModel sanPhamModel = sanPhamModelList.get(position);

        Log.d("kiemtra wwtf",sanPhamModel.getMotasanpham());
        holder.txtTenSanPham.setText(sanPhamModel.getTensanpham());
        //holder.txtGia.setText(sanPhamModel.get);


    }

    @Override
    public int getItemCount() {
        return sanPhamModelList.size();
    }


}
