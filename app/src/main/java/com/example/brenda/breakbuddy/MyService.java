package com.example.brenda.breakbuddy;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Leena on 3/30/2015.
 */
public class MyService extends Service {

    //    private Thread thread;
    protected static boolean isRunning = false;
    private static final int BREAK_NOTIFY_ID = 1337;
    private static final int WORK_NOTIFY_ID = 1444;
    private static NotificationCompat.Builder break_note;
    private static NotificationCompat.Builder work_note;
    private static NotificationManager mgr = null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        mgr=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        break_note = new NotificationCompat.Builder(getApplicationContext());
        work_note = new NotificationCompat.Builder(getApplicationContext());
        break_note.setContentTitle("BreakBuddy");
        work_note.setContentTitle("BreakBuddy");
        break_note.setContentText("Time for your break!");
        work_note.setContentText("Time to work!");
        break_note.setSmallIcon(R.mipmap.notification_icon);
        work_note.setSmallIcon(R.mipmap.notification_icon);
        break_note.setDefaults(NotificationCompat.DEFAULT_SOUND);
        work_note.setDefaults(NotificationCompat.DEFAULT_SOUND);
        break_note.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
        work_note.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
        // This pending intent will open after notification click
        PendingIntent i= PendingIntent.getActivity(this, 0,new Intent(this, RateStress.class),0);
        break_note.setContentIntent(i);
        PendingIntent n = PendingIntent.getActivity(this, 0,new Intent(this, MainActivity.class),0);
        work_note.setContentIntent(n);
        isRunning = true;
//        thread.start();
        return START_STICKY;
    }

    public static void breakNotify()
    {
        if(break_note != null) {
            break_note.setWhen(System.currentTimeMillis());
            mgr.notify(BREAK_NOTIFY_ID,break_note.build());
        }
    }

    public static void workNotify()
    {
        if(work_note != null) {
            work_note.setWhen(System.currentTimeMillis());
            mgr.notify(WORK_NOTIFY_ID,work_note.build());
        }
    }
}