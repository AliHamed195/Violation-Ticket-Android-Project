package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    Button seeAllViolations, createViolation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // find the buttons in the layout
        drawerLayout = findViewById(R.id.drawer_layout);
        seeAllViolations = findViewById(R.id.seeAllViolationsSectionBtn);
        createViolation = findViewById(R.id.createViolationSectionBtn);

        // Adding the actions to the buttons.
        seeAllViolations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,AllViolationsPage.class));
            }
        });

        createViolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,CreateViolationStartPage.class));
            }
        });

        //to make the button for the menu
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // to handel click on the navigation view (menu)
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //to handel open and close menu
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    // to get the selected item and return true means that there is item selected
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_facebookmenu:
                Toast.makeText(getApplicationContext(),"FaceBook",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_instamenu:
                Toast.makeText(getApplicationContext(),"Instagram",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_googlemenu:
                Toast.makeText(getApplicationContext(),"Google",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_logoutmenu:
                break;
        }
        // to close the menu after select option
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}