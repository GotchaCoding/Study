package org.techtown.androidwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class PagingSlideActivity3 extends AppCompatActivity {
    boolean isPageOpen = false;
    String tag = "Pagingslide Activity";
    Animation translateLeftAnim;
    Animation translateRightAnim;

    LinearLayout page;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging_slide3);

        page = findViewById(R.id.page);

//        애니메이션 객체 만들어주는 과정
        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        SlidingPageAnimationListener animListener = new SlidingPageAnimationListener();
        translateLeftAnim.setAnimationListener(animListener);
        translateRightAnim.setAnimationListener(animListener);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPageOpen) {
                    Log.e(tag, "버튼클릭  : if문");
                    page.startAnimation(translateRightAnim);
                } else {
                    Log.e(tag, "버튼클릭  : else문" );
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeftAnim);
                }
            }
        });
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener {

        //이건 오버라이드 아니네??   위에 잇는 클래스에서도 사용 안됫고,,,  근데 사용이 되긴 햇음..    오버라이드 안됫는데  자동사용 됨?
        public void onAnimationEnd(Animation animation) {
            if (isPageOpen) {
                Log.e(tag, "onAnimationEnd 실행  : if문");
                page.setVisibility(View.INVISIBLE);

                button.setText("Open");
                isPageOpen = false;
            } else {
                Log.e(tag, "onAnimationEnd 실행  : else문");
                button.setText("Close");
                isPageOpen = true;

            }
        }

        @Override
        public void onAnimationStart(Animation animation) {
            Log.e("PagingActivity" , "onAnimationStart 메소드 실행됨 ");
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            Log.e("PagingActivity" , "onAnimationRepeat 메소드 실행됨 ");
        }
    }

}
