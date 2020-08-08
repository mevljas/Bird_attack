package com.example.birdattack;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.example.birdattack.GameView.screenRatioX;
import static com.example.birdattack.GameView.screenRatioY;

public class Flight {

    int x, y, width, height, wingCounter;
    Bitmap flight1, flight2;

    Flight(int screenY, Resources res) {

        flight1 = BitmapFactory.decodeResource(res, R.drawable.fly1);
        flight2 = BitmapFactory.decodeResource(res, R.drawable.fly2);

        width = flight1.getWidth();
        height = flight1.getHeight();

        width /= 4;
        height /= 4;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;


        flight1 = Bitmap.createScaledBitmap(flight1, width, height, false);
        flight2 = Bitmap.createScaledBitmap(flight2, width, height, false);

        y = screenY / 2;
        x = (int) (64 * screenRatioX);

    }


    Bitmap getFlight() {
        if (wingCounter == 0) {
            wingCounter++;
            return flight1;

        }

        wingCounter--;

        return flight2;
    }
}
