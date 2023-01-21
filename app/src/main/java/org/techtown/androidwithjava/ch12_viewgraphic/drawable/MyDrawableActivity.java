package org.techtown.androidwithjava.ch12_viewgraphic.drawable;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MyDrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomViewDrawable view = new CustomViewDrawable(this);
        setContentView(view);
    }
}