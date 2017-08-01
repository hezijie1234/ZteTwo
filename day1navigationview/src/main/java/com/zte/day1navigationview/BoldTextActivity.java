package com.zte.day1navigationview;

import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class BoldTextActivity extends AppCompatActivity {
    private TextView boldTextView;
    SpannableString string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bold_text);
        boldTextView = (TextView) findViewById(R.id.tv_title);
        string = new SpannableString("字体测试字体大小一半两倍前景色背景色正常粗体斜体粗斜体下划线删除线x1x2电话邮件网站短信彩信地图X轴综合/bot");
        //设置字体(default,default-bold,monospace,serif,sans-serif)
        string.setSpan(new TypefaceSpan("monospace"),0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new TypefaceSpan("serif"),2,4,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体大小（绝对值,单位：像素）
        string.setSpan(new AbsoluteSizeSpan(20),4,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //第二个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素，同上。
        string.setSpan(new AbsoluteSizeSpan(20,true),6,8,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体大小（相对值,单位：像素） 参数表示为默认字体大小的多少倍
        string.setSpan(new RelativeSizeSpan(0.5f), 8, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //0.5f表示默认字体大小的一半
        string.setSpan(new RelativeSizeSpan(2.0f), 10, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //2.0f表示默认字体大小的两倍
        //设置字体前景色
        string.setSpan(new ForegroundColorSpan(Color.MAGENTA), 12, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //设置前景色为洋红色
        //设置字体背景色
        string.setSpan(new BackgroundColorSpan(Color.CYAN), 15, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //设置背景色为青色

        //设置字体样式正常，粗体，斜体，粗斜体
        string.setSpan(new StyleSpan(android.graphics.Typeface.NORMAL), 18, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //正常
        string.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 20, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗体
        string.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 22, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //斜体
        string.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 24, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //粗斜体

        //设置下划线
        string.setSpan(new UnderlineSpan(), 27, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置删除线
        string.setSpan(new StrikethroughSpan(), 30, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置上下标
        string.setSpan(new SubscriptSpan(), 34, 35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //下标
        string.setSpan(new SuperscriptSpan(), 36, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);   //上标

        //超级链接（需要添加setMovementMethod方法附加响应）
        string.setSpan(new URLSpan("tel:4155551212"), 37, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //电话
        string.setSpan(new URLSpan("mailto:webmaster@google.com"), 39, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //邮件
            string.setSpan(new URLSpan("http://www.baidu.com"), 41, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //网络
        string.setSpan(new URLSpan("sms:4155551212"), 43, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //短信   使用sms:或者smsto:
        string.setSpan(new URLSpan("mms:4155551212"), 45, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //彩信   使用mms:或者mmsto:
        string.setSpan(new URLSpan("geo:38.899533,-77.036476"), 47, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //地图

        //设置字体大小（相对值,单位：像素） 参数表示为默认字体宽度的多少倍
        string.setSpan(new ScaleXSpan(2.0f), 49, 51, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //2.0f表示默认字体宽度的两倍，即X轴方向放大为默认字体的两倍，而高度不变

        //设置字体（依次包括字体名称，字体大小，字体样式，字体颜色，链接颜色）
        ColorStateList csllink = null;
        ColorStateList csl = null;
//        XmlResourceParser xppcolor=getResources().getXml (R.color.colorAccent);
//        try {
//            csl= ColorStateList.createFromXml(getResources(),xppcolor);
//        }catch(XmlPullParserException e){
//            // TODO: handle exception
//            e.printStackTrace();
//        }catch(IOException e){
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//
//        XmlResourceParser xpplinkcolor=getResources().getXml(R.color.colorAccent);
//        try {
//            csllink= ColorStateList.createFromXml(getResources(),xpplinkcolor);
//        }catch(XmlPullParserException e){
//            // TODO: handle exception
//            e.printStackTrace();
//        }catch(IOException e){
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//        string.setSpan(new TextAppearanceSpan("monospace",android.graphics.Typeface.BOLD_ITALIC, 30, csl, csllink), 51, 53, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置项目符号
        string.setSpan(new BulletSpan(android.text.style.BulletSpan.STANDARD_GAP_WIDTH,Color.GREEN), 0 ,string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //第一个参数表示项目符号占用的宽度，第二个参数为项目符号的颜色

        //设置图片
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        string.setSpan(new ImageSpan(drawable), 53, 57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        boldTextView.setText(string);
        boldTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
