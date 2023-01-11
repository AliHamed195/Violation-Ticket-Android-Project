package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationPageFour extends AppCompatActivity {

    public static final String ALL_DATA = "allData";

    TextInputEditText nationality, name, fatherName, place, street, dayOfBirth,
            KaidPlace, theFame, motherName, own, phoneNumber, town;
    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_four);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولا.";

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


        if (savedInstanceState != null) {
            if(savedInstanceState.containsKey("nationality"))
                nationality.setText(savedInstanceState.getString("nationality"));
            if(savedInstanceState.containsKey("name"))
                name.setText(savedInstanceState.getString("name"));
            if(savedInstanceState.containsKey("fatherName"))
                fatherName.setText(savedInstanceState.getString("fatherName"));
            if(savedInstanceState.containsKey("place"))
                place.setText(savedInstanceState.getString("place"));
            if(savedInstanceState.containsKey("street"))
                street.setText(savedInstanceState.getString("street"));
            if(savedInstanceState.containsKey("dayOfBirth"))
                dayOfBirth.setText(savedInstanceState.getString("dayOfBirth"));
            if(savedInstanceState.containsKey("KaidPlace"))
                KaidPlace.setText(savedInstanceState.getString("KaidPlace"));
            if(savedInstanceState.containsKey("theFame"))
                theFame.setText(savedInstanceState.getString("theFame"));
            if(savedInstanceState.containsKey("motherName"))
                motherName.setText(savedInstanceState.getString("motherName"));
            if(savedInstanceState.containsKey("own"))
                own.setText(savedInstanceState.getString("own"));
            if(savedInstanceState.containsKey("phoneNumber"))
                phoneNumber.setText(Integer.toString(savedInstanceState.getInt("phoneNumber")));
            if(savedInstanceState.containsKey("town"))
                town.setText(savedInstanceState.getString("town"));
        }



        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nationality.getText().toString().isEmpty()){
                    nationality.setError(errorMessageForNullData);
                    return;
                }else{
                    nationality.setError(null);
                }
                if(name.getText().toString().isEmpty()){
                    name.setError(errorMessageForNullData);
                    return;
                }else{
                    name.setError(null);
                }
                if(fatherName.getText().toString().isEmpty()){
                    fatherName.setError(errorMessageForNullData);
                    return;
                }else{
                    fatherName.setError(null);
                }
                if(place.getText().toString().isEmpty()){
                    place.setError(errorMessageForNullData);
                    return;
                }else{
                    place.setError(null);
                }
                if(street.getText().toString().isEmpty()){
                    street.setError(errorMessageForNullData);
                    return;
                }else{
                    street.setError(null);
                }
                if(dayOfBirth.getText().toString().isEmpty()){
                    dayOfBirth.setError(errorMessageForNullData);
                    return;
                }else{
                    dayOfBirth.setError(null);
                }
                if(KaidPlace.getText().toString().isEmpty()){
                    KaidPlace.setError(errorMessageForNullData);
                    return;
                }else{
                    KaidPlace.setError(null);
                }
                if(theFame.getText().toString().isEmpty()){
                    theFame.setError(errorMessageForNullData);
                    return;
                }else{
                    theFame.setError(null);
                }
                if(motherName.getText().toString().isEmpty()){
                    motherName.setError(errorMessageForNullData);
                    return;
                }else{
                    motherName.setError(null);
                }
                if(own.getText().toString().isEmpty()){
                    own.setError(errorMessageForNullData);
                    return;
                }else{
                    own.setError(null);
                }
                if(phoneNumber.getText().toString().isEmpty()){
                    phoneNumber.setError(errorMessageForNullData);
                    return;
                }else{
                    phoneNumber.setError(null);
                }
                if(town.getText().toString().isEmpty()){
                    town.setError(errorMessageForNullData);
                    return;
                }else{
                    town.setError(null);
                }

                String previousData = (String) getIntent().getExtras().get(ALL_DATA);
                Intent intent = new Intent(CreateViolationPageFour.this,CreateViolationPageFive.class);
                String allData = previousData+","+nationality.getText().toString()+","+name.getText().toString()+","+fatherName.getText().toString()+
                        ","+place.getText().toString()+","+street.getText().toString()+","+dayOfBirth.getText().toString()+","+KaidPlace.getText().toString()+
                        ","+theFame.getText().toString()+","+motherName.getText().toString()+","+own.getText().toString()+","+phoneNumber.getText().toString()+
                        ","+town.getText().toString();
                intent.putExtra(CreateViolationPageFive.ALL_DATA, allData);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if(!nationality.getText().toString().isEmpty())
            savedInstanceState.putString("nationality", nationality.getText().toString());
        if(!name.getText().toString().isEmpty())
            savedInstanceState.putString("name", name.getText().toString());
        if(!fatherName.getText().toString().isEmpty())
            savedInstanceState.putString("fatherName", fatherName.getText().toString());
        if(!place.getText().toString().isEmpty())
            savedInstanceState.putString("place", place.getText().toString());
        if(!street.getText().toString().isEmpty())
            savedInstanceState.putString("street", street.getText().toString());
        if(!dayOfBirth.getText().toString().isEmpty())
            savedInstanceState.putString("dayOfBirth", dayOfBirth.getText().toString());
        if(!KaidPlace.getText().toString().isEmpty())
            savedInstanceState.putString("KaidPlace", KaidPlace.getText().toString());
        if(!theFame.getText().toString().isEmpty())
            savedInstanceState.putString("theFame", theFame.getText().toString());
        if(!motherName.getText().toString().isEmpty())
            savedInstanceState.putString("motherName", motherName.getText().toString());
        if(!own.getText().toString().isEmpty())
            savedInstanceState.putString("own", own.getText().toString());
        if(!phoneNumber.getText().toString().isEmpty())
            savedInstanceState.putInt("phoneNumber", Integer.parseInt(phoneNumber.getText().toString()));
        if(!town.getText().toString().isEmpty())
            savedInstanceState.putString("town", town.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}