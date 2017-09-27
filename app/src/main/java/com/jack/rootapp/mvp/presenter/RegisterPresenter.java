package com.jack.rootapp.mvp.presenter;

import com.jack.rootapp.base.BasePresenter;
import com.jack.rootapp.mvp.model.RegisterModel;
import com.jack.rootapp.mvp.model.imodel.IRegisterModel;
import com.jack.rootapp.mvp.view.iview.IRegisterView;

/**
 * Created by Administrator on 2017-09-27.
 */

public class RegisterPresenter implements BasePresenter<IRegisterView>{

    private IRegisterModel mIModel;
    private IRegisterView mIView;
    private boolean isLoad = true;//循环加载标志

    public RegisterPresenter(IRegisterView iView){
        this.mIView=iView;
        mIModel=new RegisterModel();//这里
    }

    public void doRegister(String name,String pwd){
        boolean isRegister=mIModel.onRegister(name,pwd);
        if (isRegister){
            mIView.onRegisterSucceed();
        }else {
            mIView.onRegisterFaild();
        }
    }



}
