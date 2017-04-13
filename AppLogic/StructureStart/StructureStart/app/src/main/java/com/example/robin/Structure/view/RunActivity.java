package com.example.robin.Structure.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import com.example.robin.Structure.control.ImageSwitch;
import com.example.robin.Structure.control.Manage;
import com.example.robin.Structure.model.Algorithm;
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


        //set the window size so you cant see title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        //keep the screen from going into sleep mode
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);



        //get the entire time from the start class
        Intent intent = getIntent();
        String entiretime = intent.getStringExtra(StartActivity.EXTRA_MESSAGE);

        //parse the time from StartActivity and calculate the micro seconds
       int entTime = Integer.parseInt(entiretime) * 60 * 1000;

        //put the entTime integer into the algorithm
        Algorithm alg = new Algorithm(entTime, 500, 7500, 4000, 0.5);


        manager = new Manage();
        manager.createStandartModel(this);



        //just test stub
        imageSwitch = new ImageSwitch(this, manager.getModel(), alg);
    //  final  ViewLightUp viewLightUp = new ViewLightUp(this);
     //   final TriangleUp viewTriangleUp = new TriangleUp(this);


        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



     //   setContentView(model.getImageEmptyView());
        //for testing of image not included
        imageSwitch.seqeunzstart();


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Log.e(LOG_TAG,"I pressed the back Button");
            //quick effective bad fix apparently
            System.exit(1);
            imageSwitch.runningState = false;
        }
        return super.onKeyDown(keyCode, event);
    }



}
