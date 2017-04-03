package com.example.robin.structurestart.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.robin.structurestart.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




//set the basic visual gui for start
        setContentView(R.layout.activity_main);
        //create intent for the RunActivity
     //   Intent intent = new Intent(this, RunActivity.class);

        //start the run activity
    //    startActivity(intent);

    }


    public void hitButton(View v) {

        Intent intent = new Intent(this, RunActivity.class);
        Button buttonInLayout = (Button)(findViewById(R.id.button));


/*get entire duration 1
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        */

        /*
//get rate of the first text edit and put at extra Rate
        EditText editTextRate = (EditText) findViewById(R.id.editText2);
        String message2 = editTextRate.getText().toString();
        intent.putExtra(EXTRA_RATE, message2);
*/


        startActivity(intent);

    }
}
