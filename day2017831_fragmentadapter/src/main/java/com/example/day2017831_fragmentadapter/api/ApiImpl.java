package com.example.day2017831_fragmentadapter.api;

import android.text.TextUtils;
import android.util.Log;

import com.example.day2017831_fragmentadapter.BaseFragment;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by ml on 2016/9/2.
 */
public class ApiImpl {
    //    public static final String DOMIN = "http://192.168.0.248:8080";
//    public static final String DOMIN = "http://192.168.1.251:8080";
//    public static final String DOMIN = "http://121.42.178.20:7080/idcheck";
//    public static final String DOMIN = "http://ztesai.3322.org:8800/idcheck";
    //测试
//    public static final String HOST = "http://192.168.1.19:8080";
    //杨磊
//    public static final String HOST = "http://192.168.1.252:8080";
//    public static final String HOST = "http://ztesai.3322.org:8800";
    //四川
//    public static final String HOST = "http://192.168.3.30:8080";
//    public static final String HOST = "http://192.168.1.223:8080";
    //四川演示。
//    public static final String HOST = "http://17k971960n.iask.in:17850";

    public static final String HOST = "http://www.ztesai.3322.org:8002/";
    public static final String DOMIN = HOST + "/idcheck/";


//    public static final String DOMIN = "http://192.168.0.249:8080/idcheck/";

    private static ApiImpl instance = new ApiImpl();

    private ApiImpl() {
    }

    public static ApiImpl getInstance() {
        return instance;
    }

    public static final String DO_LOGIN = "/api/account/login";
    public static final String FACE_LOGIN = "/api/account/faceLogin";
    public static final String FACE_LOGIN_CONFIRM = "/api/account/faceLoginConfirm";
    public static final String DO_LOGOUT = "/api/account/logout";
    public static final String MODIFY_PWD = "/api/account/change/password";
    public static final String UPDATE_HEAD = "/api/account/update/head";
    public static final String GET_USER_INFO = "/api/account/get/info";
    public static final String GET_CHECK_LIST = "/api/mobile/idcheckAlarm/list";
    public static final String GET_CHECK_DETAIL = "/api/mobile/idcheckAlarm/detail";
    public static final String GET_EMERGENCY_LIST = "/api/mobile/idcheckEmergencyDeploy/list";
    public static final String GET_EMERGENCY_DETAIL = "/api/mobile/notice/detail";
    public static final String GET_NOTICE_LIST = "/api/mobile/notice/list";
    public static final String GET_NOTICE_DETAIL = "/api/mobile/notice/detail";
    public static final String GET_CONTACTS_LIST = "/api/mobile/idcheckContacts/list";
    public static final String CHECK_VERSION = "/api/mobile/new/version";
    public static final String HANDLE_EMERGENCY = "/api/mobile/idcheckAlarmcheckRet/add";
    public static final String HANDLE_EMERGENCY_PIC = "/api/mobile/idcheckAlarmcheckRetImage/add";
    public static final String HANDLE_EMERGENCY_RESULT = "/api/mobile/idcheckAlarmcheckRet/get";
    public static final String SEARCH_CHECK_LIST = "/api/mobile/idcheckAlarm/search";
    public static final String FACE_DETECT = "/api/mobile/faceDetect/check";
    public static final String FACE_SCAN = "/api/mobile/criminalSuspectDetect/check";
    public static final String APK_DOWNLOAD = DOMIN + "/api/mobile/download/apk?path=";
    public static final String BLACK_TYPE = "api/mobile/blackList";
    public static final String TEMPLATE_UPLOAD = "api/mobile/saveCriminalSuspect";
    //嫌犯扫描和人证核验的记录
    public static final String RECONG_SCAN_RECORD = "api/mobile/log/check";
    //模板录入的记录
    public static final String BLACK_LIST = "api/mobile/log/blacklist";
    public static final String WARN_NUM = "api/mobile/alarm/count";
    //转发人员获取
    public static final String TRANSLATE_LIST = "api/mobile/query/user";
    //转发
    public static final String TRANSLATE = "api/mobile/alarm/forward";
    public static final String SECURITY_CHECK = "api/mobile/security/dict";
    public static final String SECURITY_SEND = "api/mobile/security/add";
    public void faceLogin(String deviceId, String imageName, String imageStr, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("deviceId", deviceId);
        builder.add("imageName", imageName);
        builder.add("imageStr", imageStr);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + FACE_LOGIN, body, new ResultParser(FACE_LOGIN, listener));
    }

    public void faceLoginConfirm(String loginName, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        Log.e("111", "faceLoginConfirm: "+loginName );
        builder.add("account", loginName);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + FACE_LOGIN_CONFIRM, body, new ResultParser(FACE_LOGIN_CONFIRM, listener));
    }


    /**
     * 登录
     *
     * @param listener
     */
    public void doLogin(String account, String password, String deviceId, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("account", account);
        builder.add("password", password);
        if (!TextUtils.isEmpty(deviceId)) {
            builder.add("deviceId", deviceId);
        }
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + DO_LOGIN, body, new ResultParser(DO_LOGIN, listener));
    }

    /**
     * 修改密码
     *
     * @param listener
     */
    public void modifyPwd(String old_pwd, String new_pwd, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("old_pwd", old_pwd);
        builder.add("new_pwd", new_pwd);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + MODIFY_PWD, body, new ResultParser(MODIFY_PWD, listener));
    }

    public void transmitEmergency(String id, String receives, OnResponseListener listener){
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("alarmId", id);
        builder.add("receivers", receives);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + TRANSLATE, body, new ResultParser(TRANSLATE, listener));
    }

    public void securitySend(String station, String time, String way, String company, String state, OnResponseListener listener){
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("station", station);
        builder.add("passWay", way);
        builder.add("company", company);
        builder.add("createDate", time);
        builder.add("state", state);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + SECURITY_SEND, body, new ResultParser(SECURITY_SEND, listener));
    }

    /**
     * 更新头像
     *
     * @param listener
     */
    public void updateHead(File image, OnResponseListener listener) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MediaType.parse("multipart/form-data"));
        builder.addFormDataPart("image", image.getName(), RequestBody.create(MediaType.parse("image/png"), image));
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + UPDATE_HEAD, body, new ResultParser(UPDATE_HEAD, listener));
    }





    /**
     * 获取用户信息
     *
     * @param listener
     */
    public void getUserInfo(OnResponseListener listener) {
        OkHttpManager.getInstance().get(DOMIN + GET_USER_INFO, new ResultParser(GET_USER_INFO, listener));
    }

    public void getTranslateList(OnResponseListener listener){
        OkHttpManager.getInstance().get(DOMIN + TRANSLATE_LIST ,new ResultParser(TRANSLATE_LIST,listener));
    }

    /**
     * @param listener
     * 安全考核数据下载
     */
    public void securityCheck(OnResponseListener listener){
        OkHttpManager.getInstance().get(DOMIN + SECURITY_CHECK ,new ResultParser(SECURITY_CHECK,listener));
    }

    public void getData(OnResponseListener listener){
        OkHttpManager.getInstance().get("http://api.daoway.cn/daoway/" + BaseFragment.tag,new ResultParser(BaseFragment.tag,listener));
    }
    /**
     * 登出
     *
     * @param listener
     */
    public void doLogout(OnResponseListener listener) {
        OkHttpManager.getInstance().get(DOMIN + DO_LOGOUT, new ResultParser(DO_LOGOUT, listener));
    }

