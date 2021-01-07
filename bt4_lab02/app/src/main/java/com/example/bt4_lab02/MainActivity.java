    package com.example.bt4_lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMoon;
    ArrayList<Moon> moonArrayList;
    MoonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        khoitao();
        adapter = new MoonAdapter(this,R.layout.dong_moon,moonArrayList);
        lvMoon.setAdapter(adapter);
    }
    private void khoitao(){
        lvMoon =(ListView)findViewById(R.id.lvmoon);
        moonArrayList = new ArrayList<>();
        moonArrayList.add(new Moon("Mercury","A small, rocky planet",R.drawable.moon1));
        moonArrayList.add(new Moon("Venus","A small, rocky planet blanketed in a thick layer of yellowish clound",R.drawable.moon2));
        moonArrayList.add(new Moon("Earth","A small, rocky planet which supports a variety of life!",R.drawable.moon3));

    }
}