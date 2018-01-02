/*
 * Created by 动脑科技-Tim on 17-8-18 下午9:36
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 17-8-18 下午9:36
 */

package com.example.sxshi.testpatch;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadUtils {

    /**
     * 下载差分包
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static File download(String url) {
        File file = null;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            file = new File(Environment.getExternalStorageDirectory(), Contants.PATCH_FILE);
            if (file.exists()) {
                file.delete();
            }
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setDoInput(true);
            is = conn.getInputStream();
            os = new FileOutputStream(file);
            byte[] buffer = new byte[1 * 1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
//                Log.d("ssx", String.valueOf(len));
                os.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
