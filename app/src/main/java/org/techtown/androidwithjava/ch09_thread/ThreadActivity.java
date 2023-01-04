package org.techtown.androidwithjava.ch09_thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.techtown.androidwithjava.R;

public class ThreadActivity extends AppCompatActivity {
    int value =0;
    TextView textView;
//    MainHandler handler;
    MainHandler handler = new MainHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        textView = findViewById(R.id.textview_thread);

        Button button =findViewById(R.id.btn_thread);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgrondThread thread = new BackgrondThread();
                thread.start();
            }
        });
//        handler = new MainHandler();
    }


    class BackgrondThread extends Thread {
        public void run() {
            for(int i = 0; i <100; i++) {
                try{
                    Thread.sleep(1000);
                }catch(Exception e) {}
                value += 1;
                Log.d("Thread", "value : " + value);

//              Message message = handler.obtainMessage();
//              Bundle bundle = new Bundle();
//              bundle.putInt("value" , value);
//              message.setData(bundle);
//
//              handler.sendMessage(message);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("value 값 : " + value);
                    }
                });
            }
        }
    }


    class MainHandler extends Handler{

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");
            textView.setText("value 값 : " + value);
        }
    }
}