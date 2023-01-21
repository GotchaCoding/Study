package org.techtown.androidwithjava.ch12_viewgraphic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomView view = new CustomView(this);
        setContentView(view);
    }
}