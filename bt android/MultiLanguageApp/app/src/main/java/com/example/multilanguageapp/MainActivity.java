package com.example.multilanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvvn, tve, tvpra ,tvlb ,tvtb;
    EditText edemail , edpass;
    Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        sukien();
    }
    private void anhxa(){
        tvvn = findViewById(R.id.txtvietnam);
        tve =  findViewById(R.id.txtenglish);
        tvpra = findViewById(R.id.txtprace);
        tvlb = findViewById(R.id.tvlb);
        tvtb = findViewById(R.id.tvthongbao);
        edemail = findViewById(R.id.edEmail);
        edpass = findViewById(R.id.edpass);
        btnok = findViewById(R.id.btnok);
    }
    private void sukien(){
        tvvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvlb.setText(R.string.vietnameselb);
                edemail.setHint(R.string.vnEmail);
                edpass.setHint(R.string.vnPass);
                btnok.setText(R.string.vndangnhap);
                tvtb.setText(R.string.vntb);
            }
        });
        tve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvlb.setText(R.string.enghlishlb);
                edemail.setHint(R.string.englishEmail);
                edpass.setHint(R.string.englishPass);
                btnok.setText(R.string.englishdangnhap);
                tvtb.setText(R.string.englishtb);
            }
        });
        tvpra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvlb.setText(R.string.prancelb);
                edemail.setHint(R.string.pranceEmail);
                edpass.setHint(R.string.prancePass);
                btnok.setText(R.string.prancedangnhap);
                tvtb.setText(R.string.prancetb);
            }
        });
    }
}