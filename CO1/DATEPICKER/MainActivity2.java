package com.example.regform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {

    EditText dateText;
    public DatePickerDialog datepicker;
    Button pickdate;
    int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dateText=findViewById(R.id.dateedit);
        pickdate=findViewById(R.id.datebutton);

        pickdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calender=Calendar.getInstance();

                day=calender.get(Calendar.DAY_OF_MONTH);
                month=calender.get(Calendar.MONTH);
                year=calender.get(Calendar.YEAR);

                datepicker=new DatePickerDialog(MainActivity2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                        dateText.setText(day+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                datepicker.show();
            }
        });


    }
}