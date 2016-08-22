package com.example.afrosef.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText email;
    Button bvalidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("on Create", "on Create");
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("on Start", "on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("on Resume", "on Resume");
        email.setText("");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("on Pause", "on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("on Stop", "on Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("on Restart", "on Restart");
    }

    private void init() {

        email = (EditText) findViewById(R.id.etemail);
        bvalidate = (Button) findViewById(R.id.validatebutton);

        bvalidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailvalidate = email.getText().toString();

                Log.v("EditTextValue", emailvalidate);
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (emailvalidate.length() < 1) {
                    Log.d("empty", "empty");
                    email.setError("Email field cannot be blank");
                } else if (!emailvalidate.matches(emailPattern)) {
                    Log.d("invalid", "invalid");
                    email.setError("Invalid Email");
                } else {
                    Log.d("matched", "matched");
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("mailID", emailvalidate);
                    startActivity(intent);
                }
            }
        });
    }


}
