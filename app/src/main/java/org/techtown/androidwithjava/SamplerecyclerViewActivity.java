package org.techtown.androidwithjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.Person;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class SamplerecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samplerecyclerview);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_layout);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter =new PersonAdapter();

        adapter.addItem(new PersonActivity( "김명훈", "010-7493-7756"));
        adapter.addItem(new PersonActivity("홍길동 ", "010-0000-1234"));
        adapter.addItem(new PersonActivity("짱구" , "010-1234-4567"));
        adapter.addItem(new PersonActivity( "김명훈", "010-7493-7756"));
        adapter.addItem(new PersonActivity("홍길동 ", "010-0000-1234"));
        adapter.addItem(new PersonActivity("짱구" , "010-1234-4567"));
        adapter.addItem(new PersonActivity( "김명훈", "010-7493-7756"));
        adapter.addItem(new PersonActivity("홍길동 ", "010-0000-1234"));
        adapter.addItem(new PersonActivity("짱구" , "010-1234-4567"));
        adapter.addItem(new PersonActivity( "김명훈", "010-7493-7756"));
        adapter.addItem(new PersonActivity("홍길동 ", "010-0000-1234"));
        adapter.addItem(new PersonActivity("짱구" , "010-1234-4567"));

        recyclerView.setAdapter(adapter);
    }
}