package com.wd.tech.data;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * @Author: zhang
 * @Date: 2019/6/9 19:22
 * @Description:
 */
public class BaseFragment extends Fragment {

    protected <T extends View > T bindView(int resId){
        return (T) getView().findViewById(resId);
    } //绑定某个特定的视图

    protected <T extends View> T bindView(View view ,int resId){
        return (T) view.findViewById(resId);
    }

    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
    public void showIntent(Class aClass){
        Intent intent = new Intent(getActivity(),aClass);
        startActivity(intent);
    }
}
