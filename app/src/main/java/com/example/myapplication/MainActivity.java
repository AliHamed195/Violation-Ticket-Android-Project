package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3200;

    //variables
    Animation topAnim, bottomAnim;
    ImageView logoImage;
    TextView greetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_coverpage_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_coverpage_animation);


        //find the text and the image in the view
        logoImage = findViewById(R.id.logoImage);
        greetingText = findViewById(R.id.greetingText);

        //Add the animation to the views image and text
        logoImage.setAnimation(topAnim);
        greetingText.setAnimation(bottomAnim);

        //to delay opening the Login page
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,Login.class));
                finish();
            }
        },SPLASH_SCREEN);
    }
}