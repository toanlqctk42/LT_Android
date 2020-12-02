package com.example.randomso;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText edmin;
    EditText edmax;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        docdulieu();
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String chuoi1 = edmin.getText().toString();
                String chuoi2 = edmax.getText().toString();
                if(chuoi1.isEmpty()||chuoi2.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Vui lòng không để trống",Toast.LENGTH_LONG).show();
                }
                else {
                    int min = Integer.parseInt(chuoi1);
                    int max = Integer.parseInt(chuoi2);

                    if (max < min) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập lại !!! ", Toast.LENGTH_SHORT).show();
                    } else {
                        Random random = new Random();
                        int number = random.nextInt(max - min + 1) + min;
                        textView.setText("số ngẫu nhiên là : " + number);
                    }
                }
            }
        });
    }
    private void docdulieu(){
        edmin = (EditText)findViewById(R.id.editText);
        edmax = (EditText)findViewById(R.id.editTextNumber);
        btnOK = (Button)findViewById(R.id.btnOk);
        textView = (TextView)findViewById(R.id.txtshow);
    }
}