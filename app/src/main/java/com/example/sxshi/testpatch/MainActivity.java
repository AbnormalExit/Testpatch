package com.example.sxshi.testpatch;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "ssx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ApkUtils.getVersionCode(this, getPackageName()) < 2.0) {
            Log.d(TAG, "不是最新的版本号 开始更新 ");
            new ApkUpdateTask().execute();
        } else {
            Log.d(TAG, " 最新版本号 无需更新");
        }
    }

    class ApkUpdateTask extends AsyncTask<Void, Void, Boolean> {


        @Override
        protected Boolean doInBackground(Void... params) {

            Log.d(TAG, "开始下载 。。。");

            File patchFile = DownLoadUtils.download(Contants.URL_PATCH_DOWNLOAD);
            Log.d(TAG, "下载完成 。。。");

            String oldfile = ApkUtils.getSourceApkPath(MainActivity.this, getPackageName());

            String newFile = Contants.NEW_APK_PATH;

            String patchFileString = patchFile.getAbsolutePath();

            Log.d(TAG, "开始合并");
            int ret = Bspatch.patch(oldfile, newFile, patchFileString);
            Log.d(TAG, "开始完成");

            if (ret == 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (aBoolean) {
                Log.d(TAG, "合并成功 开始安装新apk");
                ApkUtils.installNormal(MainActivity.this, Contants.NEW_APK_PATH);
            }
        }
    }
}
