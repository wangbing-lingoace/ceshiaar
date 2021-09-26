package com.example.javaceshi;

import android.app.Application;
import android.util.Log;



public class MyApplication extends Application {
    public static Application mcontext;
    @Override
    public void onCreate() {
        super.onCreate();
        mcontext=this;
        Log.e("---------", "MyApplication onCreate: ");
    }
}
