package com.example.day2017831_fragmentadapter.api;

import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

public class ResultParser implements CallbackWrapper.OnHttpListener {

    private String flag;
    private OnResponseListener listener;

    public ResultParser(String flag, OnResponseListener listener) {
        this.flag = flag;
        this.listener = listener;
    }

    @Override
    public void onHttpFailure(int code, String error) {
        String fileName = "http" + System.currentTimeMillis() + ".log";
            String path = Environment.getExternalStorageDirectory()+"/Jingwutong/log/";
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path + fileName);
            fos.write(error.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (listener != null) {
            Log.i("111", code + "-" + error);
            listener.onAPIError(flag, code, "网络请求失败");
        }
    }

    @Override
    public void onHttpSuccess(int code, String result) {
        if (listener != null) {
            try {
//                if(code == 200 && !TextUtils.isEmpty(result)){
//                    listener.onAPISuccess(flag, result);
//                }else{
//                    listener.onAPIError(flag, ErrorEvent.DATA_IS_EMPTY, "数据返回失败");
//                }
                if (TextUtils.isEmpty(result)) {
                    listener.onAPIError(flag, ErrorEvent.DATA_IS_EMPTY, "数据为空");
                    return;
                }

                JSONObject jsonObject = new JSONObject(result);
                String state = jsonObject.optString("c");
//                if(flag.equals(ApiImpl.TRANSLATE_LIST)){
//                    listener.onAPISuccess(flag, jsonObject);
//                }
                if (Integer.parseInt(state) == 0) {
                    listener.onAPISuccess(flag, jsonObject);
                } else if(Integer.parseInt(state) == 1001){
//                    OkHttpManager.getInstance().deleteCookie();
//                    Intent intent = new Intent(MyApplication.getContext(), LoginActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                    MyApplication.getContext().startActivity(intent);
                } else {
                    String msg = jsonObject.optString("m");
                    listener.onAPIError(flag, Integer.parseInt(state), msg);
                }
            } catch (JSONException e) {
                listener.onAPIError(flag, ErrorEvent.PARSE_DATA_FAILURE, "数据解析失败");
                e.printStackTrace();
            }
        }

    }
}
