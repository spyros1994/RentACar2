package com.example.spyros.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();

        String name=intent.getStringExtra(MainActivity.NAME);
        String surname=intent.getStringExtra(MainActivity.SURNAME);
        String date_time=intent.getStringExtra(MainActivity.DATE_TIME);
        String rent_days=intent.getStringExtra(MainActivity.RENT_DAYS);
        String car_select=intent.getStringExtra(MainActivity.CAR_SELECT);
        TextView nameFinal=(TextView)findViewById(R.id.name_id);
        TextView surnameFinal=(TextView)findViewById(R.id.surname_id);
        TextView dateFinal=(TextView)findViewById(R.id.date_time_id);
        TextView rent_daysFinal=(TextView)findViewById(R.id.rent_days_id);
        TextView car_SelectFinal=(TextView)findViewById(R.id.car_select_id);
        nameFinal.setText("Όνομα:"+name);
        surnameFinal.setText("Επώνυμο:"+surname);
        dateFinal.setText("Ημέρα και ώρα παραλαβής:"+date_time);
        rent_daysFinal.setText("Ημέρες Ενοικίασης:"+rent_days);
        car_SelectFinal.setText("Αυτοκίνητο:"+car_select);

    }
}
