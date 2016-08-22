package com.example.afrosef.firstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Afrose.F on 8/22/2016.
 */
public class SplashScreen extends Activity {

    private final int splashtime = 3000;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        initialize();
    }

    private void initialize() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                finish();
                startActivity(intent);
            }

        }, splashtime);
    }

}

