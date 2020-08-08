package com.example.birdattack;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.example.birdattack.GameView.screenRatioX;
import static com.example.birdattack.GameView.screenRatioY;

public class Flight {

    int x, y, width, height;
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

    }
}
