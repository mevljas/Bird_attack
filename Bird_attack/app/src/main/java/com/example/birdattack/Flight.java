package com.example.birdattack;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.birdattack.GameView.screenRatioX;
import static com.example.birdattack.GameView.screenRatioY;

public class Flight {

    public boolean isGoingUp = false;
    public int toShoot = 0;
    int x, y, width, height, wingCounter = 0, shootCounter = 0;
    Bitmap flight1, flight2, shoot1, shoot2, shoot3, shoot4, shoot5, dead;
    private GameView gameView;

    Flight(GameView gameView, int screenY, Resources res) {

        this.gameView = gameView;

        flight1 = BitmapFactory.decodeResource(res, R.drawable.fly1);
        flight2 = BitmapFactory.decodeResource(res, R.drawable.fly2);

        width = flight1.getWidth();
        height = flight1.getHeight();

        width /= 4;
        height /= 4;

        width *= screenRatioX;
        height *= screenRatioY;


        flight1 = Bitmap.createScaledBitmap(flight1, width, height, false);
        flight2 = Bitmap.createScaledBitmap(flight2, width, height, false);

        shoot1 = BitmapFactory.decodeResource(res, R.drawable.shoot1);
        shoot2 = BitmapFactory.decodeResource(res, R.drawable.shoot2);
        shoot3 = BitmapFactory.decodeResource(res, R.drawable.shoot3);
        shoot4 = BitmapFactory.decodeResource(res, R.drawable.shoot4);
        shoot5 = BitmapFactory.decodeResource(res, R.drawable.shoot5);

        shoot1 = Bitmap.createScaledBitmap(shoot1, width, height, false);
        shoot2 = Bitmap.createScaledBitmap(shoot2, width, height, false);
        shoot3 = Bitmap.createScaledBitmap(shoot3, width, height, false);
        shoot4 = Bitmap.createScaledBitmap(shoot4, width, height, false);
        shoot5 = Bitmap.createScaledBitmap(shoot5, width, height, false);

        dead = BitmapFactory.decodeResource(res, R.drawable.dead);
        dead = Bitmap.createScaledBitmap(dead, width, height, false);


        y = screenY / 2;
        x = (int) (64 * screenRatioX);

    }


    Bitmap getFlight() {

        if (toShoot != 0) {

            switch (shootCounter) {
                case 1:
                    shootCounter++;
                    return shoot1;

                case 2:
                    shootCounter++;
                    return shoot2;

                case 3:
                    shootCounter++;
                    return shoot3;

                case 4:
                    shootCounter++;
                    return shoot4;


            }


            shootCounter = 1;
            toShoot--;
            gameView.newBullet();


            return shoot5;


        }


        if (wingCounter == 0) {
            wingCounter++;
            return flight1;

        }

        wingCounter--;

        return flight2;
    }

    Rect getCollisionShape() {
        return new Rect(x, y, x + width, y + height);
    }

    Bitmap getDead() {
        return dead;
    }


}
