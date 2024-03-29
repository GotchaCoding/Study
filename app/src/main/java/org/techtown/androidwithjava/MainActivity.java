package org.techtown.androidwithjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.androidwithjava.ch06_service.ServieAndBrodcastReceiverActivity;
import org.techtown.androidwithjava.ch07_widget.CardViewActivity;
import org.techtown.androidwithjava.ch07_widget.NinePatchActivity;
import org.techtown.androidwithjava.ch07_widget.SampleViewActivity;
import org.techtown.androidwithjava.ch07_widget.SamplerecyclerViewActivity;
import org.techtown.androidwithjava.ch07_widget.grid.SamplerecyclerViewActivity2;
import org.techtown.androidwithjava.ch08_animation.KeypadActivity;
import org.techtown.androidwithjava.ch08_animation.PagingSlideActivity;
import org.techtown.androidwithjava.ch08_animation.SeekBarActivity;
import org.techtown.androidwithjava.ch08_animation.TweenAnimationActivity;
import org.techtown.androidwithjava.ch08_animation.WebViewActivity;
import org.techtown.androidwithjava.ch09_thread.ThreadActivity;
import org.techtown.androidwithjava.ch09_thread.ThreadActivity2;
import org.techtown.androidwithjava.ch09_thread.ThreadActivity3;
import org.techtown.androidwithjava.ch10_server.http.http.HttpActivity;
import org.techtown.androidwithjava.ch10_server.http.movie.SampleMovieActivity;
import org.techtown.androidwithjava.ch10_server.http.socket.SocketActivity;
import org.techtown.androidwithjava.ch10_server.http.volley.JsonActivity;
import org.techtown.androidwithjava.ch10_server.http.volley.VolleyActivity;
import org.techtown.androidwithjava.ch11_database.DatabaseActivity;
import org.techtown.androidwithjava.ch11_database.helper.DatabaseActivity2;

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
                Intent intent = new Intent(MainActivity.this, ServieAndBrodcastReceiverActivity.class);
                startActivity(intent);
            }
        });


        button2 = findViewById(R.id.ninepatch);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NinePatchActivity.class);
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

        Button button4_1 = findViewById(R.id.recyclerview_layout);
        button4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SamplerecyclerViewActivity.class);
                startActivity(i);
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
                Intent i = new Intent(MainActivity.this, PagingSlideActivity.class);
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


        Button button10 = findViewById(R.id.threadActivity);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ThreadActivity.class);
                startActivity(i);
            }
        });


        Button button11 = findViewById(R.id.threadActivity2);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ThreadActivity2.class);
                startActivity(i);
            }
        });

        Button button12 = findViewById(R.id.threadActivity3);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ThreadActivity3.class);
                startActivity(i);
            }
        });

        Button button13 = findViewById(R.id.socketActivity);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SocketActivity.class);
                startActivity(i);
            }
        });


        Button button14 = findViewById(R.id.httpActivity);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HttpActivity.class);
                startActivity(i);
            }
        });

        Button button15 = findViewById(R.id.VolleyActivity);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, VolleyActivity.class);
                startActivity(i);
            }
        });

        Button button16 = findViewById(R.id.jsonActivity);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, JsonActivity.class);
                startActivity(i);
            }
        });

        Button button17 = findViewById(R.id.sampleMovieActivity);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SampleMovieActivity.class);
                startActivity(i);
            }
        });


        Button button18 = findViewById(R.id.gridRecyclerViewActivity);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SamplerecyclerViewActivity2.class);
                startActivity(i);
            }
        });

        Button btn_database = findViewById(R.id.databaseActivity);
        btn_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DatabaseActivity.class);
                startActivity(i);
            }
        });

        Button btn_database2 = findViewById(R.id.databaseActivity2);
        btn_database2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DatabaseActivity2.class);
                startActivity(i);
            }
        });

        ImageView nextpage = findViewById(R.id.nextPage);
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });


    }
}