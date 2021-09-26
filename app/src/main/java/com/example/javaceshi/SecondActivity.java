package com.example.javaceshi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import com.example.javaceshi.luckyoan.LunckyPan;

import org.reactivestreams.Subscriber;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SecondActivity extends AppCompatActivity {

    private LunckyPan lunckyPan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lunckyPan = findViewById(R.id.pan);
    }

    public void startPan(View v) {
        lunckyPan.luckyStart(1);
    }

    public void endPan(View v) {
        lunckyPan.luckyEnd();
    }

    public void clickbutton(View view) {

    }
}