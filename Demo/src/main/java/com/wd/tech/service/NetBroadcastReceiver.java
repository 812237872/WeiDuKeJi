package com.wd.tech.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.wd.tech.data.BaseActivity;
import com.wd.tech.net.NetWork;

/**
 * @Author: zhang
 * @Date: 2019/5/18 9:54
 * @Description:
 */
public class NetBroadcastReceiver extends BroadcastReceiver {
    public NetChangeListener even = BaseActivity.even;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION));{
            int state = NetWork.getNetWorkState(context);
            if (even != null){
                even.onChangeListener(state);
            }
        }
    }

    public interface NetChangeListener{
        void onChangeListener(int netMobile);
    }
}
