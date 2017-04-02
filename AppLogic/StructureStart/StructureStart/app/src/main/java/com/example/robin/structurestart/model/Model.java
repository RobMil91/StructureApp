package com.example.robin.structurestart.model;

import android.graphics.Color;
import android.view.View;

/**
 * Class to contain all the different view classes
 */

public class Model {

    private Color backgroundColor;
    private  Color lineColor;
    private  Color triangleColor;
    private   Color triangleLightColor;
    private   Boolean triangleFilled;

    public Model (Color backgroundColor, Color lineColor, Color triangleColor, Color triangleLightColor, Boolean triangleFilled) {

        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
        this.triangleColor = triangleColor;
        this. triangleLightColor = triangleLightColor;
        this.triangleFilled = triangleFilled;

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
