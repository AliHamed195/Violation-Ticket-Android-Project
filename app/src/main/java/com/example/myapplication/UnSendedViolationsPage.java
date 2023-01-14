package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.forSqlite.DatabaseHelper;

public class UnSendedViolationsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un_sended_violations_page);

        LinearLayout cardContainer =  findViewById(R.id.card_container);

        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        Cursor cursor = dbHelper.getAllRecords();
        String COLUMN_ID = "id";
        String COLUMN_STRING = "string";

        if(cursor != null && cursor.getCount() > 0) {
            //iterate over cursor
            while (cursor.moveToNext()) {
                // Inflate the card layout and get the id and string from the cursor
                View cardView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.card_view, cardContainer, false);
                //final int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
               // String string = cursor.getString(cursor.getColumnIndex(COLUMN_STRING));

                // Find the button in the card layout and set the OnClickListener
                Button button = cardView.findViewById(R.id.buttonSeeMore);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Perform an action based on the selected card
                        // For example, you can show a toast message with the id of the selected card
                        //Toast.makeText(getApplicationContext(), "Selected card id: " + id, Toast.LENGTH_SHORT).show();
                    }
                });

                // Add the card to the container
                cardContainer.addView(cardView);
            }
        }
        cursor.close();
    }
}