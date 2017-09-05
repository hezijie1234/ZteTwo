package com.example.day2017831_fragmentadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zte on 2017/9/1.
 */

public class FragmentOne extends BaseFragment {
    private static FragmentOne fragmentOne;

    public static FragmentOne getInstance(){
        if (fragmentOne == null){
            synchronized (FragmentOne.class){
                if (fragmentOne == null){
                    fragmentOne = new FragmentOne();
                }
            }
        }
        return fragmentOne;
    }
    @Override
    public View getView(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.fragment_one,parent,false);
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void onUserVisible(boolean b) {

    }
}
