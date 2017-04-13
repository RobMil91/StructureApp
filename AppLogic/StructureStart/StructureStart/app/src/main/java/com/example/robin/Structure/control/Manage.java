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

    private ImageSwitch imgSwitch;



    public Manage( ) {


    }




    public void createStandartModel(RunActivity runActivity, boolean soundOn) {

        Paint paintBackground = new Paint();
        //random light blue to make it more like the original - real one has picture included
        paintBackground.setColor(Color.parseColor("#7ec0ee"));
        //      paintBackground.setARGB(50, 103, 118, 202);


        //triangle Color
        Paint paintFillUp = new Paint();
        paintFillUp.setColor(Color.BLUE);
        // paintFillUp.setColor(Color.parseColor("#a2abf6"));

        Paint paintFillDown = new Paint();
        paintFillDown.setColor(Color.parseColor("#f87f80"));

        Paint lightSeq = new Paint();
        lightSeq.setColor(Color.parseColor("#ecfa00"));


        Paint paintFrame = new Paint();
        paintFrame.setColor(Color.BLACK);

       model = new Model(runActivity, paintBackground, paintFrame, paintFillUp, paintFillDown, lightSeq, lightSeq, soundOn, 1000);

    }


    /**
     * std down up and light sequenzes
     * @param time in minutes
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
