package com.example.bt5_lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<RapGenius> arrayList;
    RapAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.grvrap);
        arrayList = new ArrayList<>();
        arrayList.add(new RapGenius("Maboo","283,297",R.drawable.maboo));
        arrayList.add(new RapGenius("SameOldShawn","252,433",R.drawable.same));
        arrayList.add(new RapGenius("Magnitude901","164,935",R.drawable.magni));
        arrayList.add(new RapGenius("Brandon","100,466",R.drawable.brandon));
        arrayList.add(new RapGenius("Clement_RGF","93,932",R.drawable.clement));
        arrayList.add(new RapGenius("Nebja","84,187",R.drawable.nebja));
        arrayList.add(new RapGenius("BBDS","81,762",R.drawable.bbds));
        arrayList.add(new RapGenius("PleaseDe_ModMe","79,243",R.drawable.please));
        arrayList.add(new RapGenius("DLizzle","76,331",R.drawable.dlizzle));
        arrayList.add(new RapGenius("palacelight","75,497",R.drawable.palace));
        arrayList.add(new RapGenius("The DarkKnight","69,138",R.drawable.thedarkknight));
        arrayList.add(new RapGenius("hellrel","68,903",R.drawable.hellrel));
        adapter = new RapAdapter(this,R.layout.customgridview,arrayList);
        gridView.setAdapter(adapter);




    }
}