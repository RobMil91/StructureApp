package com.example.robin.structurestart.view;

import android.content.Intent;
import android.database.ContentObservable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.robin.structurestart.R;
import com.example.robin.structurestart.control.Manage;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

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
        String entiretime = editText.getText().toString();
              intent.putExtra(EXTRA_MESSAGE, entiretime);



        //notify the manager to start??
        //better when editText is manipulated to change !!!!!!!!!!!!!!!-------
        //  notifyManager();




        startActivity(intent);

    }

    public void hitOption(View v) {
        Intent intent = new Intent(this, OptionsAcitvity.class);
        Button buttonInLayout = (Button)(findViewById(R.id.buttonOptions));
        startActivity(intent);


    }







}
