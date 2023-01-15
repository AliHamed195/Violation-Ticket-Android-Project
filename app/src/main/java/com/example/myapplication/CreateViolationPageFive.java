package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.myapplication.TictViolationData.AllViolationData;
import com.google.android.material.textfield.TextInputEditText;

public class CreateViolationPageFive extends AppCompatActivity {

    public static final String ALL_DATA = "allData";

    TextInputEditText foreignerNationality, number;
    CheckBox foreigner, lebanese, publicc, privatee;
    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_five);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولا.";

        nextPage = findViewById(R.id.nextPageFiveCreateViolation);
        foreignerNationality = findViewById(R.id.inputPageFiveTypeOfForeignerNationality);
        number = findViewById(R.id.inputPageFiveNumber);
        foreigner = findViewById(R.id.checkboxPageFiveForeigner);
        lebanese = findViewById(R.id.checkboxPageFiveLebanese);
        publicc = findViewById(R.id.checkboxPageFivePublic);
        privatee = findViewById(R.id.checkboxPageFivePrivate);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lebanese.isChecked() && !foreigner.isChecked()){
                    lebanese.setError(errorMessageForNullData);
                    foreigner.setError(errorMessageForNullData);
                    return;
                }else{
                    lebanese.setError(null);
                    foreigner.setError(null);
                }
                if(lebanese.isChecked() && !foreignerNationality.getText().toString().isEmpty()){
                    foreignerNationality.setError("الرجاء اختيار اجنبي قبل الكتابة هنا");
                    return;
                }else{
                    foreignerNationality.setError(null);
                }
                if(foreigner.isChecked() && foreignerNationality.getText().toString().isEmpty()){
                    foreignerNationality.setError(errorMessageForNullData);
                    return;
                }else{
                    foreignerNationality.setError(null);
                }
                if(!publicc.isChecked() && !privatee.isChecked()){
                    publicc.setError(errorMessageForNullData);
                    privatee.setError(errorMessageForNullData);
                    return;
                }else{
                    publicc.setError(null);
                    privatee.setError(null);
                }
                if(number.getText().toString().isEmpty()){
                    number.setError(errorMessageForNullData);
                    return;
                }else{
                    number.setError(null);
                }

                String optionalTextForNationality;
                if(foreignerNationality.getText().toString().isEmpty()){
                    optionalTextForNationality = " ";
                }else{
                    optionalTextForNationality = foreignerNationality.getText().toString();
                }

                AllViolationData allViolationData = AllViolationData.getViolationData();
                allViolationData.setForeignerNationality(foreignerNationality.getText().toString());
                allViolationData.setNumber(number.getText().toString());
                allViolationData.setForeigner(foreigner.isChecked());
                allViolationData.setLebanese(lebanese.isChecked());
                allViolationData.setPublicc(publicc.isChecked());
                allViolationData.setPrivatee(privatee.isChecked());

                String previousData = (String) getIntent().getExtras().get(ALL_DATA);
                Intent intent = new Intent(CreateViolationPageFive.this,CreateViolationPageSix.class);
                String allData = previousData+","+foreigner.isChecked()+ ","+lebanese.isChecked()+
                        ","+optionalTextForNationality+
                        ","+publicc.isChecked()+","+privatee.isChecked()+","+number.getText().toString();
                intent.putExtra(CreateViolationPageSix.ALL_DATA, allData);
                startActivity(intent);

            }
        });
    }
}