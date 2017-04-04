package com.example.robin.structurestart.model.viewclasses;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;

/**
 * Example View Class in a package
 * Carefull!!! the heights and lengths are aproximated for
 * this exact example adjusting to bigger size might not work
 * easily
 *
 */
//realy need to set it public???
 public class TriangleDown extends View {


    private Paint backgroundPaint;
    private Paint linePaint;
    private Paint trianglePaint;
    private Paint triangleLightPaint;
    private Boolean triangleFilled;

    /**
     * Super class constructor from view
     * @param context
     */
    public TriangleDown(Context context, Paint backgroundPaint, Paint lineColor, Paint triangleColor, Paint triangleLightColor, Boolean triangleFilled) {
        super(context);

        this.backgroundPaint = backgroundPaint;


        this.linePaint = lineColor;
        this.trianglePaint = triangleColor;
        this.triangleFilled = triangleFilled;
        this.triangleLightPaint = triangleLightColor;


    }


    @Override
    protected void onDraw(Canvas canvas) {


        // call the super class onDraw Method
        super.onDraw(canvas);



        /**
         * get the view dimensions!
         */
        int screenWidth = canvas.getWidth();
        int screenHeight = canvas.getHeight();

        //init paint
    //    Paint paintBackground = new Paint(Color.BLACK);
       // Paint paintFill = new Paint();
     //   Paint paintFrame = new Paint();

      //  paintBackground.setColor(Color.WHITE);
        //print background
        canvas.drawPaint(this.backgroundPaint);



        //starting to draw frame!
        linePaint.setStrokeWidth(4);



        /**
         * making the frame for the triangle additions
         */
        this.trianglePaint.setStrokeWidth(4);
       // this.trianglePaint.setColor(Color.YELLOW);
        //change to FILL and STROKE for make the triangle full
        if (triangleFilled) {
            this.trianglePaint.setStyle(Paint.Style.FILL_AND_STROKE);


        } else {
            this.trianglePaint.setStyle(Paint.Style.FILL);
            //draw inner traingle left to top
            //draw line from a' to c'
         canvas.drawLine(screenWidth/2 - 75,screenHeight / 2 + 10, screenWidth/  2, screenHeight/2 + 85, linePaint);

            //draw from b' to c'
            canvas.drawLine(screenWidth/2 + 75,screenHeight / 2 + 10, screenWidth / 2, screenHeight/2 + 85, linePaint);


            //draw inner ground line
            canvas.drawLine(screenWidth / 2 - 75,screenHeight / 2 + 10, screenWidth / 2 + 75,screenHeight / 2 + 10, linePaint);


        }

        //the hell why? what is this?
        this.trianglePaint.setAntiAlias(true);

        /**
         * canvas probably only works with points?!
         */
        Point a = new Point(screenWidth / 2 - 100, screenHeight / 2);
        Point b = new Point(screenWidth / 2 + 100, screenHeight / 2);
        Point c = new Point(screenWidth / 2, screenHeight / 2 + 100);



        //path for triangle
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(a.x,a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);

        //points of inner triangle
        Point d = new Point(screenWidth/2 - 75,screenHeight / 2 + 10);
        Point e = new Point(screenWidth/2 + 75,screenHeight / 2 + 10);
        Point f = new Point(screenWidth /  2, screenHeight / 2 + 85);

        //inner triangle with d e f instead of a' b' c'
        path.moveTo(d.x,d.y);
        path.lineTo(e.x, e.y);
        path.lineTo(f.x, f.y);
        path.lineTo(d.x, d.y);
        path.close();

        canvas.drawPath(path, this.trianglePaint);












        //draw from left to right...
        canvas.drawLine(0,screenHeight/2,screenWidth,screenHeight/2, linePaint);




        //basic directions on where to draw the triangle!!
        //draw from vertex corner to top of the triangle
        canvas.drawLine(screenWidth/2 - 100,screenHeight / 2,screenWidth/2,screenHeight/2 + 100, linePaint);



        //draw from top of triangle to the right line
        canvas.drawLine(screenWidth/2 + 100, screenHeight / 2,screenWidth / 2, screenHeight / 2 + 100, linePaint);









    }

}
