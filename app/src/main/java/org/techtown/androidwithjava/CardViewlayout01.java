package org.techtown.androidwithjava;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CardViewlayout01 extends LinearLayout {
    ImageView imageView;
    TextView textView;
    TextView textView2;

    public CardViewlayout01(Context context) {
        super(context);
        init(context);
    }

    public CardViewlayout01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.cardviewlayout01, this, true);

        //xml 레이아웃에서 정의했던 뷰 참조하기
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.cardviewtextview);
        textView2 = findViewById(R.id.cardviewtextview2);
    }

    public void setImage(int resID){
        imageView.setImageResource(resID);
    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setMobile(String mobile) {
        textView2.setText(mobile);
    }
}
