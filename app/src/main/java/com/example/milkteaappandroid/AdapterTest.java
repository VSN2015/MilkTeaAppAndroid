package com.example.milkteaappandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterTest extends ArrayAdapter {

    Context context;
    int resource;
    List<Test> objects;
    public AdapterTest(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=layoutInflater.inflate(resource,parent,false);

        TextView txtTen=view.findViewById(R.id.txtTen);

        TextView txtTuoi=view.findViewById(R.id.txtTuoi);

        Test test =objects.get(position);

        txtTen.setText(test.getTen());

        txtTuoi.setText(test.getTuoi().toString());
        return view;
    }
}
