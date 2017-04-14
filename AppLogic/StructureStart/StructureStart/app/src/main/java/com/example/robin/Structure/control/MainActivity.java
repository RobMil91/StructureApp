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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = new Intent(this, StartActivity.class);

        startActivity(intent);
        finish();

    }


    @Override
    public void onBackPressed() {

        finish();
    }


}
