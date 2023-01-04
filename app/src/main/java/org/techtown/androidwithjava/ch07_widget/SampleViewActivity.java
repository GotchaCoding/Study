package org.techtown.androidwithjava.ch07_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.techtown.androidwithjava.R;

public class SampleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_view);
    }
}