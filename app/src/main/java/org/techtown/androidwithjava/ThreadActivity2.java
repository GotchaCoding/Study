package org.techtown.androidwithjava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThreadActivity2 extends AppCompatActivity {


    TextView textview ;
    Handler handler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread2);

        textview = findViewById(R.id.textview_thread2);

        Button button =findViewById(R.id.btn_thread2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });

    }

    private  void request(){
        String title = "원격요청";
        String message = "데이터를 요청하시겠습니까?";
        String titleButtonYes="예";
        String titleButtonNo="아니오";
        AlertDialog dialog = makeRequestDialog(title, message, titleButtonYes, titleButtonNo);
        dialog.show();

        textview.setText("대화상자 표시중");
    }


    private AlertDialog makeRequestDialog(CharSequence title, CharSequence message, CharSequence titleButtonYes, CharSequence titleButtonNo) {
        AlertDialog.Builder requestDialog = new AlertDialog.Builder(this);
        requestDialog.setTitle(title);
        requestDialog.setMessage(message);
        requestDialog.setPositiveButton(titleButtonYes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textview.setText("5초 후에 결과 표시됨");

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textview.setText("요청 완료됨");
                    }
                }, 5000);
            }
        });
        requestDialog.setNegativeButton(titleButtonNo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return requestDialog.create();
    }

}