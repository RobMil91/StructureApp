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
        paintFill.setStyle(Paint.Style.FILL);
        //the hell why? what is this?
        paintFill.setAntiAlias(true);

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

        canvas.drawPath(path, paintFill);









        //starting to draw frame!
        paintFrame.setStrokeWidth(4);
        paintFrame.setColor(Color.BLACK);


        //draw from left to right...
        canvas.drawLine(0,screenHeight/2,screenWidth,screenHeight/2, paintFrame);




        //basic directions on where to draw the triangle!!
        //draw from vertex corner to top of the triangle
        canvas.drawLine(screenWidth/2 - 100,screenHeight / 2,screenWidth/2,screenHeight/2 + 100, paintFrame);



        //draw from top of triangle to the right line
        canvas.drawLine(screenWidth/2 + 100, screenHeight / 2,screenWidth / 2, screenHeight / 2 + 100, paintFrame);







    //draw inner traingle left to top
        //draw line from a' to c'
        canvas.drawLine(screenWidth/2 - 75,screenHeight / 2 + 10, screenWidth/  2, screenHeight/2 + 85, paintFrame);

        //draw from b' to c'
        canvas.drawLine(screenWidth/2 + 75,screenHeight / 2 + 10, screenWidth / 2, screenHeight/2 + 85, paintFrame);


        //draw inner ground line
        canvas.drawLine(screenWidth / 2 - 75,screenHeight / 2 + 10, screenWidth / 2 + 75,screenHeight / 2 + 10,paintFrame);

    }

}
