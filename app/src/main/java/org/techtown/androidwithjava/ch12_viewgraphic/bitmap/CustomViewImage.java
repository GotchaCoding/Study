package org.techtown.androidwithjava.ch12_viewgraphic.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import org.techtown.androidwithjava.R;

public class CustomViewImage extends View {

    private Bitmap cacheBitmap;
    private Canvas cacheCanvas;
    private Paint mPaint;

    public CustomViewImage(Context context) {
        super(context);

        init(context);
    }

    public CustomViewImage(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.d("CustomViewImage", "onSizeChanged(int w, int h, int oldw, int oldh)메서드 실행");
        createCacheBimap(w, h);
        testDrawing();
    }

    private void createCacheBimap(int w, int h) {
        Log.d("CustomViewImage", "createCacheBimap(int w, int h)메서드 실행");
        cacheBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        cacheCanvas = new Canvas();
        cacheCanvas.setBitmap(cacheBitmap);
    }

    private void testDrawing() {
        Log.d("CustomViewImage", " testDrawing()메서드 실행");
        cacheCanvas.drawColor(Color.WHITE);
        mPaint.setColor(Color.RED);
        cacheCanvas.drawRect(100, 200, 400, 400, mPaint);

        //리소스의 이미지 파일을 읽어 들여 화면에 그리기
        Bitmap srcImg = BitmapFactory.decodeResource(getResources(), R.drawable.waterdrop);
        cacheCanvas.drawBitmap(srcImg, 30, 30, mPaint);


        mPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
        Bitmap scaledImg = Bitmap.createScaledBitmap(srcImg,
                srcImg.getWidth() * 3, srcImg.getHeight() * 3, false);
        cacheCanvas.drawBitmap(scaledImg, 30, 400, mPaint);
    }

    protected void onDraw(Canvas canvas) {
        Log.d("CustomViewImage", " onDraw(Canvas canvas)메서드 실행");
        if (cacheBitmap != null) {
            canvas.drawBitmap(cacheBitmap, 0, 0, null);
        }
    }
}
