package com.example.robin.Structure.model.viewclasses;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Empty background view with just the background color
 */

public class ViewEmpty extends View {

    private Paint backgroundPaint;

    public ViewEmpty(Context context, Paint backgroundPaint) {
        super(context);
        this.backgroundPaint = backgroundPaint;

    }

    /**
     * Override the onDraw Method to color the background
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {

        Paint paintBackground = new Paint();
       // paintBackground.setColor(backgroundPaint);
        canvas.drawPaint(backgroundPaint);
    }
}
