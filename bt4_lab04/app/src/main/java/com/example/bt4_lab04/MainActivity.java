package com.example.bt4_lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton ibtnPlay;
    TextView txtdiemso;
    CheckBox cbone, cbtwo, cbthree;
    SeekBar sbone, sbtwo, sbthree;
    int sodiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        sbone.setEnabled(false);
        sbtwo.setEnabled(false);
        sbthree.setEnabled(false);
        txtdiemso.setText(String.valueOf(sodiem));
        CountDownTimer countDownTimer= new CountDownTimer(60000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 3;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                if(sbone.getProgress() >=  sbone.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "LeeSin Win", Toast.LENGTH_SHORT).show();
                    if(cbone.isChecked()){
                        sodiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }else {
                        sodiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    txtdiemso.setText(String.valueOf(sodiem));
                    unlockcheckbox();
                }
                if(sbtwo.getProgress() >=  sbtwo.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Yasuo Win", Toast.LENGTH_SHORT).show();
                    if(cbtwo.isChecked()){
                        sodiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }else {
                        sodiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    txtdiemso.setText(String.valueOf(sodiem));
                    unlockcheckbox();
                }
                if(sbthree.getProgress() >=  sbthree.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Tiger Win", Toast.LENGTH_SHORT).show();
                    if(cbthree.isChecked()){
                        sodiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }else {
                        sodiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    txtdiemso.setText(String.valueOf(sodiem));
                    unlockcheckbox();
                }
                sbone.setProgress(sbone.getProgress()+one);
                sbtwo.setProgress(sbtwo.getProgress()+two);
                sbthree.setProgress(sbthree.getProgress()+three);
            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbone.isChecked() || cbtwo.isChecked() || cbthree.isChecked()) {
                    sbone.setProgress(0);
                    sbtwo.setProgress(0);
                    sbthree.setProgress(0);
                    ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    lockcheckbox();
                }else {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cbtwo.setChecked(false);
                    cbthree.setChecked(false);
                }
            }
        });
        cbtwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cbone.setChecked(false);
                    cbthree.setChecked(false);
                }
            }
        });
        cbthree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cbtwo.setChecked(false);
                    cbone.setChecked(false);
                }
            }
        });
    }
    private void Anhxa(){
        cbone = findViewById(R.id.cbone);
        cbtwo = findViewById(R.id.cbtwo);
        cbthree = findViewById(R.id.cbthree);
        sbone = findViewById(R.id.seekbarone);
        sbtwo = findViewById(R.id.seekbartwo);
        sbthree = findViewById(R.id.seekbarthree);
        txtdiemso = findViewById(R.id.txtdiemso);
        ibtnPlay = findViewById(R.id.ibtnplay);
    }
    private void unlockcheckbox(){
        cbone.setEnabled(true);
        cbtwo.setEnabled(true);
        cbthree.setEnabled(true);
    }
    private void lockcheckbox(){
        cbone.setEnabled(false);
        cbtwo.setEnabled(false);
        cbthree.setEnabled(false);
    }
}