package com.example.algoritm.lab_4_vll_sem;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Created by Algoritm on 24.12.2017.
 */

public class ActivityAlbum extends AppCompatActivity{

    String albumNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);


    }


    public void openActivityPlayer(View view){
        switch (view.getId()){
            case R.id.imageBND: albumNumber="3";
                break;
            case R.id.imageB25: albumNumber="2";
                break;
            case R.id.imageSLA: albumNumber="1";
                break;
        }
        Intent constructor = new Intent(ActivityAlbum.this, ActivityPlayer.class);
        constructor.putExtra(ActivityPlayer.NUMBER_OF_ALBUM, albumNumber.toString());
        startActivity(constructor);

        Intent intent1 = new Intent(ActivityAlbum.this, ActivityPlayer.class);
        startActivity(intent1);
    }



}
