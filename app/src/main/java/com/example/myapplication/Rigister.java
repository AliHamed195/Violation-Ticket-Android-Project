package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Rigister extends AppCompatActivity {

    EditText email, password, repeatPassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigister);

        email = findViewById(R.id.inputEmailRegister);
        password = findViewById(R.id.inputPasswordRegister);
        repeatPassword = findViewById(R.id.inputRepeatPasswordRegister);
        register = findViewById(R.id.Registerbutton);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}