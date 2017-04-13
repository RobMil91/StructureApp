package com.example.robin.Structure.view;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.robin.Structure.R;
import com.example.robin.Structure.control.Manage;

/**
 * Subject of the Manage Class
 */
public class OptionsAcitvity extends AppCompatActivity {

    /*subject attributes to be observed
    private double ratio;
    private boolean soundOn;
    private boolean horizontal;
    private boolean nightMode;

    */

    private Spinner dropdown;

    public OptionsAcitvity(Manage manager) {


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_acitvity);

        this.dropdown = (Spinner)findViewById(R.id.spinner);
        dropdown.setSelection(0);
        String[] items = new String[]{"50:50", "80:20", "20:80"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


    }



    @Override
    public void onBackPressed() {


    }
}
