package com.example.algoritm.lab_4_vll_sem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void openActivityAlf(View view){

        Intent ALintent = new Intent(MainActivity.this, ActivityList.class);
        startActivity(ALintent);

    }

}
