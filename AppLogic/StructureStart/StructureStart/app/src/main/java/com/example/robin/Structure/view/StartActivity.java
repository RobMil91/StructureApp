package com.example.robin.Structure.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.robin.Structure.R;
import com.example.robin.Structure.control.InputControl;
import com.example.robin.Structure.control.Manage;

import static com.example.robin.Structure.view.OptionsAcitvity.EXTRA_RATIO;

public class StartActivity extends AppCompatActivity{


    //public identifier to get the Message
    public final static String EXTRA_MESSAGE = "com.example.prototype1.0.MESSAGE";

    private int entiretime;

    //Observer
    private Manage manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
    }


    public void hitButton(View v) {

        Intent intent = new Intent(this, RunActivity.class);
        Button buttonInLayout = (Button)(findViewById(R.id.buttonStart));



        EditText editText = (EditText) findViewById(R.id.timeText);
        //has to be checked here for input mistakes!!!!!!!!!!!!!!!!!!!!--------!
        InputControl inputControl = new InputControl();

        String timeText = editText.getText().toString();

        if(inputControl.time(timeText)) {
            intent.putExtra(EXTRA_MESSAGE, timeText);

            Intent intOpt = getIntent();

            Double ratio = intOpt.getDoubleExtra(OptionsAcitvity.EXTRA_RATIO, 0.5);
            Boolean soundOn = intOpt.getBooleanExtra(OptionsAcitvity.EXTRA_SoundON, true);
            Boolean horizontal = intOpt.getBooleanExtra(OptionsAcitvity.EXTRA_Orientation, true);
          //  intent.putExtra(intOpt);
/*
            this.intent.putExtra(EXTRA_RATIO, this.ratio);
            this.intent.putExtra(EXTRA_SoundON, this.soundOn);
            this.intent.putExtra(EXTRA_Orientation, this.horizontal);
  */
            startActivity(intent);
        }





    }

    public void hitOption(View v) {
        Intent intent = new Intent(this, OptionsAcitvity.class);
        Button buttonInLayout = (Button)(findViewById(R.id.buttonOptions));
        startActivity(intent);


    }







}
