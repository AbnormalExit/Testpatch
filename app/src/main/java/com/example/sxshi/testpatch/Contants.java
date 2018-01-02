/*
 * Created by 动脑科技-Tim on 17-8-18 下午9:35
 * Copyright (c) 2017. All rights reserved
 *
 * Last modified 17-8-18 下午9:35
 */

package com.example.sxshi.testpatch;


import android.os.Environment;

import java.io.File;

public class Contants {
    //http://192.168.1.6:8080/getpatch/download
    public static final String PATCH_FILE = "apk.patch";
    public static final String URL_PATCH_DOWNLOAD = "http://10.148.21.70:8080/getpatch/download";

    public static final String SD_CARD = Environment.getExternalStorageDirectory() + File.separator;

    //新版本apk的目录
    public static final String NEW_APK_PATH = SD_CARD+"update.apk";

    public static final String PATCH_FILE_PATH = SD_CARD+PATCH_FILE;
}
