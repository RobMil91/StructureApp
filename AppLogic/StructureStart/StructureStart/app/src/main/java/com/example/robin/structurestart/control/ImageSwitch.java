package com.example.robin.structurestart.control;

import android.view.View;

import com.example.robin.structurestart.model.Model;

import java.util.logging.Handler;

/**
 * Class to switch the images
 */

public class ImageSwitch{

   private android.os.Handler handler;
    private Model model;
    private int entiretime;
    private int lightUpTime;
    private int pausetime;
    private boolean sound;
    private int soundKind;

    /**
     * @param model give the switcher the model for the images
     * @param entiretime runtime of the image sequenze
     * @param lightUpTime time how long the lightupTriangle should be shown
     * @param pausetime time between the the triangles
     * @param sound if sound should be integrated boolean
     * @param soundKind decide which kind of sound should be played
     */
    public ImageSwitch(Model model, int entiretime, int lightUpTime, int pausetime, boolean sound, int soundKind) {



    }



    public void seqeunzstart() {

        //start the handler
        this.handler = new android.os.Handler();



    }
}
