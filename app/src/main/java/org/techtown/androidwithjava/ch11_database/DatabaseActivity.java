package org.techtown.androidwithjava.ch11_database;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.androidwithjava.R;

public class DatabaseActivity extends AppCompatActivity {

    EditText edt_data;
    EditText edt_table;
    TextView tv_scroll;

    SQLiteDatabase database;

    String tableName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        edt_data = findViewById(R.id.edt_database);
        edt_table = findViewById(R.id.edt_table);
        tv_scroll = findViewById(R.id.tv_scroll);

        Button btn_database = findViewById(R.id.btn_database);
        btn_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName = edt_data.getText().toString();
                createDatabase(databaseName);
            }
        });

        Button btn_table = findViewById(R.id.btn_table);
        btn_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableName = edt_table.getText().toString();
                createTable(tableName);
                insertRecord();
            }
        });
    }

    private void createDatabase(String name) {
        println("createDatabase(String name) 호출됨");
        database = openOrCreateDatabase(name, MODE_PRIVATE, null);
        println("데이터베이스 생성함: " + name);
    }

    private void createTable(String name) {
        println("createTable(String name) 호출됨.");
        if (database == null) {
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }

        database.execSQL("create table if not exists " + name + "("
                + " _id integer PRIMARY KEY autoincrement, "
                + " name text, "
                + " age integer, "
                + " mobile text)");

        println("테이블 생성함 : " + name);
    }

    private void insertRecord() {
        println("insertRecord() 호출됨.");
        if (database == null) {
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }

        if (tableName == null) {
            println("테이블을 먼저 생성하세요.");
            return;
        }
        database.execSQL("insert into " + tableName
                + "(name, age ,mobile)"
                + " values "
                + "('John', 20, '010-1234-4567')");
        println("레코드 추가함");
    }

    public void println(String data) {
        tv_scroll.append(data + "\n");
    }
}