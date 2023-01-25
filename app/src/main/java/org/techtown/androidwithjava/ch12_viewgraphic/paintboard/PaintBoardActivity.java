package org.techtown.androidwithjava.ch12_viewgraphic.paintboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PaintBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BestPaintBoard view = new BestPaintBoard(this);
        setContentView(view);
    }
}