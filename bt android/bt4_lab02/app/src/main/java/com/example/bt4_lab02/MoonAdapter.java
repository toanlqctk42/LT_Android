package com.example.bt4_lab02;

import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MoonAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Moon> moonList;

    public MoonAdapter(Context context, int layout, List<Moon> moonList) {
        this.context = context;
        this.layout = layout;
        this.moonList = moonList;
    }

    @Override
    public int getCount() {
        return moonList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =inflater.inflate(layout, null);
        TextView txtTen = (TextView)convertView.findViewById(R.id.txtten);
        TextView txtMota = (TextView)convertView.findViewById(R.id.txtmota);
        ImageView imageHinh = (ImageView)convertView.findViewById(R.id.imageHinh);
        Moon moon= moonList.get(position);
        txtTen.setText(moon.getTen());
        txtMota.setText(moon.getMota());
        imageHinh.setImageResource(moon.getHinh());
        return convertView;
    }
}
