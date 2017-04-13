package com.example.robin.Structure.control;

/**
 * Class to check Input for mistakes
 */

public class InputControl {



    public boolean time(String timeTextView) {



        if (timeTextView.matches("([1-9]|1[0-9]|2[0-9])")) {
            return true;
        } else {

            return false;
        }


    }
}
