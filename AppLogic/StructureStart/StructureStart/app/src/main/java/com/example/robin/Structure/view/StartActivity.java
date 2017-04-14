package com.example.robin.Structure.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.robin.Structure.R;
import com.example.robin.Structure.control.InputControl;

import static com.example.robin.Structure.view.OptionsAcitvity.EXTRA_Orientation;
import static com.example.robin.Structure.view.OptionsAcitvity.EXTRA_RATIO;
import static com.example.robin.Structure.view.OptionsAcitvity.EXTRA_SoundON;

//needed to listen to Otpions Acitvty

/**
 * Class to display the start screen of the application
 */
public class StartActivity extends AppCompatActivity {

    //public identifier to get the Message
    public final static String EXTRA_TIME = "time";
    private Intent intent;


    /**
     * Method to set the layout
     *
     * @param savedInstanceState of last state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
    }

    /**
     * Method to start runactivty when the startbutton is pushed
     * * @param v standart parameter
     */
    public void startButton(View v) {

        this.intent = new Intent(this, RunActivity.class);

        //get text from the layout textview as String
        EditText editText = (EditText) findViewById(R.id.timeText);
        String timeText = editText.getText().toString();


        InputControl inputControl = new InputControl();
        if (inputControl.seqtimeCheck(timeText)) {

            intent.putExtra(EXTRA_TIME, timeText);
            //put all the intent extras from optionsActivty into intent for runActivity
            collectDTO();
            startActivity(intent);
        }


    }

    /**
     * Method to start optionactivty when pushed
     *
     * @param v standart parameter
     */
    public void hitOption(View v) {
        Intent intent = new Intent(this, OptionsAcitvity.class);
        startActivity(intent);


    }

    /**
     * Method to collect the DTO input for the RunActivty from the Options
     * Activty intent
     */
    private void collectDTO() {

        Intent intOpt = getIntent();

        Double ratio = intOpt.getDoubleExtra(OptionsAcitvity.EXTRA_RATIO, 0.5);
        Boolean soundOn = intOpt.getBooleanExtra(EXTRA_SoundON, true);
        Boolean horizontal = intOpt.getBooleanExtra(EXTRA_Orientation, true);


        intent.putExtra(EXTRA_RATIO, ratio);
        intent.putExtra(EXTRA_SoundON, soundOn);
        intent.putExtra(EXTRA_Orientation, horizontal);
    }


    /**
     * Method to prevent the App from creating history and switching back to options
     */
    @Override
    public void onBackPressed() {

        finish();
        System.exit(1);
    }

}
