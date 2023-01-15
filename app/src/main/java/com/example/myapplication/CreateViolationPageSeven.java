package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.TictViolationData.AllViolationData;
import com.example.myapplication.forApi.MyData;
import com.example.myapplication.forApi.SendDataApi;
import com.example.myapplication.forSqlite.DatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreateViolationPageSeven extends AppCompatActivity {

    public static final String ALL_DATA = "allData";

    TextView newCostValue;
    TextInputLayout originalCost;
    TextInputEditText  message, structureNo, counterNumber, garageName;
    CheckBox isWinched;
    Button pageSevenCreateViolation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation_page_seven);

        String errorMessageForNullData = "الرجاء ادخال المعلومات اولا.";

        pageSevenCreateViolation = findViewById(R.id.PageSevenCreateViolation);

        newCostValue = findViewById(R.id.newviolationCostValuePageSeven);
        originalCost = findViewById(R.id.costPageSeven);
        message = findViewById(R.id.inputPageSevenMessage);
        structureNo = findViewById(R.id.inputPageSevenStructureNo);
        counterNumber = findViewById(R.id.inputPageSevenCounterNumber);
        garageName = findViewById(R.id.inputPageSevenGarageName);
        isWinched = findViewById(R.id.checkboxPageSevenIsWinched);

        if(originalCost.getEditText().getText().toString().isEmpty()){
            newCostValue.setText("خلال اول خمسة عشر يوما وبقيمة ............ ثاني خمسة عشر يوما.");
        }

        originalCost.getEditText().addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(originalCost.getEditText().getText().toString().isEmpty()){
                    newCostValue.setText("خلال اول خمسة عشر يوما وبقيمة ............ ثاني خمسة عشر يوما.");
                }else{
                    int v = Integer.parseInt(originalCost.getEditText().getText().toString());
                    v = v * 2;
                    newCostValue.setText("خلال اول خمسة عشر يوما وبقيمة " +v+" ثاني خمسة عشر يوما.");
                }
            }
        });


        pageSevenCreateViolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(originalCost.getEditText().getText().toString().isEmpty()){
                    originalCost.setError(errorMessageForNullData);
                    return;
                }else{
                    originalCost.setError(null);
                }
                if(message.getText().toString().isEmpty()){
                    message.setError(errorMessageForNullData);
                    return;
                }else{
                    message.setError(null);
                }
                if(structureNo.getText().toString().isEmpty()){
                    structureNo.setError(errorMessageForNullData);
                    return;
                }else{
                    structureNo.setError(null);
                }
                if(counterNumber.getText().toString().isEmpty()){
                    counterNumber.setError(errorMessageForNullData);
                    return;
                }else{
                    counterNumber.setError(null);
                }
                if(garageName.getText().toString().isEmpty()){
                    garageName.setError(errorMessageForNullData);
                    return;
                }else{
                    garageName.setError(null);
                }

                AllViolationData allViolationData = AllViolationData.getViolationData();
                allViolationData.setOriginalCost(originalCost.getEditText().getText().toString());
                allViolationData.setNewCostValue(Integer.toString(
                        Integer.parseInt(originalCost.getEditText().getText().toString())*2)
                );
                allViolationData.setMessage(message.getText().toString());
                allViolationData.setStructureNo(structureNo.getText().toString());
                allViolationData.setCounterNumber(counterNumber.getText().toString());
                allViolationData.setGarageName(garageName.getText().toString());
                allViolationData.setWinched(isWinched.isChecked());

                String previousData = (String) getIntent().getExtras().get(ALL_DATA);

                // Do not forget to add the inputs of this page
                //Toast.makeText(getApplicationContext(),previousData,Toast.LENGTH_LONG).show();

                // covert boolean to int
                int isLebanese = allViolationData.isLebanese() ? 1 : 0;
                int isForeigner = allViolationData.isForeigner() ? 1 : 0;
                int isPublicc = allViolationData.isPublicc() ? 1 : 0;
                int isPrivatee = allViolationData.isPrivatee() ? 1 : 0;
                int isOwnTheCar = allViolationData.isOwnTheCar() ? 1 : 0;
                int isNotOwnTheCar = allViolationData.isNotOwnTheCar() ? 1 : 0;
                int isWinched = allViolationData.isWinched() ? 1 : 0;


                try {
                    DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
                    long id = dbHelper.insertRecord(
                            allViolationData.getNumberOne(),
                            allViolationData.getNumberTwo(),
                            allViolationData.getInputStreet(),
                            allViolationData.getInputVehicle(),
                            allViolationData.getInputBrand(),
                            allViolationData.getInputColor(),
                            allViolationData.getInputNumber(),
                            allViolationData.getViolationTypeText(),
                            allViolationData.getViolationTypes(),
                            allViolationData.getSubject(),
                            allViolationData.getNationality(),
                            allViolationData.getName(),
                            allViolationData.getFatherName(),
                            allViolationData.getPlace(),
                            allViolationData.getStreet(),
                            allViolationData.getDayOfBirth(),
                            allViolationData.getKaidPlace(),
                            allViolationData.getTheFame(),
                            allViolationData.getMotherName(),
                            allViolationData.getOwn(),
                            allViolationData.getPhoneNumber(),
                            allViolationData.getTown(),
                            isLebanese,
                            isForeigner,
                            allViolationData.getForeignerNationality(),
                            isPublicc,
                            isPrivatee,
                            allViolationData.getNumber(),
                            isOwnTheCar,
                            isNotOwnTheCar,
                            allViolationData.getStatementOfTheOffender(),
                            isWinched,
                            allViolationData.getNewCostValue(),
                            allViolationData.getOriginalCost(),
                            allViolationData.getMessage(),
                            allViolationData.getStructureNo(),
                            allViolationData.getCounterNumber(),
                            allViolationData.getGarageName()
                    );
                    // check if the insert is success or not
                    if (id != -1) {
                        AllViolationData.setViolationData(null);
                        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Record saved successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error saving record", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                }

                /*
                // to send the data using API
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://your-api-base-url.com")
                        .build();
                SendDataApi api = retrofit.create(SendDataApi.class);
                MyData data = new MyData(1);
                Call<ResponseBody> call = api.saveData(data);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {

                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
                */
            }
        });
    }
}