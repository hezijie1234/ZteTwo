package com.zte.day1navigationview;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class JWTMainActivity extends AppCompatActivity {
    List<String[]> list = new ArrayList<>();
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jwtmain);
        gridView = (GridView) findViewById(R.id.gridview);
        list.add(new String[]{"R.id.jwt_1","人证核验"});
        list.add(new String[]{"R.id.jwt_1","嫌犯扫描"});
        list.add(new String[]{"R.id.jwt_1","模板采集"});
        list.add(new String[]{"R.id.jwt_1","警情处理"});
        list.add(new String[]{"R.id.jwt_1","历史警情"});
        list.add(new String[]{"R.id.jwt_1","警情下达"});
        list.add(new String[]{"R.id.jwt_1","通知公告"});
        list.add(new String[]{"R.id.jwt_1","联系人"});
        list.add(new String[]{"R.id.jwt_1","设置"});
        MyAdapter adapter = new MyAdapter();
        gridView.setAdapter(adapter);

    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(JWTMainActivity.this).inflate(R.layout.grid_item,parent,false);
            convertView.setMinimumHeight((gridView.getHeight() - 9) / 3);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.item_image);
            TextView textView = (TextView) convertView.findViewById(R.id.item_text);
            imageView.setImageResource(R.mipmap.jwt_1);
            textView.setText(list.get(position)[1]);
            return convertView;
        }
    }
}
