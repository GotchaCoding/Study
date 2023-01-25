package org.techtown.androidwithjava.ch12_viewgraphic.bitmap;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BitmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        CustomViewImage view = new CustomViewImage(this);
        setContentView(view);
    }
}