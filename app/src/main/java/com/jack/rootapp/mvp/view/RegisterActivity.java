package com.jack.rootapp.mvp.view;

import android.os.Bundle;
import android.widget.EditText;

import com.jack.rootapp.R;
import com.jack.rootapp.base.BaseActivity;
import com.jack.rootapp.common.utils.ToastUtils;
import com.jack.rootapp.mvp.presenter.RegisterPresenter;
import com.jack.rootapp.mvp.view.iview.IRegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017-09-27.
 */

public class RegisterActivity extends BaseActivity implements IRegisterView{

    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_user_pwd)
    EditText etUserPwd;
    private RegisterPresenter mPresenter;
    private String inputName,inputPwd;
    @Override
    public int getContentResId() {
        return R.layout.activity_register;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        mPresenter=new RegisterPresenter(this);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        if (checkInputInfo()){
            mPresenter.doRegister(inputName,inputPwd);
        }


    }

    @Override
    public boolean checkInputInfo() {
        inputName=etUserName.getText().toString().trim();
        inputPwd=etUserPwd.getText().toString().trim();
        if (inputName.equals("")){
            ToastUtils.showCenter("用户名不能为空");
            return false;
        }

        if (inputPwd.equals("")){
            ToastUtils.showCenter("密码不能为空");
            return false;
        }
        return true;
    }

    @Override
    public void onRegisterSucceed() {
        ToastUtils.showCenter("登录成功");
    }

    @Override
    public void onRegisterFaild() {
        ToastUtils.showCenter("登录失败");
    }
}
