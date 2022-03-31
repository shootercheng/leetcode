package com.scd.text;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

/**
 * @author James
 */
public class TextPoem {

    //设置APPID/AK/SK
    public static final String APP_ID = "22372391";
    public static final String API_KEY = "pmw6YKA6GCIijlgFR240uyfG";
    public static final String SECRET_KEY = "yom4QBgnO7TluSXgPKwHDaZRwHHwLoMm";

    public static void main(String[] args) {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        String text = "百度是一家高科技公司";
        JSONObject res = client.lexer(text, null);
        System.out.println(res.toString(2));
    }
}
