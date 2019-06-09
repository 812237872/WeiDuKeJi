package com.wd.tech.net;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * @Author: zhang
 * @Date: 2019/5/9 16:15
 * @Description:
 */
public class NetWork {
    //没网
    private static final int NETWORK_NONE = -1;
    //移动网络
    private static final int NETWORK_MOBILE = 0;
    //无线
    private static final int NETWORK_WIFI = 1;

    public static int getNetWorkState(Context context) {
        //得到连接管理器对象
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        //如果网络连接，判断该网络类型
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_WIFI)) {
                return NETWORK_WIFI;//wifi
            } else if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_MOBILE)) {
                return NETWORK_MOBILE;//mobile
            }
        } else {
            //网络异常
            return NETWORK_NONE;
        }
        return NETWORK_NONE;
    }
}
