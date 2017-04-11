package com.example.robin.structurestart.control;

import com.example.robin.structurestart.model.Algorithm;
import com.example.robin.structurestart.model.Model;
import com.example.robin.structurestart.view.OptionsAcitvity;
import com.example.robin.structurestart.view.StartActivity;

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
    private StartActivity startAct;
    private OptionsAcitvity optAct;



    public Manage(Model model, ImageSwitch imgSwitch, Algorithm alg, StartActivity startAct, OptionsAcitvity optAct) {

        this.startAct = startAct;
        startAct.registerObserver(this);

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
