package com.example.day2017831_fragmentadapter.api;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface LoadingListener extends OnResponseListener {
    void onLoading(long total, long progress);
}
