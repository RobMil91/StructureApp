package com.example.robin.structurestart.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.robin.structurestart.R;
import com.example.robin.structurestart.control.ImageSwitch;
import com.example.robin.structurestart.model.Model;
import com.example.robin.structurestart.model.viewclasses.TriangleDown;
import com.example.robin.structurestart.model.viewclasses.ViewLightDown;
import com.example.robin.structurestart.model.viewclasses.ViewLightUp;

import java.util.TimerTask;
import java.util.logging.Handler;

public class RunActivity extends AppCompatActivity {


    //class which is responsible for the switiching
    ImageSwitch imageSwitch;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //just test stub
        imageSwitch = new ImageSwitch(this,model, 100, 100 , 100, true, 100);
      final  ViewLightUp viewLightUp = new ViewLightUp(this);

        setContentView(viewLightUp);
       // sequenzeStart();
        imageSwitch.seqeunzstart();

    }


/*
    private void sequenzeStart() {


      final  ViewLightUp viewLightUp = new ViewLightUp(this);
       final ViewLightDown viewLightDown = new ViewLightDown(this);
        final TriangleDown viewtriangleDown = new TriangleDown(this);


        final Runnable triaLightDown = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        setContentView(viewLightDown);
                    }
                });

            }
        };



        final   Runnable triaLightUp = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        setContentView(viewLightUp);


                    }
                });
            }
        };

        final   Runnable triangleDown = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        setContentView(viewtriangleDown);


                    }
                });
            }
        };

        android.os.Handler hans = new android.os.Handler();

        int systemTime = 0;


        int time = 0;
        do {


            hans.postDelayed(triangleDown, 5000);
            systemTime= systemTime + 5000;

        }while(systemTime < 5000);

        }
*/
}
