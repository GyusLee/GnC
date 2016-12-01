package com.example.user.gnc;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by wbhlkc0 on 2016-11-30.
 */

public class HeroIcon extends LinearLayout {
    int winX;
    int winY;
    int x;
    int y;
    int width;
    int heigth;

    public HeroIcon(Context context, int winX, int winY, int width, int height) {
        super(context);
        x = winX-width/2;
        y = winY-height/2;
        this.width = width;
        this.heigth = height;

        LayoutParams liParameters = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setBackgroundColor(Color.argb(66,255,0,0));
        setLayoutParams(liParameters);
    }
}
