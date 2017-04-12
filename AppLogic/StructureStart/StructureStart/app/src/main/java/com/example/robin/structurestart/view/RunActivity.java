package com.example.robin.structurestart.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.robin.structurestart.control.ImageSwitch;
import com.example.robin.structurestart.control.MainActivity;
import com.example.robin.structurestart.model.Algorithm;
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

        Paint paintBackground = new Paint();
        paintBackground.setColor(Color.BLUE);

        //triangle Color
        Paint paintFillUp = new Paint();
        paintFillUp.setColor(Color.BLUE);

        Paint paintFillDown = new Paint();
        paintFillDown.setColor(Color.RED);

        Paint lightSeq = new Paint();
        lightSeq.setColor(Color.YELLOW);


        Paint paintFrame = new Paint();
        paintFrame.setColor(Color.BLACK);


        //get the entire time from the start class
        Intent intent = getIntent();
        String entiretime = intent.getStringExtra(StartActivity.EXTRA_MESSAGE);

        //parse the time from StartActivity and calculate the micro seconds
       int entTime = Integer.parseInt(entiretime) * 60 * 1000;

        //put the entTime integer into the algorithm
        Algorithm alg = new Algorithm(entTime, 500, 7500, 4000, 0.5);


        Model model = new Model(this, paintBackground, paintFrame, paintFillUp, paintFillDown, lightSeq, lightSeq, true);

        //just test stub
        imageSwitch = new ImageSwitch(this, model, alg);
    //  final  ViewLightUp viewLightUp = new ViewLightUp(this);
     //   final TriangleUp viewTriangleUp = new TriangleUp(this);





       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        setContentView(model.getImageEmptyView());
        //for testing of image not included
        imageSwitch.seqeunzstart();


        /* switch back to main Activity!
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
*/
    }

}
