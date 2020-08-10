package com.example.birdattack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_main);


        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });

        TextView highScoreTxt = findViewById(R.id.highScoreTxt);

        final SharedPreferences pref = getSharedPreferences("game", MODE_PRIVATE);
        highScoreTxt.setText("HighScore: " + pref.getInt("highscore", 0));

        pref.getBoolean("isMute", false);

        final ImageView volumeCtrl = findViewById(R.id.volumeCtrl);


        if (isMute) {
            volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_off_24);
        } else {
            volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_up_24);
        }

        volumeCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isMute = !isMute;
                if (isMute) {
                    volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_off_24);
                } else {
                    volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_up_24);
                }

                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();
            }
        });


    }
}