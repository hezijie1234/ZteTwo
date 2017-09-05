package com.example.day2017831_fragmentadapter.api;

import org.json.JSONObject;

/**
 * Created by ml on 2016/9/2.
 */
public interface OnResponseListener {
    void onAPISuccess(String flag, JSONObject json);

    void onAPIError(String flag, int code, String error);

}