//    /**
//     * 获取警情列表
//     * @param listener
//     */
//    public void getCheckInfo(String page, String size,String status,OnResponseListener listener){
//        FormBody.Builder builder = new FormBody.Builder();
//        builder.add("page",page);
//        builder.add("size",size);
//        builder.add("status",status);
//        RequestBody body = builder.build();
//        OkHttpManager.getInstance().post(DOMIN+GET_CHECK_LIST,body,new ResultParser(GET_CHECK_LIST,listener));
//    }

    /**
     * 获取警情详情
     *
     * @param listener
     */
    public void getCheckDetail(String id, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("id", id);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + GET_CHECK_DETAIL, body, new ResultParser(GET_CHECK_DETAIL, listener));
    }

    /**获取最新的警情数量
     * @param userId
     * @param date
     * @param listener
     */
    public  void getWarningNum(String userId, String date, OnResponseListener listener){
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("userId",userId);
        builder.add("time",date);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN+WARN_NUM,body,new ResultParser(WARN_NUM,listener));
    }

    /**
     * 搜索警情
     *
     * @param listener
     */
    public void searchAlarmList(String keyword, String page, String size, String status, String id, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        if (!TextUtils.isEmpty(keyword)) {
            builder.add("keyword", keyword);
        }
        builder.add("pageNo", page);
        builder.add("size", size);
        builder.add("status", status);
        Log.e("111", "searchAlarmList: "+id );
        if(!TextUtils.isEmpty(id)){
            builder.add("userId", id);
        }
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + SEARCH_CHECK_LIST, body, new ResultParser(SEARCH_CHECK_LIST, listener));
    }

    /**
     * 获取紧急布控列表
     *
     * @param listener
     */
    public void getEmergencyNoticeList(String page, String size, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("page", page);
        builder.add("size", size);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + GET_EMERGENCY_LIST, body, new ResultParser(GET_EMERGENCY_LIST, listener));
    }

    /**
     * 获取紧急布控详情
     *
     * @param listener
     */
    public void getEmergencyNoticeDetail(String id, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("id", id);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + GET_EMERGENCY_DETAIL, body, new ResultParser(GET_EMERGENCY_DETAIL, listener));
    }

    /**
     * 获取公告列表
     *
     * @param listener
     */
    public void getNoticeList(String userId, String page, String size, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("userId",userId);
        builder.add("page", page);
        builder.add("size", size);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + GET_NOTICE_LIST, body, new ResultParser(GET_NOTICE_LIST, listener));
    }

    /**
     * 获取公告详情
     *
     * @param listener
     */
    public void getNoticeDetail(String id, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("id", id);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + GET_NOTICE_DETAIL, body, new ResultParser(GET_NOTICE_DETAIL, listener));
    }

    /**
     * 获取联系人列表
     *
     * @param listener
     */
    public void getContactsList(OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("page", "1");
        builder.add("size", "1000000");
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + GET_CONTACTS_LIST, body, new ResultParser(GET_CONTACTS_LIST, listener));
    }

    /**
     * 订阅号详情
     *
     * @param listener
     */
    public void checkVersion(OnResponseListener listener) {
        StringBuilder sb = new StringBuilder();
        sb.append("device");
        sb.append("=");
        sb.append("1");
        sb.append("&");
        String url = "?" + sb.toString();
        OkHttpManager.getInstance().get(DOMIN + CHECK_VERSION + url, new ResultParser(CHECK_VERSION, listener));
    }

    /**
     * 处理警情
     *
     * @param listener
     */
    public void handlerEmergency(String id, File video, String comments, LoadingListener listener) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("id", id);
        if (!TextUtils.isEmpty(comments)) {
            builder.addFormDataPart("comments", comments);
        }
        RequestBody body;
        if (video != null) {
            builder.addFormDataPart("video", video.getName(), RequestBody.create(MediaType.parse("video/*"), video));
            body = builder.build();
            body = new FileRequestBody(body,listener);
        }else{
            body = builder.build();
        }
        OkHttpManager.getInstance().post(DOMIN + HANDLE_EMERGENCY, body, new ResultParser(HANDLE_EMERGENCY, listener));
    }

    /**
     * 处理警情图片
     *
     * @param listener
     */
    public void handlerEmergencyPic(String id, File image, OnResponseListener listener) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("id", id);
        if (image != null) {
            builder.addFormDataPart("image", image.getName(), RequestBody.create(MediaType.parse("image/*"), image));
        }
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + HANDLE_EMERGENCY_PIC, body, new ResultParser(HANDLE_EMERGENCY_PIC, listener));
    }

    /** 模板上传
     * @param id
     *
     * @param name
     * @param type
     * @param listener
     */
    public void templatePicSend(String id, String imageString, String name, String type, OnResponseListener listener){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if(TextUtils.isEmpty(id)){
            id = "";
        }
        builder.addFormDataPart("idcard", id);
        builder.addFormDataPart("userName",name);
        builder.addFormDataPart("suspectType",type);
        builder.addFormDataPart("userImageUrl",imageString);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + TEMPLATE_UPLOAD,body,new ResultParser(TEMPLATE_UPLOAD,listener));
    }

    public void getBlackType(OnResponseListener listener){
        OkHttpManager.getInstance().get(DOMIN + BLACK_TYPE , new ResultParser(BLACK_TYPE, listener));
    }

    public void getRecongRecord(Map<String,Object> params, OnResponseListener listener){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for(String key : params.keySet()){
            builder.addFormDataPart(key,params.get(key)+"");
        }
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + RECONG_SCAN_RECORD,body,new ResultParser(RECONG_SCAN_RECORD,listener));
    }
    public void getModelRecord(Map<String,Object> params, OnResponseListener listener){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for(String key : params.keySet()){
            builder.addFormDataPart(key,params.get(key)+"");
        }
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + BLACK_LIST,body,new ResultParser(BLACK_LIST,listener));
    }

    /**
     * 获得处理结果
     *
     * @param listener
     */
    public void getHandlerResult(String id, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("id", id);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + HANDLE_EMERGENCY_RESULT, body, new ResultParser(HANDLE_EMERGENCY_RESULT, listener));
    }


    /**
     * 人脸识别
     *
     * @param jsonData 上传的识别数据
     * @param listener 回调
     */
    public void
    sendFaceDetect(String jsonData, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("jsonData", jsonData);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + FACE_DETECT, body, new ResultParser(FACE_DETECT, listener));

    }


    /**
     * 嫌犯扫描
     *
     * @param jsonData
     * @param listener
     */
    public void sendFaceScan(String jsonData, OnResponseListener listener) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("jsonData", jsonData);
        RequestBody body = builder.build();
        OkHttpManager.getInstance().post(DOMIN + FACE_SCAN, body, new ResultParser(FACE_SCAN, listener));
    }

}
