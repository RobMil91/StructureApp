package com.example.robin.structurestart.view;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.robin.structurestart.control.ImageSwitch;
import com.example.robin.structurestart.model.Model;
import com.example.robin.structurestart.model.viewclasses.TriangleDown;
import com.example.robin.structurestart.model.viewclasses.TriangleUp;
import com.example.robin.structurestart.model.viewclasses.ViewEmpty;

public class RunActivity extends AppCompatActivity {


    //class which is responsible for the switiching
    ImageSwitch imageSwitch;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //just test stub
        imageSwitch = new ImageSwitch(this,model, 100, 100 , 100, true, 100);
    //  final  ViewLightUp viewLightUp = new ViewLightUp(this);
     //   final TriangleUp viewTriangleUp = new TriangleUp(this);


        Paint paintBackground = new Paint();
        paintBackground.setColor(Color.WHITE);
        Paint paintFill = new Paint();
        paintFill.setColor(Color.BLUE);
        Paint paintFrame = new Paint();
        paintFrame.setColor(Color.BLACK);


        //testing instance
      //  final TriangleDown viewTriangleDown = new TriangleDown(this, paintBackground, paintFrame,paintFill, false);
        final TriangleUp viewTriangleUp = new TriangleUp(this, paintBackground, paintFrame,paintFill, false);

        final ViewEmpty viewEmpty = new ViewEmpty(this);

        setContentView(viewTriangleUp);
       // sequenzeStart();
        //for testing of image not included
       // imageSwitch.seqeunzstart();

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
