package com.example.brenda.breakbuddy;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by Leena on 3/29/2015.
 */
public class CounterClass extends CountDownTimer
{
    String hms;
    static boolean work_done, break_done;
    public CounterClass(long millisInFuture, long countDownInterval)
    {
        super(millisInFuture, countDownInterval);
        hms = "Ready To Begin!";
        work_done = false;
        break_done = false;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        long millis = millisUntilFinished;
        hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis)-TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        TimedBreakScreen.textViewTime.setText(hms);
    }

    public String getHms()
    {
        return hms;
    }
    @Override
    public void onFinish() {
        Log.d("Brenda", "Counter Done");
        hms = "00:00:00";
        TimedBreakScreen.textViewTime.setText(hms);
        if(this.equals(MainActivity.workCounter))
        {
            work_done = true;
            Log.d("Brenda", "Work Counter Finished");
            MyService.breakNotify();
        }
        else
        {
            break_done = true;
            Log.d("Brenda", "BreakCounter Finished");
            MyService.workNotify();
            MainActivity.workCounter.start();
        }
    }
}