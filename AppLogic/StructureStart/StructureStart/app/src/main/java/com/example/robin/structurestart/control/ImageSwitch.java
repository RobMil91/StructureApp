package com.example.robin.structurestart.control;

import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.ToneGenerator;
import android.net.Uri;
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
    public static boolean runningState;

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
        this.runningState = true;

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

         if (model.getSoundStatus() && runningState) {

             handler.postDelayed(makePiep, systemTime);
             systemTime = systemTime + alg.getEmptytime();
         }



         //update the index
         index++;
     }while(index < lastIndex && runningState);

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

                // tonegenerator use
                 //   ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
                  //  toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,150);
                  AudioTrack tone = generateTone(1000, 150);
                tone.play();

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

    /**
     * Use boolean to halt the while loop?
     */
    public void seqeunzeStop() {



        runImg.runOnUiThread(quit);
      //  System.exit(1);
    }


    /**
     * for specified tone
     * @param freqHz
     * @param durationMs
     * @return
     */
    private AudioTrack generateTone(double freqHz, int durationMs)
    {
        int count = (int)(44100.0 * 2.0 * (durationMs / 1000.0)) & ~1;
        short[] samples = new short[count];
        for(int i = 0; i < count; i += 2){
            short sample = (short)(Math.sin(2 * Math.PI * i / (44100.0 / freqHz)) * 0x7FFF);
            samples[i + 0] = sample;
            samples[i + 1] = sample;
        }
        AudioTrack track = new AudioTrack(AudioManager.STREAM_MUSIC, 44100,
                AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT,
                count * (Short.SIZE / 8), AudioTrack.MODE_STATIC);
        track.write(samples, 0, count);
        return track;
    }

}
