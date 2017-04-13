package com.example.robin.Structure.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.robin.Structure.view.OptionsAcitvity;
import com.example.robin.Structure.view.StartActivity;

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

      //  Manage manager = new Manage();
       // OptionsAcitvity optAct = new OptionsAcitvity(manager);



        Intent intent = new Intent(this, StartActivity.class);

        startActivity(intent);
        finish();

    }



}
