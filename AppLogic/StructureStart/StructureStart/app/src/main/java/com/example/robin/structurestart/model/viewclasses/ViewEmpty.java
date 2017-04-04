package com.example.robin.structurestart.model.viewclasses;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Empty background view with just the background color
 */

public class ViewEmpty extends View {

    public ViewEmpty(Context context) {
        super(context);


    }

    /**
     * Override the onDraw Method to color the background
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {

        Paint paintBackground = new Paint();
        paintBackground.setColor(Color.BLUE);
        canvas.drawPaint(paintBackground);
    }
}
