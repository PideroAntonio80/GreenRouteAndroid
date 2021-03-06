package com.svalero.greenroute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.svalero.greenroute.feature.road_list.RoadListActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(
                                getBaseContext(), RoadListActivity.class);
                        startActivity(intent);
                    }
                }, 3000);
    }
}