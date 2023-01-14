package com.example.myapplication.forApi;

import com.google.gson.annotations.SerializedName;

public class MyData {
    @SerializedName("numberOne")
    private int numberOne;

    private int numberTwo;
    private String inputStreet;
    private String inputVehicle;
    private String inputBrand;
    private String inputColor;
    private int inputNumber;
    //TextInputEditText violationTypeText;
    //    Spinner violationTypes , subject;

    public MyData(int numberOne) {
        this.numberOne = numberOne;
    }

}
