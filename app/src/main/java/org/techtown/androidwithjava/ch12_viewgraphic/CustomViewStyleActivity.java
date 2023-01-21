package org.techtown.androidwithjava.ch12_viewgraphic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CustomViewStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomViewStyle view = new CustomViewStyle(this);
        setContentView(view);
    }
}
