package org.techtown.androidwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CardViewActivity extends AppCompatActivity {

    CardViewlayout01 cardviewlayout01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        //모야 여기.. 왜안돼
        cardviewlayout01 = findViewById(R.id.cardviewlayout01);


        cardviewlayout01.setImage(R.drawable.picachu);
        cardviewlayout01.setName("김명훈");
        cardviewlayout01.setMobile("010-7493-0000");


    }
}