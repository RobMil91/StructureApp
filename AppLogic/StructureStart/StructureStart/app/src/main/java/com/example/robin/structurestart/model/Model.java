package com.example.robin.structurestart.model;

import android.content.Context;
import android.graphics.Paint;
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
    private Paint backgroundPaint;
    private  Paint linePaint;
    private  Paint triangleUpPaint;
    private  Paint triangleDownPaint;
    private   Paint triangleUpLightPaint;
    private   Paint triangleDownLightPaint;

    private Context context;
    /**
     * Viewclasses
     */
    private TriangleDown triangleDown;
    private TriangleDown triangleLightDown;
    private TriangleUp triangleUp;
    private TriangleUp triangleLightUp;
    private ViewEmpty viewEmpty;


    public Model (Context context, Paint backgroundPaint, Paint linePaint, Paint trianglePaintUp, Paint trianglePaintDown, Paint triangleUpLightPaint, Paint triangleDownLightPaint) {

        this.context = context;
        this.backgroundPaint = backgroundPaint;
        this.linePaint = linePaint;
        this.triangleUpPaint = trianglePaintUp;
        this.triangleDownPaint = trianglePaintDown;
        this.triangleUpLightPaint = triangleUpLightPaint;
        this.triangleDownLightPaint = triangleDownLightPaint;
        createModel();

    }


    public void createModel() {

        //create Empty TriangleDown -> filled empty
        triangleDown = new TriangleDown(context, backgroundPaint, linePaint, triangleDownPaint, false);
        //create FullTriangle for lightUp Sequenze


    }


    public View getImageEmptyView() {
        return viewEmpty;
    }

    public View getTriangleUpView() {
        return triangleUp;
    }

    public View getTriangleLightUpView() {
        return triangleLightUp;
    }

    public View getTriangleDownView() {
        return triangleDown;
    }

    public View getTriangleLightDownView() {
        return triangleLightDown;
    }
}
