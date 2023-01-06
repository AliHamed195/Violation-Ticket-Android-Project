package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationPageFour extends AppCompatActivity {

    TextInputEditText nationality, name, fatherName, place, street, dayOfBirth,
            KaidPlace, theFame, motherName, own, phoneNumber, town;
    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_four);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولاز";

        nextPage = findViewById(R.id.nextPageFourCreateViolation);

        nationality = findViewById(R.id.inputPageFourNationality);
        name = findViewById(R.id.inputPageFourName);
        fatherName = findViewById(R.id.inputPageFourFatherName);
        place = findViewById(R.id.inputPageFourResidenceLocality);
        street = findViewById(R.id.inputPageFourStreet);
        dayOfBirth = findViewById(R.id.inputPageFourDateOfBerth);
        KaidPlace = findViewById(R.id.inputPageFourPlaceOfRegistration);
        theFame = findViewById(R.id.inputPageFourTheFame);
        motherName = findViewById(R.id.inputPageFourMotherName);
        own = findViewById(R.id.inputPageFourOwn);
        phoneNumber = findViewById(R.id.inputPageFourPhoneNumber);
        town = findViewById(R.id.inputPageFourTown);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nationality.getText().toString().isEmpty()){
                    nationality.setError(errorMessageForNullData);
                    return;
                }
                if(name.getText().toString().isEmpty()){
                    name.setError(errorMessageForNullData);
                    return;
                }
                if(fatherName.getText().toString().isEmpty()){
                    fatherName.setError(errorMessageForNullData);
                    return;
                }
                if(place.getText().toString().isEmpty()){
                    place.setError(errorMessageForNullData);
                    return;
                }
                if(street.getText().toString().isEmpty()){
                    street.setError(errorMessageForNullData);
                    return;
                }
                if(dayOfBirth.getText().toString().isEmpty()){
                    dayOfBirth.setError(errorMessageForNullData);
                    return;
                }
                if(KaidPlace.getText().toString().isEmpty()){
                    KaidPlace.setError(errorMessageForNullData);
                    return;
                }
                if(theFame.getText().toString().isEmpty()){
                    theFame.setError(errorMessageForNullData);
                    return;
                }
                if(motherName.getText().toString().isEmpty()){
                    motherName.setError(errorMessageForNullData);
                    return;
                }
                if(own.getText().toString().isEmpty()){
                    own.setError(errorMessageForNullData);
                    return;
                }
                if(phoneNumber.getText().toString().isEmpty()){
                    phoneNumber.setError(errorMessageForNullData);
                    return;
                }
                if(town.getText().toString().isEmpty()){
                    town.setError(errorMessageForNullData);
                    return;
                }

                startActivity(new Intent(getApplicationContext(),CreateViolationPageFive.class));
            }
        });
    }
}