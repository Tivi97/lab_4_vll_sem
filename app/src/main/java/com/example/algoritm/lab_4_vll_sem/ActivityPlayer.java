package com.example.algoritm.lab_4_vll_sem;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by Algoritm on 17.12.2017.
 */

public class ActivityPlayer  extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    static String NUMBER_OF_ALBUM;

    String BestOf25Years[] = new String[] { "All this time", "Englishman in New York" };
    String SacredLove[] = new String[] { "I`m so happy i can`t stop crying", "It`s probably me" };
    String BrandNewDay[] = new String[] { "Desert Rose", "Mad about you"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<String> songNames = new ArrayList<>();


        Intent p=getIntent();
        String messageText = p.getStringExtra(NUMBER_OF_ALBUM);
        switch (messageText){
            case "1": songNames.add(0,SacredLove.toString());
            case "2": songNames.add(0,BestOf25Years.toString());
            case "3": songNames.add(0,BrandNewDay.toString());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, songNames);
        listView.setAdapter(adapter);


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

