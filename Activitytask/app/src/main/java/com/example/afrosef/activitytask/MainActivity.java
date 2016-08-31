package com.example.afrosef.activitytask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    //Declaring our ImageView, and Button
    private ImageView imageView;
    Button Rotate, Next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the ImageView , Rotate button and Next button
        imageView = (ImageView) findViewById(R.id.imageview);
        Rotate = (Button) findViewById(R.id.rotatebutton);
        Next = (Button)findViewById(R.id.nextButton) ;

        //Loading Image from URL
        Picasso.with(this)
                .load("http://il9.picdn.net/shutterstock/videos/10283291/thumb/1.jpg")
                .placeholder(R.drawable.placeholder)   // this is optional the image to display while the url image is downloading
                .error(R.drawable.error)      // this is also optional if some error has occurred in downloading the image this image would be displayed
                .into(imageView);

        // Rotate image by 90 degree when user click on Rotate button

        Rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setRotation(imageView.getRotation() + 90);
            }
        });

        // when user click on Next button, FirstActivity appear

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FirstActivity.class );
                startActivity(intent);
            }
        });
    }
}
