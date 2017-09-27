package com.jack.rootapp.common.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;


/**
 * 定时器工具类
 * Created by PersonalFolder on 16/11/2.
 */
public class TickerUtils extends CountDownTimer {

    private TextView tView;


    public TickerUtils(long millisInFuture, long countDownInterval, TextView tView) {
        super(millisInFuture, countDownInterval);
        this.tView=tView;
    }

    @Override
    public void onFinish() {// 计时完毕
        tView.setText("获取验证码");
        tView.setTextColor(Color.RED);
        //tView.setBackgroundResource(R.drawable.thirdlogin_btn1_bg);
        tView.setClickable(true);
    }

    @Override
    public void onTick(long millisUntilFinished) {// 计时过程
        tView.setClickable(false);//防止重复点击
        tView.setText("重新获取"+millisUntilFinished / 1000);
        tView.setTextColor(Color.GRAY);
        //tView.setBackgroundResource(R.drawable.thirdlogin_btn2_bg);
    }
}
