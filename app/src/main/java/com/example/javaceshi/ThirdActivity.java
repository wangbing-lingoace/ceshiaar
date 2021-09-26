package com.example.javaceshi;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PathUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class ThirdActivity extends AppCompatActivity {
    private LottieAnimationView animationView;
    private MediaPlayer mediaPlayer;
    private ImageView imgturntable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        animationView = findViewById(R.id.animationView);
        imgturntable = findViewById(R.id.imgturntable);
        animationView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                LogUtils.e("============onAnimationCancel");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                LogUtils.e("============onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                LogUtils.e("============onAnimationRepeat");
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
//                openAssetMusics();
                LogUtils.e("============onAnimationStart");
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
                LogUtils.e("============onAnimationPause");
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
                LogUtils.e("============onAnimationResume");
            }
        });
//        lottieAniamii();
//        file();
//        rotateAnimation();

    }

    public void button(View view) {
//        lottieAniamii();
        int mark = 2;
        int value = 1;
        rotateAnimation(mark, value);
    }

    /*
     * 根据mark 切换对应的图片 显示有几个数字的盘
     * 1/n *(value-1)*360
     * */
    private void setTurnTable(int mark) {
        float switAngle = 0;
        if (mark == 2) {
            if (imgturntable.getTag() != null && imgturntable.getTag().equals("img_double2")) {
                //
            } else {
                imgturntable.setImageResource(R.mipmap.img_double2);
                imgturntable.setTag("img_double2");
            }
        } else if (mark == 3) {
            if (imgturntable.getTag() != null && imgturntable.getTag().equals("img_double3")) {
                //
            } else {
                imgturntable.setImageResource(R.mipmap.img_double3);
                imgturntable.setTag("img_double3");
            }
        } else if (mark == 4) {
            if (imgturntable.getTag() != null && imgturntable.getTag().equals("img_single4")) {
                //
            } else {
                imgturntable.setImageResource(R.mipmap.img_single4);
                imgturntable.setTag("img_single4");
            }
        } else if (mark == 5) {
            if (imgturntable.getTag() != null && imgturntable.getTag().equals("img_single5")) {
                //
            } else {
                imgturntable.setImageResource(R.mipmap.img_single5);
                imgturntable.setTag("img_single5");
            }
        } else if (mark == 6) {
            if (imgturntable.getTag() != null && imgturntable.getTag().equals("img_single6")) {
                //
            } else {
                imgturntable.setImageResource(R.mipmap.img_single6);
                imgturntable.setTag("img_single6");
            }
        }

    }

    /**
     * @param mark  显示几个数字的转盘
     * @param value 显示数字转盘上的哪个数字位置
     *              1/n *(value-1)*360
     */
    private void rotateAnimation(int mark, int value) {
        float swingle = 0;//应该旋转的角度

        if (mark == 2) {
            if (imgturntable.getTag() != null && imgturntable.getTag().equals("img_double2")) {
                //
            } else {
                imgturntable.setImageResource(R.mipmap.img_double2);
                imgturntable.setTag("img_double2");
            }
//            swingle = 360 * (value - 1) / (2 * 2);
        } else if (mark == 3) {
            if (imgturntable.getTag() != null && imgturntable.getTag().equals("img_double3")) {
                //
            } else {
                imgturntable.setImageResource(R.mipmap.img_double3);
                imgturntable.setTag("img_double3");
            }
//            swingle = 360 * (value - 1) / (3 * 2);
        } else if (mark == 4) {
            if (imgturntable.getTag() != null && imgturntable.getTag().equals("img_single4")) {
                //
            } else {
                imgturntable.setImageResource(R.mipmap.img_single4);
                imgturntable.setTag("img_single4");
            }
        } else if (mark == 5) {
            if (imgturntable.getTag() != null && imgturntable.getTag().equals("img_single5")) {
                //
            } else {
                imgturntable.setImageResource(R.mipmap.img_single5);
                imgturntable.setTag("img_single5");
            }
        } else if (mark == 6) {
            if (imgturntable.getTag() != null && imgturntable.getTag().equals("img_single6")) {
                //
            } else {
                imgturntable.setImageResource(R.mipmap.img_single6);
                imgturntable.setTag("img_single6");
            }
        }
        if (mark == 2 || mark == 3) {
            swingle = 360-(360 / (mark * 2)) * (value - 1);
        } else {
            swingle = 360-(360 / mark) * (value - 1);
        }

        ObjectAnimator anim = ObjectAnimator.ofFloat(imgturntable, "rotation", 0, swingle+360*8);
        anim.reverse();
        // 动画的持续时间，执行多久？
        anim.setDuration(3000);
        anim.start();
    }

    private void lottieAniamii() {
        animationView.setAnimation("ribbon-and-confetti.json");

        //播放一次， 然后循环三次
//        animationView.setRepeatCount(3);

        openAssetMusics();
        animationView.playAnimation();
    }

    private void file() {
        if (FileUtils.isFileExists(PathUtils.getExternalAppCachePath() + "/mmmmm/" + "writeFileFromIS.txt")) {
            LogUtils.e("存在");
        } else {
            saveToFile();
        }
    }


    private void saveToFile() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(String.format("%5dFileIOUtilsTest\n", i));
        }
        InputStream is = ConvertUtils.string2InputStream(sb.toString(), "UTF-8");

        FileIOUtils.writeFileFromIS(PathUtils.getExternalAppCachePath() + "/mmmmm/" + "writeFileFromIS.txt", is, true, new FileIOUtils.OnProgressUpdateListener() {
            @Override
            public void onProgressUpdate(double progress) {
                System.out.println(String.format("%.2f", progress));
            }
        });
        FileIOUtils.writeFileFromString(PathUtils.getExternalAppCachePath() + "/cocos/" + "writeFileFromIS.txt", "我草", true);
//        FileIOUtils.writeFileFromString(PathUtils.getInternalAppCachePath() + "/mmmmm/" + "writeFileFromIS.txt","我草内寸cache",true);
    }

    /**
     * 打开assets下的音乐mp3文件
     */
    private void openAssetMusics() {

        try {

            if (mediaPlayer == null) {
                mediaPlayer = new MediaPlayer();
            }
            //播放完成必须reset一下
            mediaPlayer.reset();
            //播放 assets/a2.mp3 音乐文件
            AssetFileDescriptor fd = getAssets().openFd("ribbonvoice.mp3");
            mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}