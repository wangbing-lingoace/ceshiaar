package com.example.javaceshi.luckyoan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.javaceshi.R;


/**
 * @author LiuChao
 * @descibe
 * @date 2018/02/05
 * @contact email:450127106@qq.com
 */

public class LunckyPan extends SurfaceView implements SurfaceHolder.Callback, Runnable {

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

    private String[] itemTextStrs = new String[]{"兵哥", "外卖", "兵哥", "黄焖鸡", "兵哥", "粒当家"};

    private int[] itemImgs = new int[]{R.drawable.f015, R.drawable.f015, R.drawable.f015
            , R.drawable.f015, R.drawable.f015, R.drawable.f015};

    private Bitmap[] mBitmaps;

    /**
     * 背景
     */
    private Bitmap mBgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg2);

    private int[] itemColors = new int[]{0xffffc300, 0xfff17e01, 0xffffc300, 0xfff17e01, 0xffffc300, 0xfff17e01};

    private int mItemCount = 6;

    /**
     * 整个盘块的范围
     */
    private RectF mRange = new RectF();
    /**
     * 整个盘块的直径
     */
    private int mRadius;
    /**
     * 绘制盘块的画笔
     */
    private Paint mArcPaint;
    /**
     * 绘制文本的画笔
     */
    private Paint mTextPaint;

    private float mTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics());
    /**
     * 盘块滚动的速度
     */
    private double mSpeed = 0;

    /**
     * 转盘的中心位置
     */
    private int mCenter;
    /**
     * 这里我们的padding直接取paddingLeft
     */
    private int mPadding;

    /**
     * volatile保证线程间的可见性
     */
    private volatile float mStartAngle = 0;

    /**
     * 判断是否点击了停止按钮
     */
    private boolean isShouldEnd = false;

    /**
     * 设置单次绘制最低时间，如果在该时间内绘制完成，让子线程sleep到改时间结束
     * 这样防止了线程绘制频繁，先消耗性能的问题
     */
    private long mOneTimeMinMillionSeconds = 50;

    private int mDifferSpeed = 1;// 调用停止后递减的速度差值 要大于0

    private boolean hasImg = false;
    private boolean hasText = false;


    public LunckyPan(Context context) {
        super(context);
        init(context);
    }

    public LunckyPan(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LunckyPan(Context context, AttributeSet attrs, int defStyleAttr) {
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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = Math.min(getMeasuredWidth(), getMeasuredHeight());
        mPadding = getPaddingLeft();
        mRadius = width - mPadding * 2;
        // 中心点
        mCenter = width / 2;
        setMeasuredDimension(width, width);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        // 初始化盘块画笔
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setDither(true);
        // 初始化文字画笔
        mTextPaint = new Paint();
        mTextPaint.setColor(0xffffffff);
        mTextPaint.setTextSize(mTextSize);

        // 初始化盘块绘制范围
        mRange = new RectF(mPadding, mPadding, mPadding + mRadius, mPadding + mRadius);
        // 初始化图片
        mBitmaps = new Bitmap[mItemCount];
        for (int i = 0; i < mItemCount; i++) {
            mBitmaps[i] = BitmapFactory.decodeResource(getResources(), itemImgs[i]);
        }
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
            long preMillions = System.currentTimeMillis();
            draw();
            long afterMillions = System.currentTimeMillis();
            long drawOnceTime = afterMillions - preMillions;
            if (drawOnceTime < mOneTimeMinMillionSeconds) {
                try {
                    Thread.sleep(mOneTimeMinMillionSeconds - drawOnceTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void draw() {
        try {
            mCanvas = mSurfaceHolder.lockCanvas();
            if (mCanvas != null) {
                // 绘制
                drawBg();
                drawPanKuai();
            }
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            if (mCanvas != null) {
                mSurfaceHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }

    /**
     * 绘制盘块
     */

    private void drawPanKuai() {
        // 起始角度
        float tempAngle = mStartAngle;
        // 每个盘块绘制的角度
        float sweepAngele = 360 / mItemCount;
        for (int i = 0; i < mItemCount; i++) {
            mArcPaint.setColor(itemColors[i]);
            // 绘制盘块
            mCanvas.drawArc(mRange, tempAngle, sweepAngele, true, mArcPaint);
            // 绘制文本
            drawText(tempAngle, sweepAngele, itemTextStrs[i]);
            // 绘制图标
            drawIcon(tempAngle, mBitmaps[i]);

            tempAngle += sweepAngele;
        }
        mStartAngle += mSpeed;

        // 如果需要停止,让转速逐渐变小直到0
        if (isShouldEnd) {
            mSpeed -= mDifferSpeed;
        }
        if (mSpeed <= 0) {
            mSpeed = 0;
            isShouldEnd = false;
        }

    }

    /**
     * 绘制每个盘块的图标
     *
     * @param tempAngle
     * @param bitmap
     */
    private void drawIcon(float tempAngle, Bitmap bitmap) {
        // 约束图片的宽度，为直径的1/8,可以作为可变参数设置
        int imgWidth = mRadius / 8;
        // 获取弧度值
        float angle = (float) ((tempAngle + 360 / mItemCount / 2) * Math.PI / 180);

        // 约定图片位置在直径1/4处
        int x = (int) (mCenter + mRadius / 4 * Math.cos(angle));
        int y = (int) (mCenter + mRadius / 4 * Math.sin(angle));

        // 确定图片位置
        Rect rect = new Rect(x - imgWidth / 2, y - imgWidth / 2, x + imgWidth / 2, y + imgWidth / 2);
        mCanvas.drawBitmap(bitmap, null, rect, null);
    }

    /**
     * 绘制每个盘块的文本
     *
     * @param tempAngle
     * @param sweepAngele
     * @param itemTextStr
     */
    private void drawText(float tempAngle, float sweepAngele, String itemTextStr) {
        Path path = new Path();
        path.addArc(mRange, tempAngle, sweepAngele);
        // 利用水平偏移量让文字居中
        float textWidth = mTextPaint.measureText(itemTextStr);
        int hOffset = (int) (mRadius * Math.PI / mItemCount / 2 - textWidth / 2);
        // 利用垂直偏移量让文字向圆心靠拢
        int vOffset = mRadius / 2 / 6;
        mCanvas.drawTextOnPath(itemTextStr, path, hOffset, vOffset, mTextPaint);

    }

    /**
     * 绘制背景
     */
    private void drawBg() {
        mCanvas.drawColor(0xFFFFFFFF);
        mCanvas.drawBitmap(mBgBitmap, null, new Rect(mPadding / 2, mPadding / 2, getMeasuredWidth() - mPadding / 2, getMeasuredWidth() - mPadding / 2), null);
    }

    /**
     * 启动转盘
     * 能够控制到具体某个index范围内停止
     */
    public void luckyStart(int index) {
        if (isStart()) {
            return;
        }
        if (index < 0) {
            mSpeed = 30 * (1 + Math.random() * (0.2));
            isShouldEnd = false;
            return;
        }
        // 计算每一项的角度
        float angle = 360 / mItemCount;

        // 计算该index的角度范围
        // 1->150~210
        // 0->210~270 (第1个奖品与竖直上方指针的角度范围，即为该奖品的选中范围) 注：指针是保持不动的
        float from = 270 - (index + 1) * angle;
        float end = from + angle;

        // 设置停下来需要旋转的距离
        float targetFrom = 4 * 360 + from;
        float targetEnd = 4 * 360 + end;

        // (v1+0)*(v1)/2=s => (v1+0)*(v1+1)/2=s  s=>(targetFrom~targetEnd)
        // 计算出需要的转速:v1~v2之间的速度，就是我们需要的速度
        float v1 = (float) ((-1 + Math.sqrt(1 + 8 * targetFrom)) / 2);
        float v2 = (float) ((-1 + Math.sqrt(1 + 8 * targetEnd)) / 2);
        mSpeed = v1 + Math.random() * (v2 - v1);
        // 假设转速为50
        //mSpeed = 50;
        isShouldEnd = false;
    }

    /**
     * 停止转盘
     */
    public void luckyEnd() {
        if (isShouldEnd()) {
            return;
        }
        // 将初始角度重置
        mStartAngle = 0;
        isShouldEnd = true;
    }

    /**
     * 转盘是否在旋转
     *
     * @return
     */
    public boolean isStart() {
        return mSpeed != 0;
    }

    /**
     * 是否停止状态(但可能处于旋转减速到停止)
     *
     * @return
     */
    public boolean isShouldEnd() {
        return isShouldEnd;
    }

    public void setGiftNames(String[] giftNames, String[] giftPics) {
        // 先停止 luckyEnd
        if ((giftNames == null || giftNames.length <= 0) && (giftPics == null || giftPics.length <= 0)) {
            throw new IllegalArgumentException("请输入具体的礼物");
        }
        if (giftNames != null && giftNames.length > 0) {

        }
        itemTextStrs = giftNames;
        mItemCount = giftNames.length;
    }


}
