package com.ntu.dip2020;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;


public class GPACalculator extends AppCompatActivity {

    Button addCourse, calculate;
    TableLayout courseTable;
    ScrollView mscrollView;
    TextView totalAUResult, semGPAResult, gradedAUResult, CGPAResult;

    String totalAU, totalSemGPA, totalGradedAU, totalCGPA;

    ArrayList<View> viewArrayList = new ArrayList<>();
    //ArrayList<String> gradeArrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_calculator);
        setUp();
    }

    private void setUp() {
        mscrollView = findViewById(R.id.scrollView2);
        addCourse = findViewById(R.id.add_course);
        courseTable = findViewById(R.id.course_table);
        semGPAResult = findViewById(R.id.semGPA_result);
        totalAUResult = findViewById(R.id.totalAU_result);
        gradedAUResult = findViewById(R.id.gradedAU_result);
        CGPAResult = findViewById(R.id.CGPA_result);
        calculate = findViewById(R.id.Calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveData();
            }
        });

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View newRow = inflater.inflate(R.layout.table_row_item, null);
                courseTable.addView(newRow);
                viewArrayList.add(newRow);
            }
        });
    }

    public void retrieveData() {

        int auTotal = 0;
        int au;
        int gradedAU = 0;
        double gradeTotal = 0;
        double semGPA, CGPA;
        double mockCurrentGradeTotal = 4.5;
        double mockCurrentGradedAU = 80;

        String grade;

        for (int i = 0; i < viewArrayList.size(); i++) {

            View child = viewArrayList.get(i);
            EditText auEditText = child.findViewById(R.id.au_input);
            au = Integer.parseInt(auEditText.getText().toString());
            auTotal += au;
            gradedAU += au;

            EditText gradeEditText = child.findViewById(R.id.grade_input);
            grade = gradeEditText.getText().toString();

            switch (grade) {
                case "A+":
                case "A":
                    gradeTotal += 5 * au;
                    break;
                case "A-":
                    gradeTotal += 4.5 * au;
                    break;
                case "B+":
                    gradeTotal += 4 * au;
                    break;
                case "B":
                    gradeTotal += 3.5 * au;
                    break;
                case "B-":
                    gradeTotal += 3 * au;
                    break;
                case "C+":
                    gradeTotal += 2.5 * au;
                    break;
                case "C":
                    gradeTotal += 2 * au;
                    break;
                case "C-":
                    gradeTotal += 1.5 * au;
                    break;
                case "D+":
                    gradeTotal += 1 * au;
                case "D":
                    gradeTotal += 0.5 * au;
                default:
                    gradeTotal += 0;
                    break;
            }

            if(grade.equals("SU")){
                gradedAU -= au;
            }
        }

        totalAU = Integer.toString(auTotal);
        totalAUResult.setText(totalAU);

        totalGradedAU = Integer.toString(gradedAU);
        gradedAUResult.setText(totalGradedAU);

        semGPA = gradeTotal/gradedAU;
        totalSemGPA = Double.toString(semGPA);
        semGPAResult.setText(totalSemGPA);

        CGPA = (mockCurrentGradeTotal+gradeTotal)/(mockCurrentGradedAU + gradedAU);
        totalCGPA = Double.toString(CGPA);
        CGPAResult.setText(totalCGPA);

    }

    /*private void adapterCreator() {

        // Create an ArrayAdapter using the string array and a default spinner layout
        gradeAdaptor = ArrayAdapter.createFromResource(this, R.array.grade, android.R.layout.simple_spinner_item);
        gradeAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gradeChoice.setAdapter(gradeAdaptor);

        gradeChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemGrade = gradeChoice.getSelectedItem().toString();
                gradeArrayList.add(itemGrade);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        }
        );
    }*/

}
