package com.example.jeremy.tanvasdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TimePicker tp;
    Switch sw;
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tp = (TimePicker)findViewById(R.id.choosetime);
        sw = (Switch)findViewById(R.id.switch1);
        ib = (ImageButton)findViewById(R.id.imageButton2);
        tp.setHour(0);
        tp.setMinute(0);
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw.isChecked()) {
                    tp.setHour(tp.getHour() + 12);
                } else {
                    tp.setHour(tp.getHour() - 12);
                }
            }
        });
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, ConfirmActivity.class);
                intent1.putExtra("hour", tp.getHour());
                intent1.putExtra("minute", tp.getMinute());
                startActivity(intent1);
            }
        });
    }
}
