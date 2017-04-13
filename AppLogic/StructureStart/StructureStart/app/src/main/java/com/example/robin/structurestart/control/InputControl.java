package com.example.robin.structurestart.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
