package com.jack.rootapp.mvp.view.iview;

/**
 * Created by Administrator on 2017-09-27.
 */

public interface IRegisterView {

    boolean checkInputInfo();  //检查输入的合法性
    void onRegisterSucceed();  //注册成功
    void onRegisterFaild();    //注册失败


}
