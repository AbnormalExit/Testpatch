package com.example.sxshi.testpatch;

/**
 * Created by Administrator on 2017/12/29 0029.
 */

public class Bspatch {
    public native static int patch(String oldfile, String newFile, String patchFile);

    static {

        System.loadLibrary("NDKBisPatch");
    }
}
