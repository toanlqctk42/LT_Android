package com.example.multilanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblVietnam;
    private TextView lblEnglish;
    private TextView lblFrance;

    private TextView lblWelcome;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView txtDoNotHaveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
    }
    private void anhxa(){
        lblVietnam = (TextView) findViewById(R.id.txtvietnam);
        lblEnglish = (TextView) findViewById(R.id.txtenglish);
        lblFrance = (TextView) findViewById(R.id.txtprace);
        lblWelcome = (TextView) findViewById(R.id.tvlb);
        txtEmail = (EditText) findViewById(R.id.edEmail);
        txtPassword = (EditText) findViewById(R.id.edpass);
        btnLogin = (Button) findViewById(R.id.btnok);
        txtDoNotHaveAccount = (TextView) findViewById(R.id.tvthongbao);

        lblVietnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleHelper.setLocale(MainActivity.this, "vi");
                setText();
            }
        });

        lblEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleHelper.setLocale(MainActivity.this, "en");
                setText();
            }
        });

        lblFrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleHelper.setLocale(MainActivity.this, "fr");
                setText();
            }
        });
    }
    private void setText() {
        lblWelcome.setText(R.string.welcome);
        txtEmail.setHint(R.string.email);
        txtPassword.setHint(R.string.password);
        btnLogin.setText(R.string.login);
        txtDoNotHaveAccount.setText(R.string.do_not_have_account);
    }

}