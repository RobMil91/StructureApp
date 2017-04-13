package com.example.robin.Structure.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to create an Boolean Array for the up and down
 * which should be randomizsed
 * ----------------------Refactor the public methods!!!!!
 */
public class Algorithm {

    private int entiretime;
    private int lightUpTime;
    private int triaTime;
    private int emptytime;
    public ArrayList<Integer> upDownArray;
    private double ratio;

    /**
     * The lightUp, triangle and empty time together specify one cycle
     * @param entiretime in milliseconds
     * @param lightUpTime in milliseconds
     * @param triaTime in milliseconds
     * @param emptytime in milliseconds
     * @param ratio  Up and Down Ratio: double value from [0 to 1]
     *              0 means all triangles Down 1 means all triangles Up
     */
    public Algorithm(int entiretime, int lightUpTime, int triaTime, int emptytime, double ratio) {

        this.entiretime = entiretime;
        this.lightUpTime = lightUpTime;
        this.triaTime = triaTime;
        this.emptytime = emptytime;
        this.ratio = ratio;


    }

    //public only for testing Refactor
    public int calcArrayLenngth() {

        double lengthArray = entiretime / (triaTime + lightUpTime + emptytime);

        //make sure int value is achieved
      return  (int) Math.round(lengthArray);

    }

    public int calcAmmountUp() {


        //calculate the ratio to the complete arrayLength
        double calcValueUp = calcArrayLenngth() * ratio;

        //round the possible comma value
        return  (int) Math.round(calcValueUp);

    }

    public ArrayList<Integer> fillArray() {

        //iniatizilise length
        upDownArray = new ArrayList<Integer>();

        //walk through array till ratio is full
        for (int i = 0; i < calcAmmountUp(); i++) {

            //1 stands for triangleUp
            upDownArray.add(i,1);

        }

        for (int i = calcAmmountUp(); i < calcArrayLenngth(); i++) {

            //0 stands for triangleDown
            upDownArray.add(i,0);

        }

        return upDownArray;


    }

    public ArrayList<Integer> randomizeArray(ArrayList<Integer> upDownArray) {




    Collections.shuffle(upDownArray);

        return upDownArray;
    }

    /**
     * Getter Method for the calculated Array
     * @return integer Array with 1 for up and 0 for down
     */
    public ArrayList<Integer> getIntList() {


        return randomizeArray(fillArray());

    }


    public int getEntiretime() {
        return entiretime;
    }

    public int getLightUpTime() {
        return lightUpTime;
    }

    public int getTriaTime() {
        return triaTime;
    }

    public int getEmptytime() {
        return emptytime;
    }


}
