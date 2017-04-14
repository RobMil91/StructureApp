package com.example.robin.Structure.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.robin.Structure.control.ImageSwitch;
import com.example.robin.Structure.control.Manage;

import static com.example.robin.Structure.view.OptionsAcitvity.EXTRA_Orientation;
import static com.example.robin.Structure.view.OptionsAcitvity.EXTRA_RATIO;
import static com.example.robin.Structure.view.OptionsAcitvity.EXTRA_SoundON;

/**
 * Activity to display the sequence of triangles
 */
public class RunActivity extends AppCompatActivity {


    private ImageSwitch imageSwitch;
    private Manage manager;
    private Intent optionsDTO;

    /**
     * Method to start the Sequence imediatly when the Activity
     * is called
     *
     * @param savedInstanceState last state of the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adjustScreen();
        //get the DTO from startActivity
        this.optionsDTO = getIntent();

        setOrientation();

        createManager();

        imageSwitch = new ImageSwitch(this, manager.getModel(), manager.getAlg());
        imageSwitch.seqeunzstart();

    }


    /**
     * Method remove taskbar and prevent sleep mode from phone
     */
    private void adjustScreen() {
        //set the window size so you cant see title bar for options and so on..
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //keep the screen from going into sleep mode
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    /**
     * set the orientation of the class according to Intent
     */
    private void setOrientation() {


        boolean horizontal = optionsDTO.getBooleanExtra(EXTRA_Orientation, true);
        if (horizontal) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }

    /**
     * Create the manager from Intent values
     */
    private void createManager() {
        String entiretime = optionsDTO.getStringExtra(StartActivity.EXTRA_TIME);

        boolean soundOn = optionsDTO.getBooleanExtra(EXTRA_SoundON, true);


        manager = new Manage();
        manager.createStandartModel(this, soundOn);

        //get the values from DTO of Options
        int minuteTime = Integer.parseInt(entiretime);
        double ratio = optionsDTO.getDoubleExtra(EXTRA_RATIO, 0.5);
        manager.createStandartAlg(minuteTime, ratio);
    }


    /**
     * End the Runactivity when back is pressed
     */
    @Override
    public void onBackPressed() {
        finish();
        System.exit(1);
    }

}
