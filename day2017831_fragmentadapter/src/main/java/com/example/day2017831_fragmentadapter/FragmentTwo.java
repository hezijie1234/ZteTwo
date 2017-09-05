package com.example.day2017831_fragmentadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zte on 2017/8/31.
 */

public class FragmentTwo extends BaseFragment {

    private static FragmentTwo fragmentTwo;

    public static FragmentTwo getInstance(){
        if(fragmentTwo == null){
            synchronized (FragmentTwo.class){
                if (fragmentTwo == null){
                    fragmentTwo = new FragmentTwo();
                }
            }
        }
        return fragmentTwo;
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.fragment_two,parent,false);
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void onUserVisible(boolean b) {

    }
}
