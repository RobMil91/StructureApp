package com.example.robin.structurestart.control;

import com.example.robin.structurestart.view.MainActivity;
import com.example.robin.structurestart.view.OptionsAcitvity;
import com.example.robin.structurestart.view.RunActivity;

/**
 * Make this class in manifest first called class?
 * then set it to start the Main Activity?
 * Problem: Mainactivity need to update the manage class and
 * send the manage object to the RunActivity this means
 * this class Main has to notice the start button and manually
 * update the
 *
 *
 */
public class Main {

   private MainActivity mainAct;
    private OptionsAcitvity optAct;
    private RunActivity runAct;


    public Main(MainActivity mainAct, OptionsAcitvity optAct, RunActivity runAct) {


    }
}
