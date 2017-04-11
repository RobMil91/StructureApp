package com.example.robin.structurestart.control;

import com.example.robin.structurestart.model.Algorithm;
import com.example.robin.structurestart.model.Model;

/**
 * Observer of the OptionsAcitivity and Main Activity
 * The manage class gets the values for the model and
 * algorithm from the gui and creates an ImageSwitch with it
 */
public class Manage {

    private Algorithm alg;
    private Model model;

    private int entiretime;



    public Manage(Model model, ImageSwitch imgSwitch, Algorithm alg) {


    }



    public ImageSwitch getImageSwitch() {




        //todo
        return null;
    }


    /**
     * Method to get the current values from the subjects
     */
    public void update(int entiretime) {

        this.entiretime = entiretime;

    }


}
