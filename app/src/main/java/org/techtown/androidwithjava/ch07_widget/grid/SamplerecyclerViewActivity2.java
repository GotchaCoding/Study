package org.techtown.androidwithjava.ch07_widget.grid;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.androidwithjava.R;


public class SamplerecyclerViewActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samplerecyclerview_grid);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_layout_grid);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter2 adapter =new PersonAdapter2();
        adapter.addItem(new Person2( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person2("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person2("짱구" , "010-1234-4567"));
        adapter.addItem(new Person2( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person2("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person2("짱구" , "010-1234-4567"));
        adapter.addItem(new Person2( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person2("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person2("짱구" , "010-1234-4567"));
        adapter.addItem(new Person2( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person2("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person2("짱구" , "010-1234-4567"));
        adapter.addItem(new Person2( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person2("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person2("짱구" , "010-1234-4567"));
        adapter.addItem(new Person2( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person2("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person2("짱구" , "010-1234-4567"));
        adapter.addItem(new Person2( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person2("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person2("짱구" , "010-1234-4567"));
        adapter.addItem(new Person2( "김명훈", "010-7493-7756"));
        adapter.addItem(new Person2("홍길동 ", "010-0000-1234"));
        adapter.addItem(new Person2("짱구" , "010-1234-4567"));

        recyclerView.setAdapter(adapter);

        /**
         * 어뎁터에 리스터 설정
         */
        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter2.ViewHolder holder, View view, int position) {
                Person2 item = adapter.getItem(position);    //아이템 클릭 시 어댑터에서 해당 아이템의 personactivity 객체 가져오기
                Toast.makeText(getApplicationContext(), "아이템선택됨 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}