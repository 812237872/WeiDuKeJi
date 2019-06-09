package com.wd.tech.mvp;

import com.wd.tech.model.MyModel;

import java.util.Map;

/**
 * @Author: zhang
 * @Date: 2019/5/9 19:09
 * @Description:
 */
public interface MyInterface {
    interface ModelInter{
        void doGet(String url,Class cls, Map<String,String> map, MyModel.MyCallBack myCallBack);
        void doPost(String url,Class cls ,Map<String,String> map, MyModel.MyCallBack myCallBack);
    }
    interface PresenterInter{
        //社区列表
        void toCommunity(int page,int count);
        void toLogin(String phone,String pwd);
        void toRegister(String name,String phone,String pwd);
        void onDestroy();
    }
    interface ViewInter{
        interface LoginInter{
            void showLogin(Object object);
        }
        interface RegisterInter{
            void showRegister(Object object);
        }
    }
}
