package com.example.chengen.crowdsafetyalerts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnAgg;
    private ImageButton btnMiss;
    private ImageButton btnSan;
    private ImageButton btnMed;
    private ImageButton btnSusp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgg = (ImageButton)findViewById(R.id.iBAgg);
        btnMiss = (ImageButton)findViewById(R.id.iBMiss);
        btnSan = (ImageButton)findViewById(R.id.iBSan);
        btnMed = (ImageButton)findViewById(R.id.iBMed);
        btnSusp = (ImageButton)findViewById(R.id.iBSusp);
        btnAgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(), Aggression.class);
                startActivity(intent);
            }
        });
        btnMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(), Missing.class);
                startActivity(intent);
            }
        });
        btnSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(),Sanitary.class);
                startActivity(intent);
            }
        });
        btnMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Medical.class);
                startActivity(intent);
            }
        });
        btnSusp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Suspicion.class);
                startActivity(intent);
            }
        });
    }
}


