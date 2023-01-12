package com.example.myapplication.forApi;

import com.google.gson.annotations.SerializedName;

public class MyData {
    @SerializedName("name")
    private String name;

    public MyData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
