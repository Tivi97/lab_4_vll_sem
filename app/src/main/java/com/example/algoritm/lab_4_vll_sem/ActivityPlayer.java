package com.example.algoritm.lab_4_vll_sem;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    static String NUMBER_OF_ALBUM;
    boolean flag=false;


    private ArrayList<HashMap<String, Object>> ourSongs; //наш массив объектов, без него никак
    private static final String SONGNAME = "";
    private static final String IMAGE = "";// Главное название, большими буквами
    private static final String IMAGES = "";  // Наименование, то что ниже главного
    String LOG_TAG = "myLogs";

   /* String BestOf25Years[] = new String[]{"All this time", "Englishman in New York"};
    String SacredLove[] = new String[]{"I`m so happy i can`t stop crying", "It`s probably me"};
    String BrandNewDay[] = new String[]{"Desert Rose", "Mad about you"};
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent = getIntent();
        String alb=intent.getStringExtra(NUMBER_OF_ALBUM);


        final ListView listView = (ListView) findViewById(R.id.listViewPl);
        ourSongs= new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hm;



                hm = new HashMap<String, Object>();
                hm.put(SONGNAME, "I`m so happy i can`t stop crying");
                ourSongs.add(hm);

                hm = new HashMap<String, Object>();
                hm.put(SONGNAME, "It`s probably me");
                ourSongs.add(hm);

                hm = new HashMap<String, Object>();
                hm.put(SONGNAME, "All this time");
                ourSongs.add(hm);

                hm = new HashMap<String, Object>();
                hm.put(SONGNAME, "Englishman in New York");
                ourSongs.add(hm);


                hm = new HashMap<String, Object>();
                hm.put(SONGNAME, "Desert Rose");
                ourSongs.add(hm);

                hm = new HashMap<String, Object>();
                hm.put(SONGNAME, "Mad about you");
                ourSongs.add(hm);

        ///С помощью ключевого HashMap добавляем название (то что большими буквами), и описание (маленькими)

        SimpleAdapter adapter = new SimpleAdapter(this,
                ourSongs,
                R.layout.list, new String[]{ // массив названий
                SONGNAME,
        }, new int[]{    //массив форм
               R.id.text1//,
                /*R.id.imagePlayOrStop*/});    //ссылка на объект отображающий текст

        listView.setAdapter(adapter);                         //говорим программе что бы отображала все объекты
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);  //Даем возможность выбора если есть желание сделать переход на другие формы

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int pos, long id) {

            switch (pos){
                case 0: play(R.raw.i_am_so_happy_i_can_not_stop_crying);
                flag=true;

                break;
                case 1: play(R.raw.it_is_probably_me);
                    flag=true;

                    break;
                case 2: play(R.raw.all_this_time);
                    flag=true;

                    break;
                case 3: play(R.raw.englishman_in_new_york);
                    flag=true;
                    break;
                case 4: play(R.raw.desert_rose);
                    flag=true;
                    break;
                case 5: play(R.raw.mad_about_you);
                    flag=true;
                    break;
            }



            }
        });

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

       // mediaPlayer = MediaPlayer.create(this, songID);
        mediaPlayer.pause();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }


        public void getImage(View w){
       findViewById(R.id.imagePlayOrStop).setBackgroundResource(R.drawable.pause);
}

}