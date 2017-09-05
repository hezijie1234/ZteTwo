package com.example.day2017831_fragmentadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.day2017831_fragmentadapter.api.OnResponseListener;

import org.json.JSONObject;

/**
 * Created by zte on 2017/8/31.
 */

public class FragmentFour extends BaseFragment implements OnResponseListener {
    private TextView textView;
    private static FragmentFour fragmentFour;

    public static FragmentFour getInstance(){
        if (fragmentFour == null){
            synchronized (FragmentFour.class){
                if (fragmentFour == null){
                    fragmentFour = new FragmentFour();
                }
            }
        }
        return fragmentFour;
    }
    @Override
    public View getView(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.fragment_four,parent,false);
    }

    @Override
    public void initView(View view) {
        textView = (TextView) view.findViewById(R.id.fragment_four_text);
    }

    @Override
    public void onUserVisible(boolean b) {

    }

    @Override
    public void onAPISuccess(String flag, JSONObject json) {

    }

    @Override
    public void onAPIError(String flag, int code, String error) {

    }
}
