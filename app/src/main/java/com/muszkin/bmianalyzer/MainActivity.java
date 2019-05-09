package com.muszkin.bmianalyzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-4038506785938828~5670675336");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        final EditText height = findViewById(R.id.height);
        final EditText weight = findViewById(R.id.weight);
        SeekBar bmiSeekBar = findViewById(R.id.bmiSeekbar);
        final TextView bmi = findViewById(R.id.bmi);
        Button calculate = findViewById(R.id.calculateButton);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (height.getText().toString().trim().length() > 0 && weight.getText().toString().trim().length() > 0) {
                    bmi.setText(String.valueOf(BmiCalculator.calculateBmi(Float.valueOf(height.getText().toString()),Float.valueOf(weight.getText().toString()))));
                }
            }
        });

        bmiSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (height.getText().toString().trim().length() > 0) {
                    bmi.setText(String.valueOf(seekBar.getProgress()));
                    weight.setText(String.valueOf(BmiCalculator.calcualteWeight(Float.valueOf(height.getText().toString()), (float) seekBar.getProgress())));
                }
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
