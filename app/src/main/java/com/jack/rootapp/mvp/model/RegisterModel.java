package com.jack.rootapp.mvp.model;

import com.jack.rootapp.mvp.model.imodel.IRegisterModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-09-27.
 */

public class RegisterModel implements IRegisterModel{

    //简单的存一下注册的账号
    private Map<String, String> personMap = new HashMap<>();


    @Override
    public boolean onRegister(String name, String pwd) {

        if (!personMap.containsKey(name)) {
            personMap.put(name, pwd);
            return true;
        }

        return false;
    }
}
