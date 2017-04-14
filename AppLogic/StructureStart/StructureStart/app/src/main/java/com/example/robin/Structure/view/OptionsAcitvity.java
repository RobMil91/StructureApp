package com.example.robin.Structure.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import com.example.robin.Structure.R;

/**
 * Class to change the values of the RunActivty
 */
public class OptionsAcitvity extends AppCompatActivity {


    //features intentend later
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
    private double ratio;

    private Intent intent;


    /**
     * Called when class is started
     *
     * @param savedInstanceState instance of last call of the class
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_acitvity);

        //iniate the layout values
        startSpinner();
        this.checkBoxHorizontal = (CheckBox) findViewById(R.id.checkBoxHor);
        this.checkBoxsound = (CheckBox) findViewById(R.id.checkBoxSound);

        //Intent to get back to Start Activty
        this.intent = new Intent(this, StartActivity.class);

    }


    /**
     * Create DTO to send back to the Start Activty
     * the DTO should hold the current values of this Activty
     */
    @Override
    public void onBackPressed() {

        String strRatio = this.dropdown.getSelectedItem().toString();

        this.ratio = convertSelectionSpinner(strRatio);

        this.checksound = this.checkBoxsound.isChecked();
        this.checkHorizontal = this.checkBoxHorizontal.isChecked();
        this.intent.putExtra(EXTRA_RATIO, this.ratio);
        this.intent.putExtra(EXTRA_SoundON, this.checksound);
        this.intent.putExtra(EXTRA_Orientation, this.checkHorizontal);

        startActivity(intent);
        finish();
    }


    /**
     * Start the spinner for the ratio's
     */
    private void startSpinner() {

        this.dropdown = (Spinner) findViewById(R.id.spinner);
        dropdown.setSelection(0);
        String[] items = new String[]{"50:50", "80:20", "20:80"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }


    /**
     * Gives back the double value which
     * stands for the ammount of triangles up
     *
     * @param selecString the string to be parsed
     * @return double value from [0-1] or specified in Spinner
     */
    private Double convertSelectionSpinner(String selecString) {


        switch (selecString) {

            case "50:50":
                return 0.5;

            case "80:20":
                return 0.8;

            case "20:80":
                return 0.2;
        }

        throw new IllegalArgumentException();
    }
}
