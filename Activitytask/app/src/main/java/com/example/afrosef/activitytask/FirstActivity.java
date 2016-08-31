package com.example.afrosef.activitytask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Afrose.F on 8/29/2016.
 */
public class FirstActivity extends AppCompatActivity {

    Button Final;
    String selectedColor = "";
    //Declaring our ImageView, and Button
    private AutoCompleteTextView autocompleteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        init();
        process();
    }

    private void init() {
        autocompleteView = (AutoCompleteTextView) findViewById(R.id.autocompleteView);
        Final = (Button) findViewById(R.id.finalButton);

        int layoutItemId = android.R.layout.simple_dropdown_item_1line;
        String[] colorArr = getResources().getStringArray(R.array.colors_list);
        //Log.d("layoutItemId:", "arr: " + Arrays.toString(colorArr));

        List<String> colorList = Arrays.asList(colorArr);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layoutItemId, colorList);

        autocompleteView.setAdapter(adapter);
    }

    private void process() {
        autocompleteView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.d("SELECTED", "Item:" + parent.getItemAtPosition(position));
                selectedColor = (String) parent.getItemAtPosition(position);
                Log.d("SELECTED", "Item:" + selectedColor);


            }
        });

        Final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedColor.equalsIgnoreCase("Yellow")) {
                    Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(FirstActivity.this, "Select 'Yellow' color to proceed", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}

