package com.jack.rootapp.common.utils;

import android.content.Context;
import android.telephony.TelephonyManager;


import com.jack.rootapp.base.ThisApplication;

import java.util.UUID;

/**
 * Created by Administrator on 2017-09-12.
 */

public class TokenUtils {


    public static String getAPPID(){
        // 方法3
        final TelephonyManager tm = (TelephonyManager) ThisApplication.getApplication().getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(ThisApplication.getContext().getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        return deviceUuid.toString().replace("-","");

    }
}
