package com.zte.day1navigationview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

public class SmartRefreshLayout extends AppCompatActivity {
    private RefreshLayout smartRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh_layout);
        smartRefreshLayout = (RefreshLayout) findViewById(R.id.activity_smart_refresh_layout);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                smartRefreshLayout.finishRefresh(0);
            }
        });
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                smartRefreshLayout.finishLoadmore(0);
            }
        });
        smartRefreshLayout.setReboundDuration(100);

    }
}
