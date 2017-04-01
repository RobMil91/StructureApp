package com.example.robin.structurestart.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.robin.structurestart.R;
import com.example.robin.structurestart.model.viewclasses.ViewLightUp;

public class RunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewLightUp viewLightUp = new ViewLightUp(this);
        setContentView(viewLightUp);

    }

}
