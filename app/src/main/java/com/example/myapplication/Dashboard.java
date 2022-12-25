package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button seeAllViolations, createViolation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // find the buttons in the layout
        seeAllViolations = findViewById(R.id.seeAllViolationsSectionBtn);
        createViolation = findViewById(R.id.createViolationSectionBtn);

        // Adding the actions to the buttons.
        seeAllViolations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,CreateViolationStartPage.class));
            }
        });

        createViolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,AllViolationsPage.class));
            }
        });

    }
}