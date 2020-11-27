package com.example.seekbarcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar sbr , sbg, sbb;
    TextView txtred, txtgreen, txtblue ,tvRBG,tvCMY;
    int r=0,g=0,b=0,c=0,m=0,y=0;
    private  void anhxa() {
        sbr = (SeekBar)findViewById(R.id.seekbarred);
        sbg = (SeekBar)findViewById(R.id.seekbargreen);
        sbb = (SeekBar)findViewById(R.id.seekbarblue);
        txtred = (TextView)findViewById(R.id.txtred);
        txtgreen = (TextView)findViewById(R.id.txtgreen);
        txtblue = (TextView)findViewById(R.id.txtblue);
        tvRBG =(TextView)findViewById(R.id.tvRGB);
        tvCMY =(TextView)findViewById(R.id.tvCMY);
        txtred.setText("R = "+ 0);
        txtgreen.setText("G = "+ 0);
        txtblue.setText("B = "+ 0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        seekbar();
    }
    private void seekbar(){

        this.sbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtred.setText("R = "+ String.valueOf(progress));
                r = progress;
                c = 255-r;
                tvRBG.setBackgroundColor(Color.rgb(r,g,b));
                tvCMY.setBackgroundColor(Color.rgb(c,m,y));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        this.sbg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtgreen.setText("G = "+ String.valueOf(progress));
                g = progress;
                m = 255-g;
                tvRBG.setBackgroundColor(Color.rgb(r,g,b));
                tvCMY.setBackgroundColor(Color.rgb(c,m,y));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        this.sbb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtblue.setText("B = "+ String.valueOf(progress));
                b = progress;
                y = 255-b;
                tvRBG.setBackgroundColor(Color.rgb(r,g,b));
                tvCMY.setBackgroundColor(Color.rgb(c,m,y));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}