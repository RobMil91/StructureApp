package com.example.robin.structurestart.model;

import android.graphics.Color;
import android.view.View;

import com.example.robin.structurestart.model.viewclasses.TriangleDown;
import com.example.robin.structurestart.model.viewclasses.TriangleUp;
import com.example.robin.structurestart.model.viewclasses.ViewEmpty;

/**
 * Class to contain all the different view classes
 */

public class Model {

    /**
     * Initiating Variables
     */
    private Color backgroundColor;
    private  Color lineColor;
    private  Color triangleColor;
    private   Color triangleLightColor;
    private   Boolean triangleFilled;

    /**
     * Viewclasses
     */
    private TriangleDown triangleDown;
    private TriangleUp triangleUp;
    private ViewEmpty viewEmpty;


    /**
     *
     * @param backgroundColor Color of the background
     * @param lineColor color of the lines
     * @param triangleColorUp color of the
     * @param triangleLightColor
     * @param triangleFilled
     */
    public Model (Color backgroundColor, Color lineColor, Color triangleColorUp, Color triangleColorDown, Color triangleLightColor, Boolean triangleFilled) {

        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
        this.triangleColor = triangleColor;
        this.triangleLightColor = triangleLightColor;
        this.triangleFilled = triangleFilled;

    }

    public void colorViews() {
/*
   Paint testPaint = new Paint();
        testPaint.setColor(100);
        testPaint.setARGB(1,255,0,255);
*/

    }



    public View getImageEmpty() {
        return null;
    }

    public View getTriangleUp() {
        return null;
    }

    public View getTriangleLightUp() {
        return null;
    }

    public View getTriangleDown() {
        return null;
    }
    public View getTriangleLightDown() {
        return null;
    }
}
