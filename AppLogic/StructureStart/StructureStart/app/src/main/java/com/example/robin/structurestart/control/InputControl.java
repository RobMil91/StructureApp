package com.example.robin.structurestart.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to check Input for mistakes
 */

public class InputControl {



    public boolean time(String timeTextView) {

    //   int check = Integer.parseInt(timeTextView);

      //  Pattern p = Pattern.compile("^(1[0-2]|[1-9])$");
        Pattern p = Pattern.compile("^(1[0-2]|[1-9])$");
        Matcher m = p.matcher(timeTextView);
        boolean b = m.matches();

        if (b) {
            return true;
        } else {

            return false;
        }


    }
}
