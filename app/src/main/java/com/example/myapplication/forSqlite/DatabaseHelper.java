package com.example.myapplication.forSqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LocalDB";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_NAME = "ViolationTable";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_numberOne = "numberOne";
    private static final String COLUMN_numberTwo = "numberTwo";
    private static final String COLUMN_inputStreet = "inputStreet";
    private static final String COLUMN_inputVehicle = "inputVehicle";
    private static final String COLUMN_inputBrand = "inputBrand";
    private static final String COLUMN_inputColor = "inputColor";
    private static final String COLUMN_inputNumber = "inputNumber";
    private static final String COLUMN_violationTypeText = "violationTypeText";
    private static final String COLUMN_violationTypes = "violationTypes";
    private static final String COLUMN_subject = "subject";
    private static final String COLUMN_nationality = "nationality";
    private static final String COLUMN_name = "name";
    private static final String COLUMN_fatherName = "fatherName";
    private static final String COLUMN_place = "place";
    private static final String COLUMN_street = "street";
    private static final String COLUMN_dayOfBirth = "dayOfBirth";
    private static final String COLUMN_KaidPlace = "KaidPlace";
    private static final String COLUMN_theFame = "theFame";
    private static final String COLUMN_motherName = "motherName";
    private static final String COLUMN_own = "own";
    private static final String COLUMN_phoneNumber = "phoneNumber";
    private static final String COLUMN_town = "town";
    private static final String COLUMN_lebanese = "lebanese";
    private static final String COLUMN_foreigner = "foreigner";
    private static final String COLUMN_foreignerNationality = "foreignerNationality";
    private static final String COLUMN_publicc = "publicc";
    private static final String COLUMN_privatee = "privatee";
    private static final String COLUMN_number = "number";
    private static final String COLUMN_ownTheCar = "ownTheCar";
    private static final String COLUMN_notOwnTheCar = "notOwnTheCar";
    private static final String COLUMN_statementOfTheOffender = "statementOfTheOffender";
    private static final String COLUMN_isWinched = "isWinched";
    private static final String COLUMN_newCostValue = "newCostValue";
    private static final String COLUMN_originalCost = "originalCost";
    private static final String COLUMN_message = "message";
    private static final String COLUMN_structureNo = "structureNo";
    private static final String COLUMN_counterNumber = "counterNumber";
    private static final String COLUMN_garageName = "garageName";


    private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_numberOne + " TEXT,"
            + COLUMN_numberTwo + " TEXT,"
            + COLUMN_inputStreet + " TEXT,"
            + COLUMN_inputVehicle + " TEXT,"
            + COLUMN_inputBrand + " TEXT,"
            + COLUMN_inputColor + " TEXT,"
            + COLUMN_inputNumber + " TEXT,"
            + COLUMN_violationTypeText + " TEXT,"
            + COLUMN_violationTypes + " TEXT,"
            + COLUMN_subject + " TEXT,"
            + COLUMN_nationality + " TEXT,"
            + COLUMN_name + " TEXT,"
            + COLUMN_fatherName + " TEXT,"
            + COLUMN_place + " TEXT,"
            + COLUMN_street + " TEXT,"
            + COLUMN_dayOfBirth + " TEXT,"
            + COLUMN_KaidPlace + " TEXT,"
            + COLUMN_theFame + " TEXT,"
            + COLUMN_motherName + " TEXT,"
            + COLUMN_own + " TEXT,"
            + COLUMN_phoneNumber + " TEXT,"
            + COLUMN_town + " TEXT,"
            + COLUMN_lebanese + " INTEGER,"
            + COLUMN_foreigner + " INTEGER,"
            + COLUMN_foreignerNationality + " TEXT,"
            + COLUMN_publicc + " INTEGER,"
            + COLUMN_privatee + " INTEGER,"
            + COLUMN_number + " TEXT,"
            + COLUMN_ownTheCar + " INTEGER,"
            + COLUMN_notOwnTheCar + " INTEGER,"
            + COLUMN_statementOfTheOffender + " TEXT,"
            + COLUMN_isWinched + " INTEGER,"
            + COLUMN_newCostValue + " TEXT,"
            + COLUMN_originalCost + " TEXT,"
            + COLUMN_message + " TEXT,"
            + COLUMN_structureNo + " TEXT,"
            + COLUMN_counterNumber + " TEXT,"
            + COLUMN_garageName + " TEXT" + ")";


    private static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME ;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion >= 1){
            db.execSQL(DROP_TABLE_QUERY);
            db.execSQL(CREATE_TABLE_QUERY);
        }
    }

    public long insertRecord(String numberOne, String numberTwo, String inputStreet,
                             String inputVehicle, String inputBrand, String inputColor,
                             String inputNumber, String violationTypeText, String violationTypes,
                             String subject, String nationality, String name, String fatherName,
                             String place, String street, String dayOfBirth, String KaidPlace,
                             String theFame, String motherName, String own, String phoneNumber,
                             String town, int lebanese, int foreigner, String foreignerNationality,
                             int publicc, int privatee, String number, int ownTheCar, int notOwnTheCar,
                             String statementOfTheOffender, int isWinched, String newCostValue,
                             String originalCost, String message, String structureNo, String counterNumber,
                             String garageName) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_numberOne, numberOne);
        values.put(COLUMN_numberTwo, numberTwo);
        values.put(COLUMN_inputStreet, inputStreet);
        values.put(COLUMN_inputVehicle, inputVehicle);
        values.put(COLUMN_inputBrand, inputBrand);
        values.put(COLUMN_inputColor, inputColor);
        values.put(COLUMN_inputNumber, inputNumber);
        values.put(COLUMN_violationTypeText, violationTypeText);
        values.put(COLUMN_violationTypes, violationTypes);
        values.put(COLUMN_subject, subject);
        values.put(COLUMN_nationality, nationality);
        values.put(COLUMN_name, name);
        values.put(COLUMN_fatherName, fatherName);
        values.put(COLUMN_place, place);
        values.put(COLUMN_street, street);
        values.put(COLUMN_dayOfBirth, dayOfBirth);
        values.put(COLUMN_KaidPlace, KaidPlace);
        values.put(COLUMN_theFame, theFame);
        values.put(COLUMN_motherName, motherName);
        values.put(COLUMN_own, own);
        values.put(COLUMN_phoneNumber, phoneNumber);
        values.put(COLUMN_town, town);
        values.put(COLUMN_lebanese, lebanese);
        values.put(COLUMN_foreigner, foreigner);
        values.put(COLUMN_foreignerNationality, foreignerNationality);
        values.put(COLUMN_publicc, publicc);
        values.put(COLUMN_privatee, privatee);
        values.put(COLUMN_number, number);
        values.put(COLUMN_ownTheCar, ownTheCar);
        values.put(COLUMN_notOwnTheCar, notOwnTheCar);
        values.put(COLUMN_statementOfTheOffender, statementOfTheOffender);
        values.put(COLUMN_isWinched, isWinched);
        values.put(COLUMN_newCostValue, newCostValue);
        values.put(COLUMN_originalCost, originalCost);
        values.put(COLUMN_message, message);
        values.put(COLUMN_structureNo, structureNo);
        values.put(COLUMN_counterNumber, counterNumber);
        values.put(COLUMN_garageName, garageName);

        return db.insert(TABLE_NAME, null, values);
    }


    public Cursor getAllRecords() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }


}

