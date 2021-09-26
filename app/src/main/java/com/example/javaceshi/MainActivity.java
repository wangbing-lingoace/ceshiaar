package com.example.javaceshi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lingoace.liveroom.activity.LoginActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LogUtils.e(
//                "{\"code\":0,\"message\":\"Success\",\"data\":{\"defaultCourseIndex\":2006,\"currentCourseIndex\":2002,\"nopreload\":0,\"courseWareList\":[{\"coursewareId\":0,\"coursewareName\":\"白板\",\"totalPage\":1,\"currentPage\":1,\"indexUrl\":null,\"type\":\"whiteboard\",\"originUrl\":null,\"status\":0},{\"coursewareId\":2006,\"coursewareName\":\"部署.png\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"\",\"type\":\"image\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925096369部署-128479234.png\",\"status\":20},{\"coursewareId\":2005,\"coursewareName\":\"foodninja.mp4\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"\",\"type\":\"video\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925096369foodninja-1275847713.mp4\",\"status\":20},{\"coursewareId\":2004,\"coursewareName\":\"春夏秋冬一对一.ppt\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"yhOYPRFU3_vVI_NK\",\"type\":\"ppt\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925096369春夏秋冬一对一-1128800864.ppt\",\"status\":20},{\"coursewareId\":2003,\"coursewareName\":\"Effective+Python.编写高质量Python代码的59个有效方法.Brett+Slatkin.pdf\",\"totalPage\":228,\"currentPage\":1,\"indexUrl\":\"https://cdn.lingo-ace.com/cwtest/1925096369/tmp/Effective+Python.编写高质量Python代码的59个有效方法.Brett+Slatkin-442644386/Effective+Python.编写高质量Python代码的59个有效方法.Brett+Slatkin-442644386-\",\"type\":\"pdf\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925096369Effective+Python.编写高质量Python代码的59个有效方法.Brett+Slatkin-442644386.pdf\",\"status\":20},{\"coursewareId\":2002,\"coursewareName\":\"19250963771925097271COCOS课件-第一单元第2课《我的爷爷奶奶》-1736676695-1078176354.zip\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"https://cdn.lingo-ace.com/cwtest/1925096369/tmp/19250963771925097271COCOS课件-第一单元第2课《我的爷爷奶奶》-1736676695-1078176354-5593917/index.html\",\"type\":\"cocos\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/192509636919250963771925097271COCOS课件-第一单元第2课《我的爷爷奶奶》-1736676695-1078176354-5593917.zip\",\"status\":20},{\"coursewareId\":2001,\"coursewareName\":\"识字手-1244256834.mp4\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"\",\"type\":\"video\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925096369识字手-1244256834-481314555.mp4\",\"status\":20},{\"coursewareId\":2000,\"coursewareName\":\"高级版L2-59狐假虎威-上一对一.pptx\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"xS6tW9ErQlJINBXp\",\"type\":\"ppt\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925096369高级版L2-59狐假虎威-上一对一-887583515.pptx\",\"status\":20},{\"coursewareId\":1995,\"coursewareName\":\"WX20210908-181545@2x.png\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"\",\"type\":\"image\",\"originUrl\":\"https://dev.cdn.lingoace.com/cwtest/media/1925096369WX20210908-181545@2x-463583101.png\",\"status\":20},{\"coursewareId\":1982,\"coursewareName\":\"WX20210908-181545@2x.png\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"\",\"type\":\"image\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925096370WX20210908-181545@2x-542305132.png\",\"status\":20},{\"coursewareId\":1976,\"coursewareName\":\"COCOS课件-第六单元单元第23课龟沙岛.zip\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"https://cdn.lingo-ace.com/cwtest/1925096370/tmp/COCOS课件-第六单元单元第23课龟沙岛-1283459067/index.html\",\"type\":\"cocos\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925096370COCOS课件-第六单元单元第23课龟沙岛-1283459067.zip\",\"status\":20},{\"coursewareId\":1965,\"coursewareName\":\"u3复习课.zip\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"https://cdn.lingo-ace.com/cwtest/1925096375/tmp/u3复习课-839619165/index.html\",\"type\":\"cocos\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925096375u3复习课-839619165.zip\",\"status\":20},{\"coursewareId\":1929,\"coursewareName\":\"PPT课件-L4-69《三个和尚》上.pptx\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"RNCpMtWAnswoGjjL\",\"type\":\"ppt\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925097269PPT课件-L4-69《三个和尚》上-289203262.pptx\",\"status\":20},{\"coursewareId\":1945,\"coursewareName\":\"L5-1《古诗两首》上.pptx\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"u4pWw9ibzUcUyAK0\",\"type\":\"ppt\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925097269L5-1《古诗两首》上-2111923173.pptx\",\"status\":20},{\"coursewareId\":1829,\"coursewareName\":\"PDF课件-L3-17-热带鱼对子歌.pdf\",\"totalPage\":9,\"currentPage\":1,\"indexUrl\":\"https://cdn.lingoace.com/cwtest/1925097271/tmp/PDF课件-L3-17-热带鱼对子歌-1218763684/PDF课件-L3-17-热带鱼对子歌-1218763684-\",\"type\":\"pdf\",\"originUrl\":\"https://cdn.lingoace.com/cwtest/1925097271PDF课件-L3-17-热带鱼对子歌-1218763684.pdf\",\"status\":20},{\"coursewareId\":499,\"coursewareName\":\"单机房架构.png\",\"totalPage\":0,\"currentPage\":1,\"indexUrl\":\"\",\"type\":\"image\",\"originUrl\":\"https://cdn.lingoace.com/cw/1925101146单机房架构-1055476596.png\",\"status\":20}]}}"
//        );
    }

    public void jumpToThirdActivity(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }

    public void jumpToSecondActivity(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void jumpToFourthActivity(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}