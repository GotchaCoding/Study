package org.techtown.androidwithjava.ch07_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.techtown.androidwithjava.R;

public class CardViewActivity extends AppCompatActivity {

    CardViewlayout cardviewlayout01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);


        cardviewlayout01 = findViewById(R.id.cardviewlayout01);


        cardviewlayout01.setImage(R.drawable.picachu);
        cardviewlayout01.setName("신짱구");
        cardviewlayout01.setMobile("010-1234-0000");


    }
}