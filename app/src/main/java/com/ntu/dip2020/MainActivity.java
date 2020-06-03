package com.ntu.dip2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner schoolChoice, yearChoice;
    ArrayAdapter<CharSequence> schoolAdapter, yearAdapter;
    EditText matricNum;
    Button confirm;
    CheckBox directYear2;
    String school, year, matric;
    Boolean isDirectYear2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        schoolChoice = findViewById(R.id.school_spinner);
        yearChoice = findViewById(R.id.year_spinner);
        matricNum = findViewById(R.id.matric);
        confirm = findViewById(R.id.btn_create);
        directYear2 = findViewById(R.id.checkYear2);

        matric = matricNum.getText().toString();


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

            }
        });

    }

}
