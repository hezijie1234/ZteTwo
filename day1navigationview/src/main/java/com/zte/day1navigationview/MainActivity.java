package com.zte.day1navigationview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rance.library.ButtonData;
import com.rance.library.ButtonEventListener;
import com.rance.library.SectorMenuButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SectorMenuButton sector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sector = (SectorMenuButton) findViewById(R.id.sector);
        final List<ButtonData> buttonDatas = new ArrayList<>();
        int[] drawable = {R.mipmap.jwt_1, R.mipmap.jwt_2, R.mipmap.jwt_3, R.mipmap.jwt_4, R.mipmap.jwt_5, R.mipmap.jwt_6, R.mipmap.jwt_7, R.mipmap.jwt_8};
        for (int i = 0; i < 8; i++) {
            //最后一个参数表示padding
            ButtonData buttonData = ButtonData.buildIconButton(this, drawable[i], 0);
            buttonData.setBackgroundColorId(this, R.color.colorAccent);
            buttonDatas.add(buttonData);
        }
        sector.setButtonDatas(buttonDatas);
        sector.setButtonEventListener(new ButtonEventListener() {
            @Override
            public void onButtonClicked(int index) {

            }

            @Override
            public void onExpand() {

            }

            @Override
            public void onCollapse() {

            }
        });
    }
}
