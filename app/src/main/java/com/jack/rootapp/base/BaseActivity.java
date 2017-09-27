package com.jack.rootapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;
import com.jack.rootapp.common.bus.Event;
import com.jack.rootapp.common.bus.EventBusManager;
import com.jack.rootapp.common.utils.KeyBoardUtil;


import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017-07-11.
 */

public abstract class BaseActivity extends AppCompatActivity {


    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResId());
        unbinder= ButterKnife.bind(this);
        ActivityCollector.addActivity(this);
        KeyBoardUtil.assistActivity(this);
        if (isRegisterEventBus()) {
            EventBusManager.register(this);
        }
        init(savedInstanceState);
    }

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    public abstract int getContentResId();
    public abstract void init(Bundle savedInstanceState);


    @Override
    protected void onRestart() {
        super.onRestart();
        //Log.d()
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        ActivityCollector.removeActivity(this);
        if (isRegisterEventBus()) {
            EventBusManager.unregister(this);
        }
    }


    /**
     * EventBus相关
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(Event event) {

    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(Event event) {

    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("SplashScreen");
        MobclickAgent.onResume(this);

    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("SplashScreen");
        MobclickAgent.onPause(this);
    }

}
