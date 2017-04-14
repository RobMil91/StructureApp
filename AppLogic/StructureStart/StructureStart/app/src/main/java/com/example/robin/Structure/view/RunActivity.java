package com.example.robin.Structure.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import com.example.robin.Structure.control.ImageSwitch;
import com.example.robin.Structure.control.Manage;
import com.example.robin.Structure.model.Model;

import static com.example.robin.Structure.view.OptionsAcitvity.EXTRA_Orientation;
import static com.example.robin.Structure.view.OptionsAcitvity.EXTRA_RATIO;
import static com.example.robin.Structure.view.OptionsAcitvity.EXTRA_SoundON;

public class RunActivity extends AppCompatActivity {

    public static final String LOG_TAG = "myLogs";

    //class which is responsible for the switiching
    ImageSwitch imageSwitch;
    Model model;
    private Manage manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


      super.onCreate(savedInstanceState);


        adjustScreen();

        //get the DTO from startActivity
        Intent optionsDTO = getIntent();

        //get the boolean from the optionsclass
        boolean horizontal = optionsDTO.getBooleanExtra(EXTRA_Orientation, true);

        if (horizontal) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        }

        String entiretime = optionsDTO.getStringExtra(StartActivity.EXTRA_TIME);

        boolean soundOn = optionsDTO.getBooleanExtra(EXTRA_SoundON, true);


        manager = new Manage();
        manager.createStandartModel(this, soundOn);

        //get the values from DTO of Options
        int minuteTime = Integer.parseInt(entiretime);
        double ratio = optionsDTO.getDoubleExtra(EXTRA_RATIO, 0.5);
        manager.createStandartAlg(minuteTime, ratio);


        //use manage class model and algorithm to create the imageSwitch
        imageSwitch = new ImageSwitch(this, manager.getModel(), manager.getAlg());



            imageSwitch.seqeunzstart();



    }

    /*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }
*/

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
         //   Log.e(LOG_TAG,"I pressed the back Button");
            //quick effective bad fix apparently
            System.exit(1);
      //      imageSwitch.runningState = false;
        }
        return super.onKeyDown(keyCode, event);
    }


    private void adjustScreen() {
        //set the window size so you cant see title bar for options and so on..
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //keep the screen from going into sleep mode
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);




    }

}
