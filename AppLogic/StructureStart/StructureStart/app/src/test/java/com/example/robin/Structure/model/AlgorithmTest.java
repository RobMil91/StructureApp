package com.example.robin.Structure.model;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Basic functional testing of the algorithm class
 *
 */
public class AlgorithmTest {


    //check internal methods (have to be public to be tested)
/*
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
    public void checkUpAmmount() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        algorithm1.fillArray();

            int current = 0;
        for (int i = 0; i < 20; i++) {

            current = algorithm1.list.get(i);
            assertEquals(1,current);
        }

    }



    @Test
    public void testReturnMethod() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        assertEquals(40, algorithm1.getIntList().size());


    }




    @Test
    public void checkDownAmmount() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        algorithm1.fillArray();

        int current = 0;
        for (int i = 20; i <= 39; i++) {

            current = algorithm1.list.get(i);
            assertEquals(0,current);
        }

    }
*/
    @Test
    public void checkRatio05() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        ArrayList<Integer> testArray = algorithm1.getIntList();

        int upsAmmount = 0;
        int downAmmount = 0;
        for (int i = 0; i < 40; i++) {


            if (testArray.get(i) == 0) {
                downAmmount++;
            } else if (testArray.get(i) == 1) {
                upsAmmount++;
            } else {
                fail("only 0 and 1 should appear!");
            }

        }
        assertEquals(20, upsAmmount);
        assertEquals(20, downAmmount);

    }

    @Test
    public void checkRatio02() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.2);
        ArrayList<Integer> testArray = algorithm1.getIntList();

        int upsAmmount = 0;
        int downAmmount = 0;
        for (int i = 0; i < 40; i++) {


            if (testArray.get(i) == 0) {
                downAmmount++;
            } else if (testArray.get(i) == 1) {
                upsAmmount++;
            } else {
                fail("only 0 and 1 should appear!");
            }

        }
        assertEquals(8, upsAmmount);
        assertEquals(32, downAmmount);
      //  System.printLine()

    }

    @Test
    public void checkRandom05() {
        Algorithm algorithm1 = new Algorithm(480000, 500, 7500, 4000, 0.5);
        ArrayList<Integer> testArray = algorithm1.getIntList();

        for (int i = 0; i < 40; i++) {
            System.out.print(testArray.get(i));
        }


    }


    @Test
    public void checkRandom02() {
        Algorithm algorithm1 = new Algorithm(60000, 500, 7500, 4000, 0.2);
        ArrayList<Integer> testArray = algorithm1.getIntList();

        for (int i = 0; i < 5; i++) {
            System.out.print(testArray.get(i));
        }


    }


}