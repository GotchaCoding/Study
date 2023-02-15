package org.techtown.androidwithjava.ch12_viewgraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;



public class CustomView extends View {


    private Paint paint;

    public CustomView(Context context) {
        super(context);

        init(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {  //뷰가 화면에 그려질 때 자동으로 호출 됨
        super.onDraw(canvas);
        canvas.drawRect(100, 100, 200, 200, paint);
        canvas.drawRect(200, 200, 300, 300,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(super.getContext(), "MotionEvent.ACTION_DOWN : " + event.getX() + ", " + event.getY(), Toast.LENGTH_LONG
            ).show();
        }
        return super.onTouchEvent(event);
    }
}
