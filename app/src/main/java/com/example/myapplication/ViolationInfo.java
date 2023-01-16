package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.myapplication.TictViolationData.AllViolationData;

public class ViolationInfo extends AppCompatActivity {

    TextView violationInformatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_violation_info);

        violationInformatio = findViewById(R.id.violationInformatio);

        AllViolationData allViolationData = (AllViolationData) getIntent().getSerializableExtra("allViolationData");

        String personCityzen;
        boolean isLebanese = allViolationData.isLebanese();
        if(isLebanese){
            personCityzen = "حامل إجازة سوق لبنانية";
        }else{
            personCityzen = "حامل إجازة سوق اجنبية: "+allViolationData.getForeignerNationality();
        }

        String publicc;
        boolean ispublicc = allViolationData.isPublicc();
        if(ispublicc){
            publicc = "عمومي ";
        }else{
            publicc = "خصوصي ";
        }

        String DoesOwn;
        boolean isDoesOwn = allViolationData.isOwnTheCar();
        if(isDoesOwn){
            DoesOwn = "إفادة المخالف يملك المركبة ";
        }else{
            DoesOwn = "إفادة المخالف لا يملك المركبة ";
        }

        String DoesWinch;
        boolean isDoesWinch = allViolationData.isWinched();
        if(isDoesWinch){
            DoesWinch = "سحبت المركبة من مكان يحظر فيه الوقوف و التوقف بواسطة رافعة.";
        }else{
            DoesWinch = "لم يتم سحب المركبة من مكان يحظر فيه الوقوف و التوقف بواسطة رافعة.";
        }

        String [] allData = {
                "منظم المحضر أثناء الخدمة:\nالرقم الاول:  "+allViolationData.getNumberOne()+"\n الرقم الثاني:  "+allViolationData.getNumberTwo(),
                "\nشاهدنا في محلة الغبيري:\nالشارع:  "+allViolationData.getInputStreet()+"\nالالية:  "+allViolationData.getInputVehicle(),
                "\nماركة:  "+allViolationData.getInputBrand()+"\nلون:  "+allViolationData.getInputColor(),
                "\nرقم:  "+allViolationData.getInputNumber()+"\nنوع المخالفة:  "+allViolationData.getViolationTypeText(),
                "\nالفئة:  "+allViolationData.getViolationTypes()+".\nالمادة:  "+allViolationData.getSubject(),
                "\nهوية المخالف:\n الجنسية:  "+allViolationData.getNationality()+"\nالاسم:  "+allViolationData.getName(),
                "\nاسم الأب:  "+allViolationData.getFatherName()+"\nسكان المحلة:  "+allViolationData.getPlace(),
                "\nشارع:  "+allViolationData.getStreet()+"\nسنة الولادة:  "+allViolationData.getDayOfBirth(),
                "\nمكان القيد:  "+allViolationData.getKaidPlace()+"\nالشهرة:  "+allViolationData.getTheFame(),
                "\nاسم الام وشهرتها:  "+allViolationData.getMotherName()+"\nملك:  "+allViolationData.getOwn(),
                "\nرقم الهاتف:  "+allViolationData.getPhoneNumber()+"\nبلدة:  "+allViolationData.getTown(),
                "\n"+personCityzen+"\n"+publicc+"\nرقم:  "+allViolationData.getNumber(),
                "\n"+DoesOwn+". "+allViolationData.getStatementOfTheOffender(),
                "\nابلغ المخالف انه بإمكانه دفع الغرامة المنخفضة وقيمتها:  "+allViolationData.getOriginalCost()+" خلال اول خمسة عشر يوما وبقيمة  "+allViolationData.getNewCostValue()+" ثاني خمسة عشر يوما.",
                "\nكما اعلمناه اننا:  "+allViolationData.getMessage()+"\nمركبته رقم الهيكل:  "+allViolationData.getStructureNo(),
                "\nرقم العداد:  "+allViolationData.getCounterNumber()+"\nفي مرآب:  "+allViolationData.getGarageName(),
                "\n "+DoesWinch
        };
        /*
        violationInformatio.setText(
                "منظم المحضر أثناء الخدمة:\nالرقم الاول:  "+allViolationData.getNumberOne()+"\n الرقم الثاني:  "+allViolationData.getNumberTwo()+
                        "\n\nشاهدنا في محلة الغبيري:\nالشارع:  "+allViolationData.getInputStreet()+"\nالالية:  "+allViolationData.getInputVehicle()+
                        "\nماركة:  "+allViolationData.getInputBrand()+"\nلون:  "+allViolationData.getInputColor()+
                        "\nرقم:  "+allViolationData.getInputNumber()+"\nنوع المخالفة:  "+allViolationData.getViolationTypeText()+
                        "\nالفئة:  "+allViolationData.getViolationTypes()+".\nالمادة:  "+allViolationData.getSubject()+
                        "\n\nهوية المخالف:\n الجنسية:  "+allViolationData.getNationality()+"\nالاسم:  "+allViolationData.getName()+
                        "\nاسم الأب:  "+allViolationData.getFatherName()+"\nسكان المحلة:  "+allViolationData.getPlace()+
                        "\nشارع:  "+allViolationData.getStreet()+"\nسنة الولادة:  "+allViolationData.getDayOfBirth()+
                        "\nمكان القيد:  "+allViolationData.getKaidPlace()+"\nالشهرة:  "+allViolationData.getTheFame()+
                        "\nاسم الام وشهرتها:  "+allViolationData.getMotherName()+"\nملك:  "+allViolationData.getOwn()+
                        "\nرقم الهاتف:  "+allViolationData.getPhoneNumber()+"\nبلدة:  "+allViolationData.getTown()+
                        "\n\n"+personCityzen+"\n"+publicc+"\nرقم:  "+allViolationData.getNumber()+"\n"+DoesOwn+". "+allViolationData.getStatementOfTheOffender()+
                        "\n\nابلغ المخالف انه بإمكانه دفع الغرامة المنخفضة وقيمتها:  "+allViolationData.getOriginalCost()+" خلال اول خمسة عشر يوما وبقيمة  "+allViolationData.getNewCostValue()+
                        " ثاني خمسة عشر يوما.\nكما اعلمناه اننا:  "+allViolationData.getMessage()+"\nمركبته رقم الهيكل:  "+allViolationData.getStructureNo()+
                        "\nرقم العداد:  "+allViolationData.getCounterNumber()+"\nفي مرآب:  "+allViolationData.getGarageName()+
                        "\n "+DoesWinch
        );
*/

        TableLayout tableLayout = findViewById(R.id.table_violation_info);

        // Create a TableRow and add views to it
        TextView tableTitle = new TextView(this);
        tableTitle.setText("تفاصيل المخالفة");
        tableTitle.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        tableLayout.addView(tableTitle, 0);
        tableTitle.setTextSize(40);
        tableTitle.setTextColor(Color.BLUE);
        tableTitle.setGravity(Gravity.CENTER);


        for (int i = 0; i < allData.length; i++) {
            TableRow row = new TableRow(this);
            TextView textView = new TextView(this);
            textView.setText(allData[i]);
            textView.setTextSize(20);
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
            textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            row.addView(textView);
            tableLayout.addView(row);
        }



        EditText searchEditText = findViewById(R.id.for_table_violation_search);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchText = s.toString();
                // Iterate over the table rows and hide the ones that do not match the search text
                for (int i = 1; i < tableLayout.getChildCount(); i++) {
                    View childView = tableLayout.getChildAt(i);
                    if (childView instanceof TableRow) {
                        TableRow row = (TableRow) childView;
                        boolean matchFound = false;
                        // Iterate over the views in the row
                        for (int j = 0; j < row.getChildCount(); j++) {
                            View view = row.getChildAt(j);
                            if (view instanceof TextView) {
                                TextView textView = (TextView) view;
                                String text = textView.getText().toString();
                                if (text.contains(searchText)) {
                                    matchFound = true;
                                    break;
                                }
                            }
                        }
                        if (matchFound) {
                            row.setVisibility(View.VISIBLE);
                        } else {
                            row.setVisibility(View.GONE);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });


    }
}