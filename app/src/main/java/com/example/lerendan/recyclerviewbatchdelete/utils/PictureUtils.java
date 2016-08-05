package com.example.lerendan.recyclerviewbatchdelete.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.Log;

/**
 * Created by lerendan on 2016/8/5.
 */

public class PictureUtils {

    private static final String TAG = "bitmap-";


    public  static Bitmap getScaleBitmap(String path,int destWidth,int destHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path,options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        int inSampleSize = 1;
        if(srcHeight>destHeight||srcWidth>destWidth){
            if (srcWidth>srcHeight) {
                inSampleSize = Math.round(srcHeight/destHeight);
            }else {
                inSampleSize = Math.round(srcWidth/destWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        return BitmapFactory.decodeFile(path,options);
    }
    public  static Bitmap getScaleBitmap(String path, Activity activity){
        Point size= new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return getScaleBitmap(path,size.x,size.y);
    }




    /**
     * 谷歌推荐使用方法，从资源中加载图像，并高效压缩，有效降低OOM的概率
     * @param res 资源
     * @param resId 图像资源的资源id
     * @param reqWidth 要求图像压缩后的宽度
     * @param reqHeight 要求图像压缩后的高度
     * @return
     */
    public Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        // 设置inJustDecodeBounds = true ,表示获取图像信息，但是不将图像的像素加入内存
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // 调用方法计算合适的 inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);

        // inJustDecodeBounds 置为 false 真正开始加载图片
        options.inJustDecodeBounds = false;
        //将options.inPreferredConfig改成Bitmap.Config.RGB_565，
        // 是默认情况Bitmap.Config.ARGB_8888占用内存的一般
        options.inPreferredConfig= Bitmap.Config.RGB_565;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    // 计算 BitmapFactpry 的 inSimpleSize的值的方法
    public int calculateInSampleSize(BitmapFactory.Options options,
                                     int reqWidth, int reqHeight) {
        if (reqWidth == 0 || reqHeight == 0) {
            return 1;
        }

        // 获取图片原生的宽和高
        final int height = options.outHeight;
        final int width = options.outWidth;
        Log.d(TAG, "origin, w= " + width + " h=" + height);
        int inSampleSize = 1;

        // 如果原生的宽高大于请求的宽高,那么将原生的宽和高都置为原来的一半
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // 主要计算逻辑
            // Calculate the largest inSampleSize value that is a power of 2 and
            // keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        Log.d(TAG, "sampleSize:" + inSampleSize);
        return inSampleSize;
    }

}
