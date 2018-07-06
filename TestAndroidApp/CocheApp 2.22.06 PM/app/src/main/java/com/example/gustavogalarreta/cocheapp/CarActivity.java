package com.example.gustavogalarreta.cocheapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CarActivity extends AppCompatActivity implements NewCarFragment.OnFragmentInteractionListener, IndexCarFragment.OnFragmentInteractionListener {

    private Button btIndexCars, btNewCar;
    Fragment fragment;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        setViews();
        setListeners();
    }

    void setViews(){
        btIndexCars = findViewById(R.id.cars);
        btNewCar = findViewById(R.id.newCar);
        fm = getSupportFragmentManager();

    }

    void setListeners(){
        btNewCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment = new NewCarFragment();

                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            };
        });

        btIndexCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment = new IndexCarFragment();

                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            };
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
