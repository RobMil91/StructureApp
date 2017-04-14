package com.example.robin.Structure.control;

/**
 * Class to check Input for errors
 */
public class InputControl {


    /**
     * Method to check the input seqtimeCheck from start method
     * Currently it allows seqtimeCheck from 1-30
     *
     * @param timeTextView string value which is gotten from intent
     * @return boolean if seqtimeCheck if correct
     */
    public boolean seqtimeCheck(String timeTextView) {


        if (timeTextView.matches("([1-9]|1[0-9]|2[0-9]|3[0])")) {
            return true;
        } else {

            return false;
        }


    }
}
