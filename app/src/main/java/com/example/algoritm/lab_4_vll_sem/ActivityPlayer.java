package com.example.algoritm.lab_4_vll_sem;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by Algoritm on 17.12.2017.
 */

public class ActivityPlayer  extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
   // static String NUMBER_OF_ALBUM;

    private ArrayList<HashMap<String, Object>> ourSongs; //наш массив объектов, без него никак
    private static final String SONGNAME = "";    // Главное название, большими буквами
    private static final String IMAGES = "";  // Наименование, то что ниже главного


   /* String BestOf25Years[] = new String[]{"All this time", "Englishman in New York"};
    String SacredLove[] = new String[]{"I`m so happy i can`t stop crying", "It`s probably me"};
    String BrandNewDay[] = new String[]{"Desert Rose", "Mad about you"};
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        ListView listView = (ListView) findViewById(R.id.listViewPl);
        ourSongs= new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hm;


        ///С помощью ключевого HashMap добавляем название (то что большими буквами), и описание (маленькими)
        hm = new HashMap<String, Object>();
        hm.put(SONGNAME, "All this time");                 //Название
        hm.put(IMAGES,  R.drawable.play);         //Описание

        ourSongs.add(hm);                            //Добавляем на форму для отображения, без этой функции мы не видим сам вью

        hm = new HashMap<String, Object>();
        hm.put(SONGNAME, "Englishman in New York");
        hm.put(IMAGES, R.drawable.play);

       ourSongs.add(hm);

        hm = new HashMap<String, Object>();
        hm.put(SONGNAME, "I`m so happy i can`t stop crying");
        hm.put(IMAGES, R.drawable.play);

        ourSongs.add(hm);


        SimpleAdapter adapter = new SimpleAdapter(this,
                ourSongs,
                R.layout.list, new String[]{ // массив названий
                SONGNAME,         //верхний текст
                IMAGES,        //нижний теккт
        }, new int[]{    //массив форм
                R.id.text1,      //наш id TextBox'a в list.xml
                R.id.imagePlayOrStop});    //ссылка на объект отображающий текст

        listView.setAdapter(adapter);                         //говорим программе что бы отображала все объекты
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);  //Даем возможность выбора если есть желание сделать переход на другие формы



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