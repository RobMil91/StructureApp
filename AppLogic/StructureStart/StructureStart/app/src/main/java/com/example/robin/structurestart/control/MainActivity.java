package com.example.robin.structurestart.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.robin.structurestart.R;
import com.example.robin.structurestart.control.Manage;
import com.example.robin.structurestart.view.OptionsAcitvity;
import com.example.robin.structurestart.view.RunActivity;
import com.example.robin.structurestart.view.StartActivity;

/**
 * Subject of the Manage class
 */
public class MainActivity extends AppCompatActivity {


    StartActivity startActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        StartActivity startActivity = new StartActivity();
        //all activities are Intends!
        OptionsAcitvity optAct = new OptionsAcitvity();
     //   Manage manager = new Manage(startActivity, optAct);



        Intent intent = new Intent(this, StartActivity.class);

        startActivity(intent);
        finish();

    }



}
