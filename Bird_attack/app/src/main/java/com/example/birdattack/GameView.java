package com.example.birdattack;

import android.content.Context;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;

    public GameView(Context context) {
        super(context);
    }

    private boolean isPlaying;

    @Override
    public void run () {


        while (isPlaying){

            update ();
            draw ();
            sleep ();
        }

    }

    private void update (){

    }

    private void draw () {

    }

    private void sleep () {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void resume (){

        isPlaying = true;
        thread = new Thread(this);
        thread.start(); //Calls the run function
    }


    public void pause () {
        // Stops the thread
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
