package com.example.algoritm.lab_4_vll_sem;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Algoritm on 17.12.2017.
 */

public class ActivityPlayer  extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        findViewById(R.id.playButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(R.raw.sting);
            }
        });

        findViewById(R.id.pauseButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause();
            }
        });

    }

    private void play(int songId) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, songId);
        mediaPlayer.start();
    }

    private void pause() {
        mediaPlayer.pause();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }

}
