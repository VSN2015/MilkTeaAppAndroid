package com.example.milkteaappandroid.Adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.milkteaappandroid.Model.SanPhamChinaModel;
import com.example.milkteaappandroid.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class AdapterDanhSachSanPhamChina extends RecyclerView.Adapter<AdapterDanhSachSanPhamChina.ViewHolder> {

    List <SanPhamChinaModel> sanPhamChinaModelList;
    int resource;
    public  AdapterDanhSachSanPhamChina (List <SanPhamChinaModel> sanPhamChinaModelList,int resource)
    {
        this.sanPhamChinaModelList = sanPhamChinaModelList;
        this.resource = resource;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tensanpham;
        TextView gia;
        ImageView hinhAnhSanPham;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tensanpham = itemView.findViewById(R.id.txttensp);
            gia = itemView.findViewById(R.id.txtgia);
            hinhAnhSanPham = itemView.findViewById(R.id.hinhAnhSanPham);
        }
    }


    @NonNull
    @Override
    public AdapterDanhSachSanPhamChina.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterDanhSachSanPhamChina.ViewHolder holder, final int position) {
        final SanPhamChinaModel sanPhamChinaModel = sanPhamChinaModelList.get(position);
        holder.tensanpham.setText(sanPhamChinaModel.getTensanpham());
        holder.gia.setText(sanPhamChinaModel.getGia().toString());
        StorageReference storageHinhAnh = FirebaseStorage.getInstance().getReference().child("hinhanhsp").child(sanPhamChinaModel.getHinhanhsanpham());
//        long ONE_MEGABYTE =158 * 181;
//        storageHinhAnh.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//            @Override
//            public void onSuccess(byte[] bytes) {
//                //Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
//                //Bitmap bitmap = BitmapFactory.
//               // holder.hinhAnhSanPham.setImageBitmap(bitmap);
//            }
//        });
        storageHinhAnh.getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Use the bytes to display the image
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                //Bitmap bitmap = BitmapFactory.
               holder.hinhAnhSanPham.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

    }

    @Override
    public int getItemCount() {
        return sanPhamChinaModelList.size();
    }


}
