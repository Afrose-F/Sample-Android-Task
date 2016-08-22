package com.example.afrosef.firstandroidapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Afrose.F on 8/22/2016.
 */
public class SecondActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView back;
    TextView tvBackTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_screen);
        Log.d("second on Create", "on Create");
        init();

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        back = (ImageView) findViewById(R.id.back);
        tvBackTitle = (TextView) findViewById(R.id.app_title);
        toolbar.setContentInsetsAbsolute(0, 0);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String emailID = intent.getStringExtra("mailID");
                Log.v("SecondActivityEmailID", emailID);
                Toast.makeText(SecondActivity.this, "Hello" + " " + emailID, Toast.LENGTH_SHORT).show();
            }
        });


    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
         finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("second on Start", "on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("second on Resume", "on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("second on Pause", "on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("second on Stop", "on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("second on Destroy", "on Destroy of Second Activity");
    }
}
