package com.example.robin.structurestart.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.robin.structurestart.R;
import com.example.robin.structurestart.control.Manage;

/**
 * Subject of the Manage class
 */
public class MainActivity extends AppCompatActivity {


    private int entiretime;

    //Observer
    private Manage manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

    }


    public void hitButton(View v) {

        Intent intent = new Intent(this, RunActivity.class);
        Button buttonInLayout = (Button)(findViewById(R.id.buttonStart));



        EditText editText = (EditText) findViewById(R.id.timeText);
        String message = editText.getText().toString();

        //has to be checked here for input mistakes!!!!!!!!!!!!!!!!!!!!--------
        entiretime = Integer.parseInt(message);
        //notify the manager to start??
        //better when editText is manipulated to change !!!!!!!!!!!!!!!-------
        notifyManager();



  //      intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);

    }

    public void hitOption(View v) {
        Intent intent = new Intent(this, OptionsAcitvity.class);
        Button buttonInLayout = (Button)(findViewById(R.id.buttonOptions));
        startActivity(intent);


    }



    public int getEntiretime() {
        return entiretime;
    }

    /**
     * Only register the one intended Observer for this class
     * @param manager
     */
    public void registerObserver(Manage manager) {

        this.manager = manager;

    }

    /**
     * Notify Method
     */
    public void notifyManager() {


        manager.update(entiretime);
    }

}
