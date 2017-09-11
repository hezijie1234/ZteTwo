package com.example.day20170905_guideview;

import android.content.Context;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhl.userguideview.UserGuideView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private UserGuideView guideView;
    private  ImageView icon;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icon = (ImageView) findViewById(R.id.icon);
        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        guideView = (UserGuideView) findViewById(R.id.guideView);
        //设置点击其他区域提示框不消失。
        guideView.setTouchOutsideDismiss(true);
        guideView.setHighLightView(textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                String operator = manager.getNetworkOperator();
                //移动国家代码（中国的为460）；
//                int mcc = Integer.parseInt(operator.substring(0,3));
                //移动网络号码（中国移动为0，中国联通为1，中国电信为2）；
//                int mnc = Integer.parseInt(operator.substring(3));
                // 中国移动和中国联通获取LAC、CID的方式
                // LAC，Location Area Code，位置区域码；
                //CID，Cell Identity，基站编号；
                GsmCellLocation cellLocation = (GsmCellLocation) manager.getCellLocation();
                int lac = cellLocation.getLac();
                int cellId = cellLocation.getCid();

//                CdmaCellLocation location = (CdmaCellLocation) manager.getCellLocation();
//                int lac = location.getNetworkId();
//                int cellId = location.getBaseStationId();
                String hex = Integer.toHexString(cellId);
                Log.e("111", "onClick: " + cellId );
                textView.setText("十进制Cid：" + cellId + "，十六进制Cid" + hex);
            }
        });

//        icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                guideView.setHighLightView(icon);
//            }
//        });

    }
}
