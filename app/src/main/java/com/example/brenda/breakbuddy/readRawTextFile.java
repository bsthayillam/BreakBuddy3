package com.example.brenda.breakbuddy;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Leena on 4/7/2015.
 */
public class readRawTextFile {
    public static ArrayList<String> readRawTextFile(Context ctx, int resId)
    {
        ArrayList<String> list = new ArrayList<String>();
        InputStream inputStream = ctx.getResources().openRawResource(resId);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            return null;
        }
        return list;
    }
}
