package com.example.javaceshi.luckyoan;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author LiuChao
 * @descibe 如何使用surfaceView(基本流程和格式)
 * @date 2018/02/05
 * @contact email:450127106@qq.com
 */

public class SurfaceViewTemplate extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private SurfaceHolder mSurfaceHolder;
    private Canvas mCanvas;
    /**
     * 用于surfaceview绘制的子线程
     */
    private Thread mThread;
    /**
     * 控制子线程开关
     */
    private boolean isRunning;

    public SurfaceViewTemplate(Context context) {
        super(context);
        init(context);
    }

    public SurfaceViewTemplate(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SurfaceViewTemplate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mSurfaceHolder = this.getHolder();
        // 管理surfaceview的生命周期
        mSurfaceHolder.addCallback(this);
        // 能够获取焦点
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        // 保持常亮
        this.setKeepScreenOn(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        isRunning = true;
        mThread = new Thread(this);
        mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        isRunning = false;
    }

    @Override
    public void run() {
        /**
         * 不断的进行绘制
         */
        while (isRunning) {
            draw();
        }
    }

    private void draw() {
        try {
            mCanvas = mSurfaceHolder.lockCanvas();
            if (mCanvas != null) {
                // 绘制
            }
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            if (mCanvas != null) {
                mSurfaceHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }
}
