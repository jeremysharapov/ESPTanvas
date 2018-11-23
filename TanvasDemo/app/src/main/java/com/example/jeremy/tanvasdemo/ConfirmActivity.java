package com.example.jeremy.tanvasdemo;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity {

    TextView tv;
    ImageButton ib2;
    ImageButton ib3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent intent2 = getIntent();
        tv = (TextView)findViewById(R.id.textView);
        ib2 = (ImageButton)findViewById(R.id.imageButton3);
        ib3 = (ImageButton)findViewById(R.id.imageButton);
        int hour = intent2.getIntExtra("hour", 0);
        //hour++;
        boolean pm = false;
        if (hour / 12 == 1){
            hour -= 12;
            pm = true;
        }
        if (hour == 0){
            hour = 12;
        }
        int minute = intent2.getIntExtra("minute", 0);
        String minuteS = String.valueOf(minute);
        if (minute < 10){
            minuteS = "0" + minuteS;
        }
        String enteredT = String.valueOf(hour) + ":" + minuteS;
        if (pm){
            enteredT = enteredT + " pm";
        }
        else{
            enteredT = enteredT + " am";
        }
        tv.setText(enteredT);
        final String enteredF = enteredT;
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfirmActivity.this, "Alarm set for: " + enteredF, Toast.LENGTH_SHORT).show();
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(ConfirmActivity.this, MainActivity.class);
                startActivity(intent3);
            }
        });
    }
}
