package org.techtown.androidwithjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.androidwithjava.ch11_database.album.AlbumActivity;
import org.techtown.androidwithjava.ch11_database.contacts.ContactsActivity;
import org.techtown.androidwithjava.ch11_database.contentProvider.ContentProviderActivity;

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
    }
}