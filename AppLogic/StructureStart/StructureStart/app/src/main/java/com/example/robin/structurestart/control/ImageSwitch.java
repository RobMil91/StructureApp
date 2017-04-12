package com.example.robin.structurestart.control;

import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.util.Log;

import com.example.robin.structurestart.model.Algorithm;
import com.example.robin.structurestart.model.Model;
import com.example.robin.structurestart.view.RunActivity;
import com.example.robin.structurestart.view.StartActivity;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Class to switch the images
 */

public class ImageSwitch {

   private android.os.Handler handler;
    private Model model;
   private Algorithm alg;
 private RunActivity runImg;

    /**
     *
     * @param runImg
     * @param model
     * @param alg provides the times of the sequenzes
     */
    public ImageSwitch(RunActivity runImg, Model model, Algorithm alg) {
        this.runImg = runImg;
        this.model = model;
        this.alg = alg;

    }



    public void seqeunzstart() {

        //start the handler
        this.handler = new android.os.Handler();

     android.os.Handler handler = new android.os.Handler();


     int systemTime = 0;
        int index = 0;
        //size -1 is the last index, but while is set to not work on equals!
        int lastIndex = alg.getIntList().size();
        ArrayList<Integer> dirArray = alg.getIntList();

     do {

         //down sequenze cycle
         if (dirArray.get(index) == 0) {


             handler.postDelayed(triaDownLight, systemTime);
             systemTime = systemTime + alg.getLightUpTime();
             handler.postDelayed(triaDown, systemTime);



             //up sequenze cycle
         } else if (dirArray.get(index) == 1){

             handler.postDelayed(triaUpLight, systemTime);
             systemTime = systemTime + alg.getLightUpTime();
             handler.postDelayed(triaUp, systemTime);


         } else {
             //problem
         }



         systemTime = systemTime + alg.getTriaTime();
         handler.postDelayed(empty, systemTime);

         if (model.getSoundStatus() ) {

             handler.postDelayed(makePiep, systemTime);
             systemTime = systemTime + alg.getEmptytime();
         }

         //update the index
         index++;
     }while(index < lastIndex );

        handler.postDelayed(quit, systemTime);



    }



    final Runnable triaDownLight = new Runnable() {
        @Override
        public void run() {

            runImg.runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    runImg.setContentView(model.getTriangleLightDownView());
                }
            });

        }
    };
    final   Runnable triaDown = new Runnable() {
        @Override
        public void run() {

            runImg.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    runImg.setContentView(model.getTriangleDownView());


                }
            });
        }
    };


    final   Runnable triaUpLight = new Runnable() {
        @Override
        public void run() {

            runImg.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    runImg.setContentView(model.getTriangleLightUpView());


                }
            });
        }
    };



    final   Runnable triaUp = new Runnable() {
        @Override
        public void run() {

            runImg.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    runImg.setContentView(model.getTriangleUpView());


                }
            });
        }
    };

    final   Runnable empty = new Runnable() {
        @Override
        public void run() {

            runImg.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    runImg.setContentView(model.getImageEmptyView());


                }
            });
        }
    };

    final Runnable makePiep = new Runnable() {
        @Override
        public void run() {

            runImg.runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_ALARM, 10000);
                    toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,150);

                }
            });
        }
    };

    final Runnable quit = new Runnable() {
        @Override
        public void run() {

                   // switch back to main Activity!
        Intent intent = new Intent(runImg, StartActivity.class);
        runImg.startActivity(intent);




        }
    };


}
