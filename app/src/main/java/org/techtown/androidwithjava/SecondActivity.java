package org.techtown.androidwithjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.androidwithjava.ch11_database.album.AlbumActivity;
import org.techtown.androidwithjava.ch11_database.contacts.ContactsActivity;
import org.techtown.androidwithjava.ch11_database.contentProvider.ContentProviderActivity;
import org.techtown.androidwithjava.ch12_viewgraphic.CustomViewActivity;
import org.techtown.androidwithjava.ch12_viewgraphic.CustomViewStyleActivity;
import org.techtown.androidwithjava.ch12_viewgraphic.bitmap.BitmapActivity;
import org.techtown.androidwithjava.ch12_viewgraphic.drawable.MyDrawableActivity;
import org.techtown.androidwithjava.ch12_viewgraphic.multitouch.MultiTouchActivity;
import org.techtown.androidwithjava.ch12_viewgraphic.paintboard.PaintBoardActivity;
import org.techtown.androidwithjava.ch13_multimedia.AudioPlayerActivity;
import org.techtown.androidwithjava.ch13_multimedia.CaptureIntentActivity;
import org.techtown.androidwithjava.ch13_multimedia.MediaRecorderActivity;
import org.techtown.androidwithjava.ch13_multimedia.SurfaceCaptureActivity;
import org.techtown.androidwithjava.ch13_multimedia.VideoPlayerActivity;
import org.techtown.androidwithjava.ch13_multimedia.VideoRecodingActivity;
import org.techtown.androidwithjava.ch13_multimedia.YoutubeActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Button btn_contentProvider = findViewById(R.id.btn_contentProvider);
        btn_contentProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, ContentProviderActivity.class);
                startActivity(i);
            }
        });

        Button btn_album = findViewById(R.id.btn_album);
        btn_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, AlbumActivity.class);
                startActivity(i);
            }
        });

        Button btn_contacts = findViewById(R.id.btn_contacts);
        btn_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, ContactsActivity.class);
                startActivity(i);
            }
        });

        Button btn_custom = findViewById(R.id.btn_customView);
        btn_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, CustomViewActivity.class);
                startActivity(i);
            }
        });

        Button btn_customStyle = findViewById(R.id.btn_customStyle);
        btn_customStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, CustomViewStyleActivity.class);
                startActivity(i);
            }
        });

        Button btn_drawable = findViewById(R.id.btn_mydrawable);
        btn_drawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, MyDrawableActivity.class);
                startActivity(i);
            }
        });

        Button btn_bitmap = findViewById(R.id.btn_bitmap);
        btn_bitmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, BitmapActivity.class);
                startActivity(i);
            }
        });

        Button btn_paintboard = findViewById(R.id.btn_patinboard);
        btn_paintboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, PaintBoardActivity.class);
                startActivity(i);
            }
        });

        Button btn_multitouch = findViewById(R.id.btn_multitouch);
        btn_multitouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, MultiTouchActivity.class);
                startActivity(i);
            }
        });

        Button btn_capture = findViewById(R.id.btn_capture);
        btn_capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, CaptureIntentActivity.class);
                startActivity(i);
            }
        });

        Button btn_surfaceCapture = findViewById(R.id.btn_surfaceCapture);
        btn_surfaceCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, SurfaceCaptureActivity.class);
                startActivity(i);
            }
        });

        Button btn_music = findViewById(R.id.btn_music);
        btn_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, AudioPlayerActivity.class);
                startActivity(i);
            }
        });

        Button btn_media = findViewById(R.id.btn_media);
        btn_media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, VideoPlayerActivity.class);
                startActivity(i);
            }
        });

        Button btn_record = findViewById(R.id.btn_record);
        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, MediaRecorderActivity.class);
                startActivity(i);
            }
        });

        Button btn_videoRecord = findViewById(R.id.btn_videoRecord);
        btn_videoRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, VideoRecodingActivity.class);
                startActivity(i);
            }
        });

        Button btn_youtube = findViewById(R.id.btn_youtube);
        btn_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, YoutubeActivity.class);
                startActivity(i);
            }
        });

    }
}