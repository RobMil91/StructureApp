package com.example.robin.structurestart.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.robin.structurestart.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create intent for the RunActivity
        Intent intent = new Intent(this, RunActivity.class);

        //start the run activity
        startActivity(intent);

    }
}
