package com.example.sxshi.testpatch;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

/**
 * Created by sxshi on 2018-1-2.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 解决FileProvider的问题 Android7.0
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
    }
}
