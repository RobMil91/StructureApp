package com.example.robin.structurestart.model;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;

import com.example.robin.structurestart.model.viewclasses.TriangleDown;
import com.example.robin.structurestart.model.viewclasses.TriangleUp;
import com.example.robin.structurestart.model.viewclasses.ViewEmpty;

/**
 * Class to contain all the different view classes
 * and make an easy use for the imageswitcher
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
   private boolean soundOn;

    /**
     * Viewclasses
     */
    private TriangleDown triangleDown;
    private TriangleDown triangleLightDown;
    private TriangleUp triangleUp;
    private TriangleUp triangleLightUp;
    private ViewEmpty viewEmpty;


    public Model (Context context, Paint backgroundPaint, Paint linePaint, Paint trianglePaintUp, Paint trianglePaintDown, Paint triangleUpLightPaint, Paint triangleDownLightPaint, boolean sound) {

        this.context = context;
        this.backgroundPaint = backgroundPaint;
        this.linePaint = linePaint;
        this.triangleUpPaint = trianglePaintUp;
        this.triangleDownPaint = trianglePaintDown;
        this.triangleUpLightPaint = triangleUpLightPaint;
        this.triangleDownLightPaint = triangleDownLightPaint;
        this.soundOn = sound;
        createModel();

    }


    public void createModel() {

        //create Empty TriangleDown -> filled empty
        triangleDown = new TriangleDown(context, backgroundPaint, linePaint, triangleDownPaint, triangleDownLightPaint, false);
        //create FullTriangle for Light Down Sequenze
        triangleLightDown = new TriangleDown(context, backgroundPaint, linePaint, triangleDownPaint, triangleDownLightPaint, true);
        //create triangle up without fill
        triangleUp = new TriangleUp(context, backgroundPaint, linePaint, triangleUpPaint, triangleUpLightPaint, false);
        //create full triangle for light up sequenze
        triangleLightUp = new TriangleUp(context, backgroundPaint, linePaint, triangleUpPaint, triangleUpLightPaint, true);
        //empty view
        viewEmpty = new ViewEmpty(context, backgroundPaint);

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

    public boolean getSoundStatus() { return soundOn;}
}
