package com.example.robin.Structure.control;

import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

import com.example.robin.Structure.model.Algorithm;
import com.example.robin.Structure.model.Model;
import com.example.robin.Structure.view.RunActivity;
import com.example.robin.Structure.view.StartActivity;

import java.util.ArrayList;

/**
 * Class to switch the images it uses handler
 * and is intended to be started from the runActivity
 * it uses Runnable tasks to change the content view of
 * the runactivity
 */
public class ImageSwitch {

    private android.os.Handler handler;
    private Model model;
    private Algorithm alg;
    private RunActivity runImg;

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
    final Runnable triaDown = new Runnable() {
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
    final Runnable triaUpLight = new Runnable() {
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
    final Runnable triaUp = new Runnable() {
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
    final Runnable empty = new Runnable() {
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

                    //the model SoundVolume is the frequenzy.... physically a disaster...
                    AudioTrack tone = generateTone(model.getSoundVolume(), 100);
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
     * Constructor
     *
     * @param runImg instance of the runActivity
     * @param model  instance of the desired model
     * @param alg    provides the times of the sequenzes
     */
    public ImageSwitch(RunActivity runImg, Model model, Algorithm alg) {
        this.runImg = runImg;
        this.model = model;
        this.alg = alg;

    }

    /**
     * Seqeunzstart Method, in this method the handler will use a do while
     * loop to display what the model and the algorithm describe
     */
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
            } else if (dirArray.get(index) == 1) {

                handler.postDelayed(triaUpLight, systemTime);
                systemTime = systemTime + alg.getLightUpTime();
                handler.postDelayed(triaUp, systemTime);


            } else {
                //problem
            }

            systemTime = systemTime + alg.getTriaTime();
            handler.postDelayed(empty, systemTime);

            if (model.getSoundStatus()) {

                handler.postDelayed(makePiep, systemTime);

            }
            systemTime = systemTime + alg.getEmptytime();

            //update the index
            index++;

        } while (index < lastIndex);

        handler.postDelayed(quit, systemTime);


    }

    /**
     * Specified tone method which uses basic algorithm to create sound
     *
     * @param freqHz     double value for the frequenzy of the tone
     * @param durationMs int value for the duration
     * @return AudioTrack object which can play tone
     */
    private AudioTrack generateTone(double freqHz, int durationMs) {
        int count = (int) (44100.0 * 2.0 * (durationMs / 1000.0)) & ~1;
        short[] samples = new short[count];
        for (int i = 0; i < count; i += 2) {
            short sample = (short) (Math.sin(2 * Math.PI * i / (44100.0 / freqHz)) * 0x7FFF);
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
