package com.example.algoritm.lab_4_vll_sem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Algoritm on 24.12.2017.
 */

public class ActivityList extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

    }
    public void openActivityPlayer(View view){

        Intent intent1 = new Intent(ActivityList.this, ActivityPlayer.class);
        startActivity(intent1);

    }

}
