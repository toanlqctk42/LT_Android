package com.example.nghegoinhantin;

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
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText ed1;
    Button btncall, btnmessenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAndRequesPermissons();
        anhxa();
        callandsms();
    }

    private  void anhxa(){
        ed1 = findViewById(R.id.editTextPhone);
        btncall = findViewById(R.id.btncall);
        btnmessenge = findViewById(R.id.btnmessenge);
    }
    private void checkAndRequesPermissons(){
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS
        };
        List<String> ListPermissionsNeeded = new ArrayList<>();
        for (String pemission : permissions){
            if (ContextCompat.checkSelfPermission(this,pemission)!= PackageManager.PERMISSION_GRANTED){
                ListPermissionsNeeded.add(pemission);
            }
        }
        if (!ListPermissionsNeeded.isEmpty()){
            ActivityCompat.requestPermissions(this,ListPermissionsNeeded.toArray(new String[ListPermissionsNeeded.size()]),1);
        }
    }
    private void callandsms(){
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = ed1.getText().toString();
                if(phone.isEmpty()){
                    Toast.makeText(getApplication(),"Vui lòng nhập số",Toast.LENGTH_LONG).show();
                }else{
                    String s = "tel:" + phone;
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                }
            }
        });
        btnmessenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = ed1.getText().toString();
                if(phone.isEmpty()){
                    Toast.makeText(getApplication(),"Vui lòng nhập số",Toast.LENGTH_LONG).show();
                }else{
                    String s = "sms:" + phone;
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                }
            }
        });
    }
}