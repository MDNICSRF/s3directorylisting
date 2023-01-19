package com.daimajia.androidviewhover.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class Util {

    public static Bitmap getViewBitmap(View v) {
        if(v.getWidth() == 0 || v.getHeight() == 0)
            return null;
        Bitmap b = Bitmap.createBitmap( v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.draw(c);
        return b;
    }

    public static void reset(View ta