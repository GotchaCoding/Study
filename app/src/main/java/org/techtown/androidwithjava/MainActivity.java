package org.techtown.androidwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;
    Button button4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.service);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ServieAndBrodcastReceiver.class);
                startActivity(intent);
            }
        });


        button2 = findViewById(R.id.ninepatch);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , NinePatch07Activity.class);
                startActivity(i);
            }
        });

        button3 = findViewById(R.id.sampleview);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SampleViewActivity.class);
                startActivity(i);
            }
        });


        button4 = findViewById(R.id.cardView);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                startActivity(intent);
            }
        });


        Button button5 = findViewById(R.id.tweenAnimation);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TweenAnimationActivity.class);
                startActivity(i);
            }
        });

        Button button6 = findViewById(R.id.pagingslide);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PagingSlideActivity3.class);
                startActivity(i);
            }
        });

        Button button7 = findViewById(R.id.webview);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(i);
            }
        });

        Button button8 = findViewById(R.id.seekBarActivity);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SeekBarActivity.class);
                startActivity(i);
            }
        });

        Button button9 = findViewById(R.id.keypadActivity);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, KeypadActivity.class);
                startActivity(i);
            }
        });



    }
}