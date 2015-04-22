package com.example.brenda.breakbuddy;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


public class TimedBreakScreen extends ActionBarActivity {

    static Button btnStart, btnStop;
    static TextView textViewTime;
    static NumberPicker numberPickerWork,numberPickerBreak;
//    static MyServices service = new MyServices();
    // handle Time in services

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timed_break_screen);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        numberPickerWork = (NumberPicker) findViewById(R.id.numberPickerWork);
        numberPickerWork.setMinValue(5);
        numberPickerWork.setMaxValue(120);
        numberPickerBreak = (NumberPicker) findViewById(R.id.numberPickerBreak);
        numberPickerBreak.setMinValue(1);
        numberPickerBreak.setMaxValue(15);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.workCounter = new CounterClass(numberPickerWork.getValue()*60000, 1000);
                MainActivity.breakCounter = new CounterClass(numberPickerBreak.getValue()*60000, 1000);
                if(!MyService.isRunning) {
                    Log.d("Brenda", "Service Started");
                    getApplicationContext().startService(new Intent(getApplicationContext(), MyService.class));
                }
                MainActivity.workCounter.start();
                Toast.makeText(getApplicationContext(), "Work time started!!!", Toast.LENGTH_LONG).show();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApplication().stopService(getIntent());
                if(MainActivity.workCounter != null)
                {
                    MainActivity.workCounter.cancel();
                }
                if(MainActivity.breakCounter != null)
                {
                    MainActivity.breakCounter.cancel();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timed_break_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
