package com.example.robin.viewclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.robin.viewclass.views.*;

/**
 * basic class to call the new view
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewLightUp viewLightUp = new ViewLightUp(this);

        //set my created view in the App!
        setContentView(viewLightUp);

        //not needed i set my own view here!
       // setContentView(R.layout.activity_main);
    }
}
