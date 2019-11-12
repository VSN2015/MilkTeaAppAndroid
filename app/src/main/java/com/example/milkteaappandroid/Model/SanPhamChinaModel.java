package com.example.milkteaappandroid.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.milkteaappandroid.Controller.Interfaces.SanPhamChinaInterface;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SanPhamChinaModel implements Parcelable {

    public String maSanPham;
    public String hinhanhsanpham;
    public String motasanpham;
    public String tensanpham;
    public Long gia;

    protected SanPhamChinaModel(Parcel in) {
        maSanPham = in.readString();
        hinhanhsanpham = in.readString();
        motasanpham = in.readString();
        tensanpham = in.readString();
        if (in.readByte() == 0) {
            gia = null;
        } else {
            gia = in.readLong();
        }
    }

    public static final Creator<SanPhamChinaModel> CREATOR = new Creator<SanPhamChinaModel>() {
        @Override
        public SanPhamChinaModel createFromParcel(Parcel in) {
            return new SanPhamChinaModel(in);
        }

        @Override
        public SanPhamChinaModel[] newArray(int size) {
            return new SanPhamChinaModel[size];
        }
    };

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getHinhanhsanpham() {
        return hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        this.hinhanhsanpham = hinhanhsanpham;
    }

    public String getMotasanpham() {
        return motasanpham;
    }

    public void setMotasanpham(String motasanpham) {
        this.motasanpham = motasanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }


    DatabaseReference nodeRoot;

    public SanPhamChinaModel() {
        nodeRoot = FirebaseDatabase.getInstance().getReference();
    }

    public void getDanhSachSanPhamChina(final SanPhamChinaInterface sanPhamChinaInterface) {

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot dataSnapshotSanPham = dataSnapshot.child("sanpham");
                for (DataSnapshot valueSanPham : dataSnapshotSanPham.getChildren()) {
                    for (DataSnapshot value : valueSanPham.getChildren()) {
                        SanPhamChinaModel sanPhamChinaModel = value.getValue(SanPhamChinaModel.class);
                        sanPhamChinaInterface.getDanhSachSanPhamChinaModel(sanPhamChinaModel);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        nodeRoot.addListenerForSingleValueEvent(valueEventListener);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(maSanPham);
        parcel.writeString(hinhanhsanpham);
        parcel.writeString(motasanpham);
        parcel.writeString(tensanpham);
        if (gia == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(gia);
        }
    }

//    public void getDanhSachSanPhamChina() {
//        Log.d("Hello","Runnnn");
//        final List<SanPhamChinaModel> chinaModelList = new ArrayList<>();
//
//        ChildEventListener childEventListener = new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                Log.d( "china:",dataSnapshot.getKey());
//
//                DataSnapshot dataSnapshotSanPham = dataSnapshot.child("sanpham");
//                for (DataSnapshot MaTheLoai : dataSnapshotSanPham.getChildren())
//                {
//                    for (DataSnapshot MaSanPham : MaTheLoai.getChildren())
//                    {
//
//                        SanPhamChinaModel sanPhamChinaModel = MaSanPham.getValue(SanPhamChinaModel.class);
//                        Log.d("china",sanPhamChinaModel.getTensanpham()+"");
//                        chinaModelList.add(sanPhamChinaModel);
//                    }
//
//
//                }
//
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        };
//        nodeRoot.addChildEventListener(childEventListener);
//        Log.d("China",chinaModelList.size()+"");
//    }
}
