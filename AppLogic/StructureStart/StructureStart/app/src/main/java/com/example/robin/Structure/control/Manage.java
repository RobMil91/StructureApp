package com.example.robin.Structure.control;

import android.graphics.Color;
import android.graphics.Paint;

import com.example.robin.Structure.model.Algorithm;
import com.example.robin.Structure.model.Model;
import com.example.robin.Structure.view.RunActivity;

/**
 * Class to compress the input from the UI to create
 * the algorithm and the model
 */
public class Manage {

    private Algorithm alg;
    private Model model;

    /**
     * Method to create a model which is oriented on the computer
     * programm colors
     *
     * @param runActivity current runActivty
     * @param soundOn     boolean to allow sound
     */
    public void createStandartModel(RunActivity runActivity, boolean soundOn) {

        Paint paintBackground = new Paint();
        paintBackground.setColor(Color.parseColor("#7ec0ee"));

        Paint paintFillUp = new Paint();
        paintFillUp.setColor(Color.BLUE);

        Paint paintFillDown = new Paint();
        paintFillDown.setColor(Color.parseColor("#f87f80"));

        Paint lightSeq = new Paint();
        lightSeq.setColor(Color.parseColor("#ecfa00"));

        Paint paintFrame = new Paint();
        paintFrame.setColor(Color.BLACK);

        model = new Model(runActivity, paintBackground, paintFrame, paintFillUp, paintFillDown, lightSeq, lightSeq, soundOn, 750);

    }


    /**
     * Method to create standart algorithm
     *
     * @param time  in minutes
     * @param ratio 0-1 range of double
     */
    public void createStandartAlg(int time, double ratio) {

        int milliSectime = time * 60 * 1000;
        this.alg = new Algorithm(milliSectime, 500, 7500, 4000, ratio);

    }

    public Model getModel() {
        return this.model;
    }

    public Algorithm getAlg() {
        return alg;
    }


}
