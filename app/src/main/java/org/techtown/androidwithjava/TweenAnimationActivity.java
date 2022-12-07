package org.techtown.androidwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class TweenAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        Button button = findViewById(R.id.btn_tweenanimation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale); //리소스에 정의한 애니메이션 액션 로딩
                v.startAnimation(anim);
            }
        });

        Button button1 = findViewById(R.id.btn_tweenanimation2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale2);

                v.startAnimation(anim);
            }
        });

        Button button2 = findViewById(R.id.btn_tweenanimation3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_movement);

                v.startAnimation(anim);
            }
        });

        Button button3 =findViewById(R.id.btn_tweenanimation4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

                v.startAnimation(anim);
            }
        });


        Button button4 = findViewById(R.id.btn_tweenanimation5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);

                v.startAnimation(anim);
            }
        });


    }
}