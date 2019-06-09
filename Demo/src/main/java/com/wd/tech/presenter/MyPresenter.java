package com.wd.tech.presenter;

import com.wd.tech.bean.LoginBean;
import com.wd.tech.bean.PostBean;
import com.wd.tech.data.Content;
import com.wd.tech.model.MyModel;
import com.wd.tech.mvp.MyInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhang
 * @Date: 2019/5/9 16:02
 * @Description:
 */
public class MyPresenter<T> implements MyInterface.PresenterInter{
    MyInterface.ModelInter modelInter;
    T tt;
    private final Map<String, String> map;

    public MyPresenter(T tt) {
        this.tt = tt;
        map = new HashMap<>();
        modelInter = new MyModel();
    }

    @Override
    public void toCommunity(int page, int count) {
        map.put("page", String.valueOf(page));
        map.put("count", String.valueOf(count));
        modelInter.doGet(Content.Community, null, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {

            }
        });
    }

    @Override
    public void toLogin(String phone, String pwd) {
        final MyInterface.ViewInter.LoginInter loginInter = (MyInterface.ViewInter.LoginInter) tt;
        map.put("phone",phone);
        map.put("pwd",pwd);
        modelInter.doPost(Content.Login, LoginBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                loginInter.showLogin(object);
            }
        });
    }

    @Override
    public void toRegister(String name,String phone, String pwd) {
        final MyInterface.ViewInter.RegisterInter loginInter = (MyInterface.ViewInter.RegisterInter) tt;
        map.put("phone",phone);
        map.put("nickName",name);
        map.put("pwd",pwd);
        modelInter.doPost(Content.Register, PostBean.class, map, new MyModel.MyCallBack() {
            @Override
            public void success(Object object) {
                loginInter.showRegister(object);
            }
        });
    }

    @Override
    public void onDestroy() {
        if (tt != null){
            tt = null;
        }
    }
}
