package com.example.javaceshi.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawTextView extends View {
    private Paint mPaint;
    private String text = "你是我世界之光，我心另一半";
    public DrawTextView(Context context) {
        super(context);
        initView();
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GREEN);
        Log.e("======", "setcolor: " + Color.GREEN);
        mPaint.setTextSize(40);
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setTypeface(Typeface.SANS_SERIF);

//        mPaint.setColor(Color.BLUE);
//        mPaint.setStyle(Paint.Style.STROKE);//设置画笔的样式
//        mPaint.setStrokeCap(Paint.Cap.BUTT);//线帽
//        mPaint.setStrokeJoin(Paint.Join.BEVEL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int color = mPaint.getColor();
        Log.e("======", "onDraw: " + color);
        canvas.drawText("我是黄色", 400, 400, mPaint);
        canvas.drawLine(0, 0, 200, 400, mPaint);


//        int top = 100;
//        int baselineX = 0;
//        mPaint.setTextSize(50);
//        mPaint.setTextAlign(Paint.Align.LEFT);
//
//        canvas.drawLine(0, top, 2000, top, mPaint);
//
//
//        //文本Metrics
//        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
//        float baselineY = top - fontMetrics.top;
//        canvas.drawText(text, baselineX, baselineY, mPaint);
//



    }
}
