package com.wd.tech.data;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wd.tech.net.NetWork;
import com.wd.tech.service.NetBroadcastReceiver;
import com.wd.tech.view.RegisterActivity;

/**
 * @Author: zhang
 * @Date: 2019/5/19 13:09
 * @Description:
 */
public class BaseActivity extends AppCompatActivity implements NetBroadcastReceiver.NetChangeListener {
    public static NetBroadcastReceiver.NetChangeListener even;
    private int netType;
    private NetBroadcastReceiver netBroadcastReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //StatusBarCompat.setStatusBarColor(this, color, lightStatusBar);
        even = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //实例化IntentFilter对象
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            netBroadcastReceiver = new NetBroadcastReceiver();
            //注册广播接收
            registerReceiver(netBroadcastReceiver, filter);
        }
        checkNet();
    }

    public boolean checkNet(){
        this.netType = NetWork.getNetWorkState(BaseActivity.this);
        if (!isNetConnect()){
            Toast.makeText(this,"无网络连接",Toast.LENGTH_SHORT).show();
        }
        return isNetConnect();
    }
    public boolean isNetConnect(){
        if (netType == 1){
            return true;
        }else if (netType == 0){
            return true;
        }else if (netType == -1){
            return false;
        }
        return false;
    }

    @Override
    public void onChangeListener(int netMobile) {
        this.netType = netMobile;
        if (!isNetConnect()) {
            Toast.makeText(this,"无网络连接",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"网络已连接",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (netBroadcastReceiver != null) {
            unregisterReceiver(netBroadcastReceiver);
        }
    }
    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    public void showIntent(Class aClass){
        Intent intent = new Intent(this,aClass);
        startActivity(intent);
    }
    protected  < T extends View > T bindView(int resId){
        return (T) findViewById(resId);
    }

}
