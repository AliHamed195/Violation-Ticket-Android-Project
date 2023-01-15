package com.example.myapplication.TictViolationData;

import java.io.Serializable;

public class AllViolationData implements Serializable {
    private static AllViolationData violationData;
    private String numberOne;
    private String numberTwo;
    private String inputStreet;
    private String inputVehicle;
    private String inputBrand;
    private String inputColor;
    private String inputNumber;
    private String violationTypeText;
    private String violationTypes;
    private String subject;
    private String nationality;
    private String name;
    private String fatherName;
    private String place;
    private String street;
    private String dayOfBirth;
    private String KaidPlace;
    private String theFame;
    private String motherName;
    private String own;
    private String phoneNumber;
    private String town;
    private boolean lebanese;
    private boolean foreigner;
    private String foreignerNationality;
    private boolean publicc;
    private boolean privatee;
    private String number;
    private boolean ownTheCar;
    private boolean notOwnTheCar;
    private String statementOfTheOffender;
    private boolean isWinched;
    private String newCostValue;
    private String originalCost;
    private String message;
    private String structureNo;
    private String counterNumber;
    private String garageName;

    public AllViolationData() {}

    public static void setViolationData(AllViolationData violationData) {
        AllViolationData.violationData = violationData;
    }

    public static AllViolationData getViolationData() {
        if(violationData==null){
            violationData = new AllViolationData();
        }
        return violationData;
    }

    public String getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(String numberOne) {
        this.numberOne = numberOne;
    }

    public String getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(String numberTwo) {
        this.numberTwo = numberTwo;
    }

    public String getInputStreet() {
        return inputStreet;
    }

    public void setInputStreet(String inputStreet) {
        this.inputStreet = inputStreet;
    }

    public String getInputVehicle() {
        return inputVehicle;
    }

    public void setInputVehicle(String inputVehicle) {
        this.inputVehicle = inputVehicle;
    }

    public String getInputBrand() {
        return inputBrand;
    }

    public void setInputBrand(String inputBrand) {
        this.inputBrand = inputBrand;
    }

    public String getInputColor() {
        return inputColor;
    }

    public void setInputColor(String inputColor) {
        this.inputColor = inputColor;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public String getViolationTypeText() {
        return violationTypeText;
    }

    public void setViolationTypeText(String violationTypeText) {
        this.violationTypeText = violationTypeText;
    }

    public String getViolationTypes() {
        return violationTypes;
    }

    public void setViolationTypes(String violationTypes) {
        this.violationTypes = violationTypes;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getKaidPlace() {
        return KaidPlace;
    }

    public void setKaidPlace(String kaidPlace) {
        KaidPlace = kaidPlace;
    }

    public String getTheFame() {
        return theFame;
    }

    public void setTheFame(String theFame) {
        this.theFame = theFame;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = own;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public boolean isLebanese() {
        return lebanese;
    }

    public void setLebanese(boolean lebanese) {
        this.lebanese = lebanese;
    }

    public boolean isForeigner() {
        return foreigner;
    }

    public void setForeigner(boolean foreigner) {
        this.foreigner = foreigner;
    }

    public String getForeignerNationality() {
        return foreignerNationality;
    }

    public void setForeignerNationality(String foreignerNationality) {
        this.foreignerNationality = foreignerNationality;
    }

    public boolean isPublicc() {
        return publicc;
    }

    public void setPublicc(boolean publicc) {
        this.publicc = publicc;
    }

    public boolean isPrivatee() {
        return privatee;
    }

    public void setPrivatee(boolean privatee) {
        this.privatee = privatee;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isOwnTheCar() {
        return ownTheCar;
    }

    public void setOwnTheCar(boolean ownTheCar) {
        this.ownTheCar = ownTheCar;
    }

    public boolean isNotOwnTheCar() {
        return notOwnTheCar;
    }

    public void setNotOwnTheCar(boolean notOwnTheCar) {
        this.notOwnTheCar = notOwnTheCar;
    }

    public String getStatementOfTheOffender() {
        return statementOfTheOffender;
    }

    public void setStatementOfTheOffender(String statementOfTheOffender) {
        this.statementOfTheOffender = statementOfTheOffender;
    }

    public boolean isWinched() {
        return isWinched;
    }

    public void setWinched(boolean winched) {
        isWinched = winched;
    }

    public String getNewCostValue() {
        return newCostValue;
    }

    public void setNewCostValue(String newCostValue) {
        this.newCostValue = newCostValue;
    }

    public String getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(String originalCost) {
        this.originalCost = originalCost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStructureNo() {
        return structureNo;
    }

    public void setStructureNo(String structureNo) {
        this.structureNo = structureNo;
    }

    public String getCounterNumber() {
        return counterNumber;
    }

    public void setCounterNumber(String counterNumber) {
        this.counterNumber = counterNumber;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    @Override
    public String toString() {
        return "AllViolationData{" +
                "numberOne='" + numberOne + '\'' +
                ", numberTwo='" + numberTwo + '\'' +
                ", inputStreet='" + inputStreet + '\'' +
                ", inputVehicle='" + inputVehicle + '\'' +
                ", inputBrand='" + inputBrand + '\'' +
                ", inputColor='" + inputColor + '\'' +
                ", inputNumber='" + inputNumber + '\'' +
                ", violationTypeText='" + violationTypeText + '\'' +
                ", violationTypes='" + violationTypes + '\'' +
                ", subject='" + subject + '\'' +
                ", nationality='" + nationality + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", place='" + place + '\'' +
                ", street='" + street + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", KaidPlace='" + KaidPlace + '\'' +
                ", theFame='" + theFame + '\'' +
                ", motherName='" + motherName + '\'' +
                ", own='" + own + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", town='" + town + '\'' +
                ", lebanese=" + lebanese +
                ", foreigner=" + foreigner +
                ", foreignerNationality='" + foreignerNationality + '\'' +
                ", publicc=" + publicc +
                ", privatee=" + privatee +
                ", number='" + number + '\'' +
                ", ownTheCar=" + ownTheCar +
                ", notOwnTheCar=" + notOwnTheCar +
                ", statementOfTheOffender='" + statementOfTheOffender + '\'' +
                ", isWinched=" + isWinched +
                ", newCostValue='" + newCostValue + '\'' +
                ", originalCost='" + originalCost + '\'' +
                ", message='" + message + '\'' +
                ", structureNo='" + structureNo + '\'' +
                ", counterNumber='" + counterNumber + '\'' +
                ", garageName='" + garageName + '\'' +
                '}';
    }
}
