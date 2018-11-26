package com.example.spyros.rentacar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener {
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String DATE_TIME = "datetime";
    public static final String RENT_DAYS = "rentdays";
    public static final String CAR_SELECT = "carselect";
    int year,month,day,hour,minute;
    int yearFinal;
    int monthFinal ;
    int dayFinal,hourFinal,minuteFinal;
    Spinner spinner;
    ArrayAdapter<CharSequence>adapter;
    String car_select;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        Button button = (Button) findViewById(R.id.button);
        //adapter spinnet
       adapter = ArrayAdapter.createFromResource(this, R.array.car_types, android.R.layout.simple_spinner_item);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adapter);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               car_select=parent.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

       //Button Listenet
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        //Date Listener
        final TextView date = (TextView) findViewById(R.id.date_time);
        date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {


                Calendar c = Calendar.getInstance();
                day = c.get(Calendar.DAY_OF_MONTH);
                month = c.get(Calendar.MONTH);
                year = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, MainActivity.this, year, month, day);
                datePickerDialog.show();


            }
        });}


        public void openActivity2 () {


            EditText mName = (EditText) findViewById(R.id.name_id);
            EditText mSurname = (EditText) findViewById(R.id.surname_id);
            TextView mDateTime = (TextView) findViewById(R.id.date_time);
            EditText mRentDays = (EditText) findViewById(R.id.rent_days);
            Spinner mCarSelect=(Spinner)findViewById(R.id.spinner);
            String name = mName.getText().toString();
            String surname = mSurname.getText().toString();
            String datetime = mDateTime.getText().toString();
            String rentdays = mRentDays.getText().toString();
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra(NAME, name);
            intent.putExtra(SURNAME, surname);
            intent.putExtra(DATE_TIME, datetime);
            intent.putExtra(RENT_DAYS, rentdays);
            intent.putExtra(CAR_SELECT,car_select);
            startActivity(intent);


        }






    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        yearFinal = year;
        monthFinal = month+1;
         dayFinal = dayOfMonth;
        Calendar c = Calendar.getInstance();
         hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, MainActivity.this, hour, minute, android.text.format.DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        hourFinal = hourOfDay;
        minuteFinal = minute;
        TextView datetime = (TextView) findViewById(R.id.date_time);
        datetime.setText(dayFinal+"/"+monthFinal+"/"+yearFinal+"  "+hourFinal+":"+minuteFinal);
    }
}