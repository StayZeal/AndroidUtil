package co.gofun.android.library.util;

import android.content.Context;

/**
 * - @Description:
 * //todo 复用
 * - @Time:  2020/8/3 15:14
 */
public class CpuUtil {

    public static String getNativeLibEnvDirs(String nativeLibPath) {
        if (isArm64(nativeLibPath)) {
            return "/system/lib64/:/vendor/lib64/:" + nativeLibPath;
        }
        return "/system/lib/:/vendor/lib/:" + nativeLibPath;
    }

    /**
     * @param context not null
     * @return
     */
    public static boolean isArm64(Context context) {
        //todo 没有native代码的apk是否有这个路径。
        String nativeLibPath = context.getApplicationInfo().nativeLibraryDir;
        return isArm64(nativeLibPath);
    }

    /**
     * @param nativeLibPath not null
     * @return
     */
    public static boolean isArm64(String nativeLibPath) {
        if (nativeLibPath.contains("/lib/arm64")) {
            return true;
        }
        return false;
    }
}
