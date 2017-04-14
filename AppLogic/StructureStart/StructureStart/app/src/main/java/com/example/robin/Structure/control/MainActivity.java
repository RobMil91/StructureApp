package com.example.robin.Structure.control;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.robin.Structure.view.StartActivity;

/**
 * Main Activty which will start the start class
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = new Intent(this, StartActivity.class);

        startActivity(intent);
        finish();

    }


    /**
     * Method to close application on backs
     */
    @Override
    public void onBackPressed() {

        finish();
    }


}
