package org.techtown.androidwithjava.ch11_database.helper;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.androidwithjava.R;

public class DatabaseActivity2 extends AppCompatActivity {

    EditText edt_data;
    EditText edt_table2;
    TextView tv_scroll2;

    SQLiteDatabase database;
    DatabaseHelper dbHelper;

    String tableName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database2);

        edt_data = findViewById(R.id.edt_database2);
        edt_table2 = findViewById(R.id.edt_table2);
        tv_scroll2 = findViewById(R.id.tv_scroll2);

        Button btn_database = findViewById(R.id.btn_database);
        btn_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName = edt_data.getText().toString();
                createDatabase(databaseName);
            }
        });

        Button btn_table = findViewById(R.id.btn_table2);
        btn_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableName = edt_table2.getText().toString();
                createTable(tableName);
                insertRecord();
            }
        });

        Button btn_dataRead = findViewById(R.id.dataRead);
        btn_dataRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeQuery();
            }
        });
    }

    private void createDatabase(String name) {
        println("createDatabase(String name) 호출됨");

        dbHelper = new DatabaseHelper(this);  //DatabaseHelper 객체 생성하고
        database = dbHelper.getWritableDatabase();        //SQLiteDatabase 객체 참조하기
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
                + "(name, age, mobile)"
                + " values "
                + "('John', 20, '010-1234-4567')");
        println("레코드 추가함");
    }

    public void println(String data) {
        tv_scroll2.append(data + "\n");
    }

    public void executeQuery() {
        println("executeQuery 호출됨.");

        Cursor cursor = database.rawQuery("select _id, name, age, mobile from emp", null);
        int recordCount = cursor.getCount();
        println("레코드 개수: " + recordCount);

        for (int i = 0; i < recordCount; i++) {
            cursor.moveToNext();

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String mobile = cursor.getString(3);

            println("레코드#" + i + " : " + id + name + ", " + age + ", " + mobile);
        }
        cursor.close();
    }
}