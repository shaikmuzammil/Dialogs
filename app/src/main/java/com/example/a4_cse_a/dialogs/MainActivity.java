package com.example.a4_cse_a.dialogs;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int date,month,year;
    int hr,min;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.alert);
        b2=(Button)findViewById(R.id.date);
        b3=(Button)findViewById(R.id.time);

    }

    public void alertDialog(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setTitle("Alert Dialog ...");
        builder.setMessage("Do you wanna meet koundinya ?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"hiii i'm venkat rama koundinya",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void datePicker(View view) {

        Calendar c=Calendar.getInstance();
        date=c.get(Calendar.DATE);
        month=c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);

        DatePickerDialog d=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),year+"-"+(month+1)+"-"+dayOfMonth,Toast.LENGTH_LONG).show();

            }
        },year,month,date);
        d.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void timePicker(View view) {
        Calendar ca=Calendar.getInstance();
        hr=ca.get(Calendar.HOUR);
        min=ca.get(Calendar.MINUTE);
        TimePickerDialog t=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getApplicationContext(),hourOfDay+":"+minute,Toast.LENGTH_LONG).show();


            }
        },hr,min,false);
        t.show();
    }
}
