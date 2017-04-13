package com.example.robin.Structure.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import com.example.robin.Structure.control.ImageSwitch;
import com.example.robin.Structure.control.Manage;
import com.example.robin.Structure.model.Model;

public class RunActivity extends AppCompatActivity {

    public static final String LOG_TAG = "myLogs";

    //class which is responsible for the switiching
    ImageSwitch imageSwitch;
    Model model;
    private Manage manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


      super.onCreate(savedInstanceState);


        boolean horizontal = true;
        if (horizontal) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        //set the window size so you cant see title bar for options and so on..
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        //keep the screen from going into sleep mode
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);



        //get the entire time from the start class
        Intent intent = getIntent();
        String entiretime = intent.getStringExtra(StartActivity.EXTRA_TIME);


        int minTime = Integer.parseInt(entiretime);

        manager = new Manage();
        manager.createStandartModel(this, true);
        manager.createStandartAlg(minTime, 0.5);


        //use manage class model and algorithm to create the imageSwitch
        imageSwitch = new ImageSwitch(this, manager.getModel(), manager.getAlg());
    //  final  ViewLightUp viewLightUp = new ViewLightUp(this);
     //   final TriangleUp viewTriangleUp = new TriangleUp(this);







     //   setContentView(model.getImageEmptyView());
        //for testing of image not included
        imageSwitch.seqeunzstart();


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
         //   Log.e(LOG_TAG,"I pressed the back Button");
            //quick effective bad fix apparently
            System.exit(1);
            imageSwitch.runningState = false;
        }
        return super.onKeyDown(keyCode, event);
    }



}
