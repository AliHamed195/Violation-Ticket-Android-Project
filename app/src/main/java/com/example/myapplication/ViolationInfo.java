package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
            personCityzen = " حامل إجازة سوق لبنانية";
        }else{
            personCityzen = " حامل إجازة سوق اجنبية: "+allViolationData.getForeignerNationality();
        }

        String publicc;
        boolean ispublicc = allViolationData.isPublicc();
        if(ispublicc){
            publicc = " عمومي ";
        }else{
            publicc = " خصوصي ";
        }

        String DoesOwn;
        boolean isDoesOwn = allViolationData.isOwnTheCar();
        if(isDoesOwn){
            DoesOwn = " إفادة المخالف يملك المركبة ";
        }else{
            DoesOwn = " إفادة المخالف لا يملك المركبة ";
        }

        String DoesWinch;
        boolean isDoesWinch = allViolationData.isWinched();
        if(isDoesWinch){
            DoesWinch = " سحبت المركبة من مكان يحظر فيه الوقوف و التوقف بواسطة رافعة.";
        }else{
            DoesWinch = " لم يتم سحب المركبة من مكان يحظر فيه الوقوف و التوقف بواسطة رافعة.";
        }


        violationInformatio.setText(
                "منظم المحضر أثناء الخدمة الرقم الاول:  "+allViolationData.getNumberOne()+" الرقم الثاني:  "+allViolationData.getNumberTwo()+
                        " شاهدنا في محلة الغبيري الشارع:  "+allViolationData.getInputStreet()+" الالية:  "+allViolationData.getInputVehicle()+
                        " ماركة:  "+allViolationData.getInputBrand()+" لون:  "+allViolationData.getInputColor()+
                        " رقم:  "+allViolationData.getInputNumber()+" نوع المخالفة:  "+allViolationData.getViolationTypeText()+
                        " الفئة:  "+allViolationData.getViolationTypes()+". المادة:  "+allViolationData.getSubject()+
                        " هوية المخالف الجنسية:  "+allViolationData.getNationality()+" الاسم:  "+allViolationData.getName()+
                        " اسم الأب:  "+allViolationData.getFatherName()+" سكان المحلة:  "+allViolationData.getPlace()+
                        " شارع:  "+allViolationData.getStreet()+" سنة الولادة:  "+allViolationData.getDayOfBirth()+
                        " مكان القيد:  "+allViolationData.getKaidPlace()+" الشهرة:  "+allViolationData.getTheFame()+
                        " اسم الام وشهرتها:  "+allViolationData.getMotherName()+" ملك:  "+allViolationData.getOwn()+
                        " رقم الهاتف:  "+allViolationData.getPhoneNumber()+" بلدة:  "+allViolationData.getTown()+
                        "  "+personCityzen+"  "+publicc+" رقم:  "+allViolationData.getNumber()+"  "+DoesOwn+"  "+allViolationData.getStatementOfTheOffender()+
                        " ابلغ المخالف انه بإمكانه دفع الغرامة المنخفضة وقيمتها:  "+allViolationData.getOriginalCost()+" خلال اول خمسة عشر يوما وبقيمة  "+allViolationData.getNewCostValue()+
                        " ثاني خمسة عشر يوما. كما اعلمناه اننا:  "+allViolationData.getMessage()+" مركبته رقم الهيكل:  "+allViolationData.getStructureNo()+
                        " رقم العداد:  "+allViolationData.getCounterNumber()+" في مرآب:  "+allViolationData.getGarageName()+
                        "  "+DoesWinch
        );
        // I should handle the phone back button to finish the activity
    }
}