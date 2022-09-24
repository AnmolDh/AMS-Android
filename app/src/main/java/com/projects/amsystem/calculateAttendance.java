package com.projects.amsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculateAttendance extends AppCompatActivity {

    EditText totalClassesInput, classesAttendedInput;
    Button calculateBtn;
    TextView calculatedValues;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_attendance);

        totalClassesInput = findViewById(R.id.totalClassesInput);
        classesAttendedInput = findViewById(R.id.classesAttendedInput);
        calculateBtn = findViewById(R.id.calculateBtn);
        calculatedValues = findViewById(R.id.calculatedValues);

        calculateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                float tc = Float.parseFloat(totalClassesInput.getText().toString());
                float ca = Float.parseFloat(classesAttendedInput.getText().toString());

                calculatedValues.setText("Your Attendance: " + ((ca/tc)*100) + "%");
                closeKeyBoard();
            }
        });
    }

    private void closeKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
            }
            assert imm != null;
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}