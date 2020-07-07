package com.ntu.dip2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    Spinner schoolChoice, yearChoice;
    ArrayAdapter<CharSequence> schoolAdapter, yearAdapter;
    Button confirm;
    CheckBox directYear2;
    String school, year, email;
    Boolean isDirectYear2 = false;
    CloudStoreInterface cloudStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        schoolChoice = findViewById(R.id.school_spinner);
        yearChoice = findViewById(R.id.year_spinner);
        confirm = findViewById(R.id.btn_create);
        directYear2 = findViewById(R.id.checkYear2);

        adapterCreator();

        CloudFirestore cloudFirestore = new CloudFirestore();
        setCloudStore(cloudFirestore);

    }

    private void adapterCreator(){

        // Create an ArrayAdapter using the string array and a default spinner layout
        schoolAdapter = ArrayAdapter.createFromResource(this, R.array.school, android.R.layout.simple_spinner_item);
        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolChoice.setAdapter(schoolAdapter);

        schoolChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                school = schoolChoice.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }
        );

        // Create an ArrayAdapter using the string array and a default spinner layout
        yearAdapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearChoice.setAdapter(yearAdapter);

        yearChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year = yearChoice.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        }
        );

        //Direct Year 2
        directYear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(directYear2.isChecked()){
                    isDirectYear2 = true;
                }
            }
        }
        );

        //Click on create profile button to pass all inputs to firebase
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInfo();
            }
        });

    }

    private void updateInfo(){
        User newUser = new User(school, year);
        cloudStore.addNewUser(newUser);
        startActivity(new Intent(getApplicationContext(), MainAppActivity.class));
    }

    public void setCloudStore(CloudStoreInterface cloudStore){
        this.cloudStore = cloudStore;
    }

}
