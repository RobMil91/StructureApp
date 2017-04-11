package com.example.robin.structurestart.control;

import android.app.Activity;

import com.example.robin.structurestart.model.Algorithm;
import com.example.robin.structurestart.model.Model;
import com.example.robin.structurestart.view.MainActivity;
import com.example.robin.structurestart.view.OptionsAcitvity;
import com.example.robin.structurestart.view.RunActivity;

/**
 * Observer of the OptionsAcitivity and Main Activity
 * The manage class gets the values for the model and
 * algorithm from the gui and creates an ImageSwitch with it
 */
public class Manage {

    private Algorithm alg;
    private Model model;

    private int entiretime;

    //subjects
    private MainActivity mainAct;
    private OptionsAcitvity optAct;



    public Manage(Model model, ImageSwitch imgSwitch, Algorithm alg, MainActivity mainAct, OptionsAcitvity optAct) {

        this.mainAct = mainAct;
        mainAct.registerObserver(this);

        /* //code to be implemented
        this.optAct = optAct;
        optAct.registerObserver(this);
        */

    }



    public ImageSwitch getImageSwitch() {




        //todo
        return null;
    }


    /**
     * Method to get the current values from the subjects
     * has to be adjusted for future values
     */
    public void update(int entiretime) {

        this.entiretime = entiretime;

    }


}
