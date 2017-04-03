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
 *
 *
 */
//realy need to set it public???
 public class TriangleDown extends View {


    /**
     * Super class constructor from view
     * @param context
     */
    public TriangleDown(Context context) {
        super(context);
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
        Paint paintBackground = new Paint();
        Paint paintFill = new Paint();
        Paint paintFrame = new Paint();

        paintBackground.setColor(Color.WHITE);
        //print background
        canvas.drawPaint(paintBackground);

        /**
         * making the frame for the triangle additions
         */
        paintFill.setStrokeWidth(4);
        paintFill.setColor(Color.YELLOW);
        paintFill.setStyle(Paint.Style.FILL_AND_STROKE);
        //the hell why? what is this?
        paintFill.setAntiAlias(true);

        /**
         * canvas probably only works with points?!
         */
        Point a = new Point(screenWidth / 2 + 100, screenHeight / 2);
        Point b = new Point(screenWidth / 2 - 100, screenHeight / 2);
        Point c = new Point(screenWidth / 2, screenHeight / 2 + 100);

        Point d = new Point(screenWidth / 2 + 90, screenHeight / 2 + 10);
        Point e = new Point(screenWidth / 2 - 90, screenHeight / 2 + 10);
        Point f = new Point(screenWidth / 2 - 10, screenHeight / 2 + 90);
        //fill triangle
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(a.x,a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);

        path.moveTo(d.x,d.y);
        path.lineTo(e.x, e.y);
        path.lineTo(f.x, f.y);
        path.lineTo(d.x, d.y);
        path.close();

        canvas.drawPath(path, paintFill);



        Path pathInner = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);






        //starting to draw frame!
        paintFrame.setStrokeWidth(4);
        paintFrame.setColor(Color.BLACK);


        //draw from left to right till first vertex of triangle important!!!!!!!!
        canvas.drawLine(0,screenHeight/2,screenWidth,screenHeight/2, paintFrame);




        //basic directions on where to draw the triangle!!
        //draw from vertex corner to top of the triangle
        canvas.drawLine(screenWidth/2 - 100,screenHeight / 2,screenWidth/2,screenHeight/2 + 100, paintFrame);



        //draw from top of triangle to the right line
        canvas.drawLine(screenWidth/2 + 100,screenHeight / 2,screenWidth/2,screenHeight/2 + 100, paintFrame);



    //draw inner traingle left to top
        canvas.drawLine(screenWidth/2 - 60,screenHeight / 2 + 10, screenWidth/2, screenHeight/2 + 80, paintFrame);

        canvas.drawLine(screenWidth/2 + 60,screenHeight / 2 + 10,screenWidth/2, screenHeight/2 + 80, paintFrame);


        //draw inner ground line
        canvas.drawLine(screenWidth/2 - 60,screenHeight / 2 + 10,screenWidth/2 + 60,screenHeight / 2 + 10, paintFrame);

    }

}
