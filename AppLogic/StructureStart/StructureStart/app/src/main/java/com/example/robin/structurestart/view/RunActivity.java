package com.example.robin.structurestart.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.example.robin.structurestart.control.ImageSwitch;
import com.example.robin.structurestart.control.MainActivity;
import com.example.robin.structurestart.control.Manage;
import com.example.robin.structurestart.model.Algorithm;
import com.example.robin.structurestart.model.Model;
import com.example.robin.structurestart.model.viewclasses.TriangleDown;
import com.example.robin.structurestart.model.viewclasses.TriangleUp;
import com.example.robin.structurestart.model.viewclasses.ViewEmpty;

public class RunActivity extends AppCompatActivity {

    public static final String LOG_TAG = "myLogs";

    //class which is responsible for the switiching
    ImageSwitch imageSwitch;
    Model model;
    private Manage manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


      super.onCreate(savedInstanceState);


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
