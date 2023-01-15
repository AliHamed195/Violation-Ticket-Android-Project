package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.TictViolationData.TictInfo;
import com.example.myapplication.forSqlite.DatabaseHelper;

import java.util.ArrayList;

public class UnSendedViolationsPage extends AppCompatActivity {
    ArrayList<TictInfo> noteClassArrayList;
    LayoutInflater inflater;
    ListView notesListViewOutPut;
    String COLUMN_ID = "id";
    String COLUMN_violationTypes = "violationTypes";
    String COLUMN_subject = "subject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un_sended_violations_page);

        notesListViewOutPut = findViewById(R.id.listTictsOutput);

        inflater = this.getLayoutInflater();

        noteClassArrayList = new ArrayList<>();
        //some data just for test
//        noteClassArrayList.add(new NoteClass(1,"note one", "The Lorm alphabet is a method of tactile signing named after Hieronymus Lorm, who developed it in the late 19th century. Letters are spelled by tapping or stroking different parts of the listener's hand. The Lorm alphabet is mostly used in German-speaking countries, the Netherlands, Czech Republic, Poland and Georgia"));
//        noteClassArrayList.add(new NoteClass(2,"note two", "The Lorm alphabet is a method of tactile signing named after Hieronymus Lorm, who developed it in the late 19th century. Letters are spelled by tapping or stroking different parts of the listener's hand. The Lorm alphabet is mostly used in German-speaking countries, the Netherlands, Czech Republic, Poland and Georgia"));
//        noteClassArrayList.add(new NoteClass(3,"note three", "The Lorm alphabet is a method of tactile signing named after Hieronymus Lorm, who developed it in the late 19th century. Letters are spelled by tapping or stroking different parts of the listener's hand. The Lorm alphabet is mostly used in German-speaking countries, the Netherlands, Czech Republic, Poland and Georgia"));


        gitnotes();

//###########################################
        /*
        LinearLayout cardContainer =  findViewById(R.id.card_container);

        try {
            DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
            Cursor cursor = dbHelper.getAllRecords();


            if (cursor != null && cursor.getCount() > 0) {
                //iterate over cursor
                while (cursor.moveToNext()) {
                    // Inflate the card layout and get the id and string from the cursor
                    View cardView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.card_view, cardContainer, false);
                    final int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STRING));

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
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
        }
        */
    }

    public void gitnotes(){
        DatabaseHelper dbManager = new DatabaseHelper(this);
        noteClassArrayList.clear();
        Cursor cursor = dbManager.getAllRecords();
        if (cursor != null && cursor.getCount() > 0) {
            //iterate over cursor
            while (cursor.moveToNext()) {
                noteClassArrayList.add(new TictInfo(
                        cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_violationTypes)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_subject))
                ));
            }
        }
        cursor.close();
        Adapter myNotesAdapter = new MyNoteAdapter(noteClassArrayList);
        notesListViewOutPut.setAdapter((ListAdapter) myNotesAdapter);
    }

    class MyNoteAdapter extends BaseAdapter {
        ArrayList<TictInfo> listNotesAdapter;
        public MyNoteAdapter(ArrayList<TictInfo> noteClassArrayList){
            super();
            this.listNotesAdapter = noteClassArrayList;
        }

        @Override
        public int getCount() {
            return this.listNotesAdapter.size();
        }

        @Override
        public Object getItem(int i) {
            return listNotesAdapter.get(i);
        }

        @Override
        public long getItemId(int i) {
            return (long) i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myView = inflater.inflate(R.layout.card_view,null);
            TictInfo noteClass = this.listNotesAdapter.get(i);
            TextView title = myView.findViewById(R.id.title);
            TextView contant1 = myView.findViewById(R.id.body1);
            TextView contant2 = myView.findViewById(R.id.body2);
            Button btn = myView.findViewById(R.id.buttonSeeMore);
            title.setText(Integer.toString(noteClass.getTictId()));
            contant1.setText(noteClass.getBody1().toString());
            contant2.setText(noteClass.getBody2().toString());
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),title.getText().toString(),Toast.LENGTH_LONG).show();
                }
            });
            return myView;
        }
    }


}