package com.example.day2017831_fragmentadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zte on 2017/8/31.
 */

public abstract class BaseFragment extends Fragment {
    //判断是否是第一次可见
    private boolean isFirstVisible = true;
    //是否第一次调用resume
    private boolean isFirstResume = false;

    public static final String url = "http://api.daoway.cn/daoway/rest/indexEvent/all?city=%E6%AD%A6%E6%B1%89&market=false&version=v2&serviceMinLimit=4&type=all&marketMinLimit=2&udid=133524447081935&appVersion=4.9.2";
    public static final String tag = "rest/indexEvent/all?city=%E6%AD%A6%E6%B1%89&market=false&version=v2&serviceMinLimit=4&type=all&marketMinLimit=2&udid=133524447081935&appVersion=4.9.2";
    /*
    * 初始化布局文件
    * */
    public abstract View getView(LayoutInflater inflater, ViewGroup parent);

    /*
    * 初始化控件
    *
    * */
    public abstract void initView(View view);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = getView(inflater, container);
        initView(view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
           setUserVisible();
        }
    }

    private void setUserVisible() {
        if (isFirstVisible){
            isFirstVisible = false;
            onUserVisible(true);
        }else {
            onUserVisible(false);
        }
    }

    public abstract void onUserVisible(boolean b);

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstResume){
            isFirstResume = false;
        }
        if (getUserVisibleHint()){
            onUserVisible(false);
        }
    }
}
