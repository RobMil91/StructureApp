package com.example.robin.structurestart.control;

import com.example.robin.structurestart.model.Model;
import com.example.robin.structurestart.view.RunActivity;

/**
 * Class to switch the images
 */

public class ImageSwitch{

   private android.os.Handler handler;
 //Use to get the images!
    private Model model;
    private int entiretime;
    private int lightUpTime;
    private int pausetime;
    private boolean sound;
    private int soundKind;
 private RunActivity runImg;

    /**
     * @param model give the switcher the model for the images
     * @param entiretime runtime of the image sequenze
     * @param lightUpTime time how long the lightupTriangle should be shown
     * @param pausetime time between the the triangles
     * @param sound if sound should be integrated boolean
     * @param soundKind decide which kind of sound should be played
     */
    public ImageSwitch(RunActivity runImg, Model model, int entiretime, int lightUpTime, int pausetime, boolean sound, int soundKind) {
this.runImg = runImg;


    }



    public void seqeunzstart() {

        //start the handler
        this.handler = new android.os.Handler();

   //  final ViewLightUp viewLightUp = new ViewLightUp(runImg);
   //  final ViewLightDown viewLightDown = new ViewLightDown(runImg);
        //just for testing!
    // final TriangleDown viewtriangleDown = new TriangleDown(runImg);


     final Runnable triaLightDown = new Runnable() {
      @Override
      public void run() {

       runImg.runOnUiThread(new Runnable() {
        @Override
        public void run() {


     //    runImg.setContentView(viewLightDown);
        }
       });

      }
     };



     final   Runnable triaLightUp = new Runnable() {
      @Override
      public void run() {

       runImg.runOnUiThread(new Runnable() {
        @Override
        public void run() {

    //     runImg.setContentView(viewLightUp);


        }
       });
      }
     };

     final   Runnable triangleDown = new Runnable() {
      @Override
      public void run() {

       runImg.runOnUiThread(new Runnable() {
        @Override
        public void run() {
//just for testing
       //  runImg.setContentView(viewtriangleDown);


        }
       });
      }
     };

        final   Runnable triangleUp = new Runnable() {
            @Override
            public void run() {

                runImg.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    //    runImg.setContentView(TriangleUp);


                    }
                });
            }
        };

     android.os.Handler hans = new android.os.Handler();

     int systemTime = 0;


     int time = 0;
     do {


      hans.postDelayed(triangleDown, 5000);
      systemTime= systemTime + 5000;

     }while(systemTime < 5000);




    }
}
