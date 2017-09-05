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

public class FragmentThree extends BaseFragment {
    private static FragmentThree fragmentThree;

    public static FragmentThree getInstance(){
        if (fragmentThree == null){
            synchronized (FragmentThree.class){
                if (fragmentThree == null){
                    fragmentThree = new FragmentThree();
                }
            }
        }
        return fragmentThree;
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.fragment_three,parent,false);
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void onUserVisible(boolean b) {

    }

}
