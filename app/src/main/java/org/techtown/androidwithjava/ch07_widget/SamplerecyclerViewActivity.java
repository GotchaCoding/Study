package org.techtown.androidwithjava.ch07_widget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.Person;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.techtown.androidwithjava.R;
import org.techtown.androidwithjava.ch07_widget.PersonAdapter;

public class SamplerecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samplerecyclerview);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_layout);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter =new PersonAdapter();

        adapter.addItem(new Person1( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person1("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person1("짱구" , "010-1234-4567"));
        adapter.addItem(new Person1( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person1("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person1("짱구" , "010-1234-4567"));
        adapter.addItem(new Person1( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person1("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person1("짱구" , "010-1234-4567"));
        adapter.addItem(new Person1( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person1("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person1("짱구" , "010-1234-4567"));

        recyclerView.setAdapter(adapter);
    }
}