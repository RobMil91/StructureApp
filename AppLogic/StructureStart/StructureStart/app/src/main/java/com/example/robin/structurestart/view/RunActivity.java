package com.example.robin.structurestart.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.robin.structurestart.R;
import com.example.robin.structurestart.model.viewclasses.ViewLightDown;
import com.example.robin.structurestart.model.viewclasses.ViewLightUp;

import java.util.TimerTask;
import java.util.logging.Handler;

public class RunActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


      final  ViewLightUp viewLightUp = new ViewLightUp(this);

        setContentView(viewLightUp);
        sequenzeStart();

    }



    private void sequenzeStart() {


      final  ViewLightUp viewLightUp = new ViewLightUp(this);
       final ViewLightDown viewLightDown = new ViewLightDown(this);


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

        android.os.Handler hans = new android.os.Handler();

        int systemTime = 0;


        int time = 0;
        do {


            hans.postDelayed(triaLightDown, 5000);
            systemTime= systemTime + 5000;

        }while(systemTime < 5000);

        }

}
