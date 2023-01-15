package com.example.myapplication.TictViolationData;

public class TictInfo {
    private int tictId;
    private String body1;
    private String body2;
    private AllViolationData allViolationData;


    public TictInfo(int tictId, String body1, String body2,AllViolationData allViolationData) {
        this.tictId = tictId;
        this.body1 = body1;
        this.body2 = body2;
        this.allViolationData = allViolationData;
    }

    public AllViolationData getAllViolationData() {
        return allViolationData;
    }

    public void setAllViolationData(AllViolationData allViolationData) {
        this.allViolationData = allViolationData;
    }

    public int getTictId() {
        return tictId;
    }

    public void setTictId(int tictId) {
        this.tictId = tictId;
    }

    public String getBody1() {
        return body1;
    }

    public void setBody1(String body1) {
        this.body1 = body1;
    }

    public String getBody2() {
        return body2;
    }

    public void setBody2(String body2) {
        this.body2 = body2;
    }

    @Override
    public String toString() {
        return "TictInfo{" +
                "tictId=" + tictId +
                ", body1='" + body1 + '\'' +
                ", body2='" + body2 + '\'' +
                '}';
    }
}
