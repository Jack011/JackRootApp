package com.jack.rootapp.common.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Administrator on 2017-08-15.
 */

public class MapUtil {


    public static void openBaiduMapToGuide(Context context,String storeName,double lat,double lng) {
        Intent intent = new Intent();
        //double[] location = GPSUtil.gcj02_To_Bd09(locationX , locationY);
        String url = "baidumap://map/direction?" +
                "destination=name:"+storeName+"|latlng:"+lat + "," + lng+
                "&mode=transit&sy=3&index=0&target=1";
        Uri uri = Uri.parse(url);
        //将功能Scheme以URI的方式传入data
        intent.setData(uri);
        //启动该页面即可
        context.startActivity(intent);
    }

    public static void openGaodeMapToGuide(Context context,String storeName,double lat,double lng) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        String url = "androidamap://route?sourceApplication=amap&slat="+lat+"&slon="+lng
                +"&dlat="+lat+"&dlon="+lng+"&dname="+storeName+"&dev=0&t=1";
        Uri uri = Uri.parse(url);
        //将功能Scheme以URI的方式传入data
        intent.setData(uri);
        //启动该页面即可
        context.startActivity(intent);
    }



    public static void openBrowserToGuide(Context context,String storeName,double lat,double lng) {
        String url = "http://uri.amap.com/navigation?to=" + lng + "," + lat + "," +
                storeName + "&mode=car&policy=1&src=mypage&coordinate=gaode&callnative=0";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }
}
