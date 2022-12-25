package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CreateViolationPageTwo extends AppCompatActivity {

    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_two);

        nextPage = findViewById(R.id.nextPageTwoCreateViolation);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(CreateViolationPageTwo.this,CreateViolationPageThree.class);
//                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
            }
        });
    }
}