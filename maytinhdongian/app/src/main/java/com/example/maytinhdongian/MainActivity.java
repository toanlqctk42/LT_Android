package com.example.maytinhdongian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed1 , ed2 ;
    Button btncong , btntru , btnnhan, btnchia;
    TextView txt1, txt2 , txt3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.ednumber1);
        ed2 = (EditText)findViewById(R.id.edmunber2);
        btncong = (Button)findViewById(R.id.btncong);
        btntru =  (Button)findViewById(R.id.btntru);
        btnnhan = (Button)findViewById(R.id.btnnhan);
        btnchia = (Button)findViewById(R.id.btnchia);
        txt1 = (TextView)findViewById(R.id.textView);
        txt2 = (TextView)findViewById(R.id.textView2);
        txt3 = (TextView)findViewById(R.id.textView3);

        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 = ed1.getText().toString();
                String chuoi2 = ed2.getText().toString();
                double so1 = Double.parseDouble(chuoi1);
                double so2 = Double.parseDouble(chuoi2);
                double so3 = so1 + so2;
                txt1.setText("X : ");
                txt2.setText("Y : ");
                txt3.setText("KQ = "+ so3);
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 = ed1.getText().toString();
                String chuoi2 = ed2.getText().toString();
                double so1 = Double.parseDouble(chuoi1);
                double so2 = Double.parseDouble(chuoi2);
                double so3 = 0;
                if(so1 >= so2) {
                    txt1.setText("số bị trừ : ");
                    txt2.setText("số trừ : ");
                    so3 = so1 - so2;
                }
                else{
                    txt2.setText("số bị chia : ");
                    txt1.setText("số chia : ");
                    so3 = so2 - so1;
                }
                txt3.setText("KQ = "+ so3);
            }
        });
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 = ed1.getText().toString();
                String chuoi2 = ed2.getText().toString();
                double so1 = Double.parseDouble(chuoi1);
                double so2 = Double.parseDouble(chuoi2);
                double so3 = so1 * so2;
                txt1.setText("X : ");
                txt2.setText("Y : ");
                txt3.setText("KQ = "+ so3);
            }
        });
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 = ed1.getText().toString();
                String chuoi2 = ed2.getText().toString();
                double so1 = Double.parseDouble(chuoi1);
                double so2 = Double.parseDouble(chuoi2);
                double so3 = 0;
                if(so1 >= so2) {
                    txt1.setText("số bị chia : ");
                    txt2.setText("số chia : ");
                    so3 = so1 / so2;
                }
                else{
                    txt2.setText("số bị chia : ");
                    txt1.setText("số chia : ");
                    so3 = so2 / so1;
                }
                txt3.setText("KQ = "+ so3);
            }
        });
    }

}