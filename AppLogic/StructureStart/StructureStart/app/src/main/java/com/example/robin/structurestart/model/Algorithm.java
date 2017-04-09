package com.example.robin.structurestart.model;

/**
 * Class to create an Boolean Array for the up and down
 * which should be randomizsed
 */
public class Algorithm {

    private int entiretime;
    private int lightUpTime;
    private int pausetime;
    private int emptytime;
    private int[]  upDownArray;

    public Algorithm(int entiretime, int lightUpTime, int pausetime, int emptytime) {
        this.entiretime = entiretime;
        this.lightUpTime = lightUpTime;
        this.pausetime = pausetime;
        this.emptytime = emptytime;


    }

    private void calcArrayLenngth() {

      int sol =  entiretime / (pausetime + lightUpTime + emptytime);

    }



}
