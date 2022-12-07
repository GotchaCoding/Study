package org.techtown.androidwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends AppCompatActivity {
    String tag = "seekbarActivity";
 TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        textView = findViewById(R.id.seekbar_textview);

        // 이게 객체가 맞나?  new 클래스명 안적고    find 로 id 값 연결한거가  객체가 됨?
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e(tag, " onProgressChanged 메소드 실행");
                setBrightness(progress);
                Log.e(tag, " setBrightness 메소드 실행");
                textView.setText("변경된 값 : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e(tag, " onStartTrackingTouch 메소드 실행");


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e(tag, " onStopTrackingTouch 메소드 실행");

            }
        });
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                setBrightness(i);
//                textView.setText("변경된 값 : " + i);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//            }
//        });

    }

    private void setBrightness(int value) {
        if (value < 10) {
            value = 10;
        } else if (value > 100) {
            value = 100;
        }

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float) value / 100;
        getWindow().setAttributes(params);
    }

}
