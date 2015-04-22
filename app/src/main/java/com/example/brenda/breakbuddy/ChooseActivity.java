package com.example.brenda.breakbuddy;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ChooseActivity extends ActionBarActivity {

    Button btnMusic, btnPic, btnVid, btnExercise, btnOwn;
    static String mediaType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        btnMusic = (Button) findViewById(R.id.buttonMusic);
        btnPic = (Button) findViewById(R.id.PicButton);
        btnVid = (Button) findViewById(R.id.VideoButton);
        btnExercise = (Button) findViewById(R.id.ExerciseButton);
        btnOwn = (Button) findViewById(R.id.OwnButton);

        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaType = "MUSIC";
                Intent intent = new Intent(ChooseActivity.this, ActivityDisplay.class);
                startActivity(intent);
                if(MainActivity.breakCounter != null) {
                    MainActivity.breakCounter.start();
                    Toast.makeText(getApplicationContext(), "Break time started!!!", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Untimed break started!!!", Toast.LENGTH_LONG).show();
            }
        });
        btnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaType = "PICTURES";
                Intent intent = new Intent(ChooseActivity.this, ActivityDisplay.class);
                startActivity(intent);
                if(MainActivity.breakCounter != null) {
                    MainActivity.breakCounter.start();
                    Toast.makeText(getApplicationContext(), "Break time started!!!", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Untimed break started!!!", Toast.LENGTH_LONG).show();
            }
        });
        btnVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaType = "VIDEOS";
                Intent intent = new Intent(ChooseActivity.this, ActivityDisplay.class);
                startActivity(intent);
                if(MainActivity.breakCounter != null) {
                    MainActivity.breakCounter.start();
                    Toast.makeText(getApplicationContext(), "Break time started!!!", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Untimed break started!!!", Toast.LENGTH_LONG).show();
            }
        });
        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaType = "EXERCISES";
                Intent intent = new Intent(ChooseActivity.this, ActivityDisplay.class);
                startActivity(intent);
                if(MainActivity.breakCounter != null) {
                    MainActivity.breakCounter.start();
                    Toast.makeText(getApplicationContext(), "Break time started!!!", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Untimed break started!!!", Toast.LENGTH_LONG).show();
            }
        });
        btnOwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaType = "OWN";
                if(MainActivity.breakCounter != null) {
                    MainActivity.breakCounter.start();
                    Toast.makeText(getApplicationContext(), "Break time started!!!", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Untimed break started!!!", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose, menu);
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
