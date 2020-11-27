package com.example.bt5_lab02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RapAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<RapGenius> arrayList;

    public RapAdapter(Context context, int layout, ArrayList<RapGenius> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class Viewhoder{
        TextView ten;
        TextView follow;
        ImageView imgHinh;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewhoder viewhoder;
        if(convertView == null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewhoder = new Viewhoder();

            viewhoder.ten = (TextView)convertView.findViewById(R.id.txtten);
            viewhoder.follow =(TextView)convertView.findViewById(R.id.txtfollow);
            viewhoder.imgHinh =(ImageView)convertView.findViewById(R.id.imgview);
            convertView.setTag(viewhoder);
        }else {
            viewhoder = (Viewhoder) convertView.getTag();

        }
        viewhoder.ten.setText(arrayList.get(position).getTen());
        viewhoder.follow.setText(arrayList.get(position).getFollow());
        viewhoder.imgHinh.setImageResource(arrayList.get(position).getHinh());
        return convertView;
    }
}
