package com.example.robin.Structure.view;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.robin.Structure.R;
import com.example.robin.Structure.control.Manage;

import static com.example.robin.Structure.view.RunActivity.LOG_TAG;

/**
 * Subject of the Manage Class
 */
public class OptionsAcitvity extends AppCompatActivity {

    //subject attributes to be observed
    private double ratio;


    //todo
  //  private boolean nightMode;
  //  private int soundVolume;


    public final static String EXTRA_RATIO = "modelRatio";
    public final static String EXTRA_SoundON = "soundOn";
    public final static String EXTRA_Orientation = "orientation";

    private Spinner dropdown;
    private CheckBox checkBoxsound;
    private CheckBox checkBoxHorizontal;

    private boolean checksound;
    private boolean checkHorizontal;


    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_acitvity);
        startSpinner();

        this.checkBoxHorizontal = (CheckBox) findViewById(R.id.checkBoxHor);
        this.checkBoxsound = (CheckBox) findViewById(R.id.checkBoxSound);

        //check if sendable to the run activity
        this.intent = new Intent(this, StartActivity.class);




    }



    @Override
    public void onBackPressed() {

        String strRatio = this.dropdown.getSelectedItem().toString();
     //   Log.e(LOG_TAG,"current ratio: " + strRatio);
        this.ratio = convertSelectionSpinner(strRatio);
     //   Log.e(LOG_TAG,"current ratio: " + ratio);

        this.checksound = this.checkBoxsound.isChecked();
        this.checkHorizontal = this.checkBoxHorizontal.isChecked();

      //  Log.e(LOG_TAG,"current ratio: " + ratio);
        this.intent.putExtra(EXTRA_RATIO, this.ratio);
        this.intent.putExtra(EXTRA_SoundON, this.checksound);
        this.intent.putExtra(EXTRA_Orientation, this.checkHorizontal);

        startActivity(intent);
    }



    private void startSpinner() {

        this.dropdown = (Spinner)findViewById(R.id.spinner);
        dropdown.setSelection(0);
        String[] items = new String[]{"50:50", "80:20", "20:80"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }


    /**
     * gives back the double value which
     * stands for the ammount of triangles up
     * @param selecString
     * @return
     */
    private Double convertSelectionSpinner(String selecString) {


        switch (selecString) {

            case "50:50": return 0.5;

            case "80:20": return 0.8;

            case "20:80": return 0.2;
        }


        throw new IllegalArgumentException();

    }
}
