package com.example.bt3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    GridView gridView;
    ListView listView;
    TextView textView;
    String[] lvitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setdulieu();
        setSpinner();
        setListView();
        setGridView();
    }
    private void setdulieu(){
        spinner = (Spinner)findViewById(R.id.spn1);
        gridView = (GridView)findViewById(R.id.grv1);
        listView =(ListView)findViewById(R.id.lv1);
        textView =(TextView)findViewById(R.id.textView3);

    }
    private  void setGridView(){
        lvitem = getResources().getStringArray(R.array.hedieuhanh);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lvitem);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = adapter.getItem(position);
                textView.setText(text);
            }
        });
    }
    private void setListView(){
        lvitem = getResources().getStringArray(R.array.hedieuhanh);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lvitem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = adapter.getItem(position);
                textView.setText(text);
            }
        });

    }
    private void setSpinner(){
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.hedieuhanh,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        textView.setText(text);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
