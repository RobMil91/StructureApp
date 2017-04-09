package com.example.robin.structurestart.model;

import java.util.Arrays;
import java.util.Collections;

/**
 * Class to create an Boolean Array for the up and down
 * which should be randomizsed
 */
public class Algorithm {

    private int entiretime;
    private int lightUpTime;
    private int triaTime;
    private int emptytime;
    private int[]  upDownArray;
    private double ratio;

    /**
     *
     * @param entiretime in milliseconds
     * @param lightUpTime in milliseconds
     * @param pausetime in milliseconds
     * @param emptytime in milliseconds
     * @param ratio  Up and Down Ratio: double value from [0 to 1]
     *              0 means all triangles Down 1 means all triangles Up
     */
    public Algorithm(int entiretime, int lightUpTime, int pausetime, int emptytime, double ratio) {
        this.entiretime = entiretime;
        this.lightUpTime = lightUpTime;
        this.triaTime = pausetime;
        this.emptytime = emptytime;
        this.ratio = ratio;


    }

    private int calcArrayLenngth() {

        double lengthArray = entiretime / (triaTime + lightUpTime + emptytime);

        //make sure int value is achieved
      return  (int) Math.round(lengthArray);

    }

    private int calcAmmountUp() {


        //calculate the ratio to the complete arrayLength
        double calcValueUp = calcArrayLenngth() * ratio;

        //round the possible comma value
        return  (int) Math.round(calcValueUp);

    }

    private void fillArray() {

        //iniatizilise length
        upDownArray = new int[calcArrayLenngth()];

        //walk through array till ratio is full
        for (int i = 0; i <= calcAmmountUp(); i++) {

            //1 stands for triangleUp
            upDownArray[i] = 1;

        }

        for (int i = calcAmmountUp() + 1; i <= calcArrayLenngth(); i++) {

            //0 stands for triangleDown
            upDownArray[i] = 0;

        }


    }

    private int[] randomizeArray() {

    Collections.shuffle(Arrays.asList(upDownArray));

        return upDownArray;
    }

    public int[] getIntegerArray() {

        fillArray();
        return randomizeArray();

    }



}
