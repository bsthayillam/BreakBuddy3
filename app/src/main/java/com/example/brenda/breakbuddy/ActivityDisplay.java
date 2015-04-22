package com.example.brenda.breakbuddy;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ActivityDisplay extends ActionBarActivity {

    ScrollView scroll;
    LinearLayout layout;
    AssetManager assetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_display);

        assetManager = getApplication().getAssets();
        layout = (LinearLayout)findViewById(R.id.list_activity);
        scroll = (ScrollView)findViewById(R.id.scroll_list);
        if(ChooseActivity.mediaType == "MUSIC")
        {
            String line;
            try {
                InputStream input = assetManager.open("MusicLinks.txt");
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                while((line = in.readLine()) != null) {
                    TextView text = new TextView(this);
                    text.setClickable(true);
                    text.setMovementMethod(LinkMovementMethod.getInstance());
                    String displayText = "<a href='"+line+"'> "+line+" </a>";
                    text.setText(Html.fromHtml(displayText));
                    layout.addView(text);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ChooseActivity.mediaType == "PICTURES")
        {
            InputStream img;
            try {
                String[] files = assetManager.list("Pictures");
                for(int i = 0; i<files.length; i++)
                {
                    img = assetManager.open("Pictures/"+files[i]);
                    Drawable d = Drawable.createFromStream(img, null);
                    ImageView imgView = new ImageView(this);
                    imgView.setImageDrawable(d);
                    layout.addView(imgView);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ChooseActivity.mediaType == "VIDEOS")
        {
            String line;
            try {
                InputStream input = assetManager.open("VideoLinks.txt");
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                while((line = in.readLine()) != null) {
                    TextView text = new TextView(this);
                    text.setClickable(true);
                    text.setMovementMethod(LinkMovementMethod.getInstance());
                    String displayText = "<a href='"+line+"'> "+line+" </a>";
                    text.setText(Html.fromHtml(displayText));
                    layout.addView(text);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ChooseActivity.mediaType == "EXERCISES")
        {
            String line;
            try {
                InputStream input = assetManager.open("ExerciseList.txt");
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                while((line = in.readLine()) != null) {
                    TextView rowTextView = new TextView(this);
                    rowTextView.setText(line);
                    layout.addView(rowTextView);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_display, menu);
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
