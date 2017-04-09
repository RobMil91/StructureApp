package com.example.robin.structurestart.model;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Basic functional testing of the algorithm class
 */
public class AlgorithmTest {







    @Test
    public void testLength() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        assertEquals(40, algorithm1.calcArrayLenngth());


    }

    @Test
    public void testUpMethod() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        assertEquals(20, algorithm1.calcAmmountUp());


    }

    @Test
    public void testReturnMethod() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        assertEquals(40, algorithm1.getIntegerArray().length);


    }


    @Test
    public void checkUpAmmount() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        algorithm1.fillArray();

        for (int i = 0; i < 20; i++) {

            assertEquals(1,algorithm1.upDownArray[i]);
        }

    }

    @Test
    public void checkDownAmmount() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        algorithm1.fillArray();

        for (int i = 20; i <= 39; i++) {

            assertEquals(0,algorithm1.upDownArray[i]);
        }

    }

    @Test
    public void checkRatio() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        int[] testArray = algorithm1.getIntegerArray();

        int upsAmmount = 0;
        int downAmmount = 0;
        for (int i = 0; i < 40; i++) {


            if (testArray[i] == 0) {
                downAmmount++;
            } else if (testArray[i] == 1) {
                upsAmmount++;
            } else {
                fail("only 0 and 1 should appear!");
            }

        }
        assertEquals(20, upsAmmount);
        assertEquals(20, downAmmount);

    }



}