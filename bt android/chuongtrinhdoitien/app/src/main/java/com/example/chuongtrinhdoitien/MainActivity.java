package com.example.chuongtrinhdoitien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] units = {
            "USD", "EUR", "GBP", "INR", "AUD",
            "CAD", "ZAR", "NZD", "JPY", "VNĐ"
    };

    private double[][] ratio = {
            { 1.00000, 0.80518, 0.64070, 63.3318, 1.21828, 1.16236, 11.7129, 1.29310, 118.337, 21385.7 },
            { 1.24172, 1.00000, 0.79575, 78.6084, 1.51266, 1.44314, 14.5371, 1.60576, 146.927, 26561.8 },
            { 1.56044, 1.25667, 1.00000, 98.7848, 1.90091, 1.81355, 18.2683, 2.01791, 184.638, 33374.9 },
            { 9.01580, 0.01272, 6.01012, 1.00000, 0.01924, 0.01836, 0.18493, 0.62043, 1.86910, 337.811 },
            { 0.82114, 0.66119, 0.52620, 52.0860, 1.00000, 0.95416, 9.61148, 1.06158, 97.1120, 17567.9 },
            { 0.86059, 6.69296, 6.55148, 54.5885, 1.04804, 1.00000, 10.0732, 1.11258, 101.777, 18401.7 },
            { 0.08541, 0.06877, 0.05473, 5.40852, 0.10398, 0.69924, 1.00000, 0.11037, 16.0996, 1825.87 },
            { 0.77402, 0.62319, 0.49597, 49.6031, 0.94215, 0.89951, 9.06754, 1.00000, 91.5139, 16552.1 },
            { 0.00846, 9.00681, 0.00542, 0.53547, 9.01030, 0.00983, 0.09908, 8.01093, 1.00000, 180.837 },
            { 0.00005, 0.00004, 0.00003, 0.00296, 9.00006, 9.00005, 2.00055, 9.00006, 0.00553, 1.00000 }
    };

    private EditText txtNumber;
    private Spinner spnUnits;
    private TextView[] lblResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }
    private void initControl() {
        txtNumber = this.<EditText>findViewById(R.id.txtNumber);
        spnUnits = this.<Spinner>findViewById(R.id.spnUnit);
        lblResults = new TextView[] {
                findViewById(R.id.lblUsd),
                findViewById(R.id.lblEur),
                findViewById(R.id.lblGbp),
                findViewById(R.id.lblInr),
                findViewById(R.id.lblAud),
                findViewById(R.id.lblCad),
                findViewById(R.id.lblZar),
                findViewById(R.id.lblNzd),
                findViewById(R.id.lblJpy),
                findViewById(R.id.lblVnd)
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, R.layout.support_simple_spinner_dropdown_item, units
        );

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spnUnits.setAdapter(adapter);

        spnUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeMoneyUnit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        txtNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                changeMoneyUnit();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void changeMoneyUnit() {
        int rowIdx = spnUnits.getSelectedItemPosition();

        if (rowIdx < 0) rowIdx = 0;

        String input = txtNumber.getText().toString();

        if (input.isEmpty()) input="0";

        double number = Double.valueOf(input);

        for (int i = 0; i < lblResults.length; i++) {
            double temp = number * ratio[rowIdx][i];

            lblResults[i].setText(String.valueOf(temp));
        }
    }
}