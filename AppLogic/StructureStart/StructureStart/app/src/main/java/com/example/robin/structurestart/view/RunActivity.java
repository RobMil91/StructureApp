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





        Model model = new Model(this, paintBackground, paintFrame, paintFillUp, paintFillDown, lightSeq, lightSeq);

        setContentView(model.getTriangleLightDownView());
        //for testing of image not included
       // imageSwitch.seqeunzstart();

    }

}
