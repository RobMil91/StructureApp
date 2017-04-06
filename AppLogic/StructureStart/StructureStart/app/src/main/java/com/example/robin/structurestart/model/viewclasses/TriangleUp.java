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
 public class TriangleUp extends View {

    private Paint backgroundPaint;
    private Paint linePaint;
    private Paint trianglePaint;
    private Boolean triangleFilled;

    /**
     *
     * @param context usually this as in the running activity!
     * @param backgroundPaint color of the background
     * @param linePaint color of the lines
     * @param trianglePaint color of the triangle
     * @param triangleFilled boolean if the triangle should be filled
     */
    public TriangleUp(Context context, Paint backgroundPaint, Paint linePaint, Paint trianglePaint, Boolean triangleFilled) {
        super(context);
        this.backgroundPaint = backgroundPaint;
        this.linePaint = linePaint;
        this.trianglePaint = trianglePaint;
        this.triangleFilled = triangleFilled;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        int screenWidth = canvas.getWidth();
        int screenHeight = canvas.getHeight();

        //iniate the paints
        linePaint.setStrokeWidth(4);
        linePaint.setAntiAlias(true); //for smoothing edges!

        //print the structures with paint
        canvas.drawPaint(backgroundPaint);



        if (triangleFilled) {
            trianglePaint.setStyle(Paint.Style.FILL_AND_STROKE);
            drawFullTriangleColor(canvas, screenHeight, screenWidth);


        } else {
            trianglePaint.setStyle(Paint.Style.FILL);
            drawInnerTriangle(canvas, screenHeight, screenWidth);
            drawEmptyTriangleColor(canvas, screenHeight, screenWidth);

        }



        drawOuterFrame(canvas, screenHeight, screenWidth);

    }

    /**
     * Draw inner triangle
     * @param canvas from the onDraw Method
     * @param screenHeight from the onDraw Method
     * @param screenWidth from the onDraw Method
     */
    public void drawInnerTriangle(Canvas canvas, int screenHeight, int screenWidth) {
        //draw inner traingle left to top
        //draw line from a' to c'
        canvas.drawLine(screenWidth/2 - 75,screenHeight / 2 - 10, screenWidth/  2, screenHeight/2 - 85, linePaint);
        //draw from b' to c'
        canvas.drawLine(screenWidth/2 + 75,screenHeight / 2 - 10, screenWidth / 2, screenHeight/2 - 85, linePaint);
        //draw inner ground line
        canvas.drawLine(screenWidth / 2 - 75,screenHeight / 2 - 10, screenWidth / 2 + 75,screenHeight / 2 - 10, linePaint);
    }

    /**
     * Method for drawing the paint component of the triangle
     * all method variables from onDraw() method
     * @param canvas
     * @param screenHeight
     * @param screenWidth
     */
    public void drawEmptyTriangleColor(Canvas canvas, int screenHeight, int screenWidth) {

        Point a = new Point(screenWidth / 2 - 100, screenHeight / 2);
        Point b = new Point(screenWidth / 2 + 100, screenHeight / 2);
        Point c = new Point(screenWidth / 2, screenHeight / 2 - 100);

        //points of inner triangle
        Point d = new Point(screenWidth/2 - 75,screenHeight / 2 - 10);
        Point e = new Point(screenWidth/2 + 75,screenHeight / 2 - 10);
        Point f = new Point(screenWidth /  2, screenHeight / 2 - 85);

        //path for outer line triangle
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(a.x,a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);


        //path for inner triangle with d e f instead of a' b' c'
        path.moveTo(d.x,d.y);
        path.lineTo(e.x, e.y);
        path.lineTo(f.x, f.y);
        path.lineTo(d.x, d.y);
        path.close();

        canvas.drawPath(path, trianglePaint);
    }

    /**
     * Draw the outer frame of the triangle
     * all method variables from onDraw() method
     * @param canvas
     * @param screenHeight
     * @param screenWidth
     */
    public void drawOuterFrame(Canvas canvas, int screenHeight, int screenWidth) {


        //draw from left to right till first vertex of triangle important!!!!!!!!
        canvas.drawLine(0,screenHeight/2,screenWidth,screenHeight/2, linePaint);

        //draw from vertex corner to top of the triangle
        canvas.drawLine(screenWidth/2 - 100,screenHeight / 2,screenWidth/2,screenHeight/2 - 100, linePaint);

        //draw from top of triangle to the right line
        canvas.drawLine(screenWidth/2 + 100,screenHeight / 2,screenWidth/2,screenHeight/2 - 100, linePaint);

    }

    public void drawFullTriangleColor(Canvas canvas, int screenHeight, int screenWidth) {

        Point a = new Point(screenWidth / 2 - 100, screenHeight / 2);
        Point b = new Point(screenWidth / 2 + 100, screenHeight / 2);
        Point c = new Point(screenWidth / 2, screenHeight / 2 - 100);

        //path for outer line triangle
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(a.x,a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);

        path.close();

        canvas.drawPath(path, trianglePaint);


    }

}
