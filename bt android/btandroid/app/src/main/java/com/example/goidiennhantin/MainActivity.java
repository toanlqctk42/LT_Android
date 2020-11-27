package com.example.goidiennhantin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    Button btnCall ,btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCall = (Button)findViewById(R.id.btncall);
        btnSend = (Button)findViewById(R.id.btnsend);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0335816131"));
                startActivity(intent);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "0335816131"));
                startActivity(intent);
            }
        });
    }
    private void checkandrequestpermissons(){
        String[] permissons = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS
        };
        List<String> listpermissonneeded= new ArrayList<>();
        for (String permission : permissons){
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listpermissonneeded.add(permission);
            }
        }
        if (!listpermissonneeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listpermissonneeded.toArray(new String[listpermissonneeded.size()]), 1);
        }

    }
}
