package com.example.custom_button;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Button btntoast,btndialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        btntoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showtoast();
            }
        });
        btndialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog();
            }
        });
    }
    private void showdialog(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_login);
        dialog.setCanceledOnTouchOutside(false);
        final EditText ed1 = (EditText) dialog.findViewById(R.id.edusername);
        final EditText ed2 = (EditText) dialog.findViewById(R.id.edpassword);
        Button btnok = (Button) dialog.findViewById(R.id.btndongy);
        Button btncancel = (Button) dialog.findViewById(R.id.btnthoat);

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = ed1.getText().toString().trim();
                String pass = ed2.getText().toString().trim();

                if(user.equals("quoctoan") && pass.equals("123")){
                    Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"Lỗi đăng nhập",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
    private void anhxa(){
        btntoast = findViewById(R.id.btntoast);
        btndialog = findViewById(R.id.btndialog);
    }
    private void showtoast() {
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.toast_root));

        Toast toast = new Toast(getApplicationContext());

        toast.setGravity(Gravity.CENTER ,0 ,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}