package com.scd.text;

import com.baidu.aip.client.EAuthState;
import com.baidu.aip.error.AipError;
import com.baidu.aip.http.AipHttpClient;
import com.baidu.aip.http.AipRequest;
import com.baidu.aip.http.AipResponse;
import com.baidu.aip.http.EBodyFormat;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.util.AipClientConst;
import com.baidu.aip.util.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author James
 */
public class AuthPoemTest {

    public static final String APP_ID = "22372391";
    public static final String API_KEY = "pmw6YKA6GCIijlgFR240uyfG";
    public static final String SECRET_KEY = "yom4QBgnO7TluSXgPKwHDaZRwHHwLoMm";

    public static void main(String[] args) {
        String auth = AuthService.getAuth();
        AipRequest request = new AipRequest();
        String poemUrl = "https://aip.baidubce.com/rpc/2.0/nlp/v1/poem?" + "access_token=" + auth;
        request.setUri(poemUrl);
        request.addHeader("Content-Type", "application/json");
        request.setBodyFormat(EBodyFormat.RAW_JSON);
        for (int i = 0; i < 10; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("text", "早安快乐 ");
            map.put("index", i);
            request.addBody(map);
            JSONObject jsonObject = requestServer(request);
            if (jsonObject.has("poem")) {
                JSONArray jsonArray = jsonObject.getJSONArray("poem");
                System.out.println(jsonArray.getJSONObject(0));
            } else {
//                System.out.println(jsonObject);
            }
        }
    }

    private static JSONObject requestServer(AipRequest request) {
        AipResponse response = AipHttpClient.post(request);
        String resData = response.getBodyStr();
        Integer status = response.getStatus();
        if (status.equals(200) && !resData.equals("")) {
            try {
                JSONObject res = new JSONObject(resData);
                return res;
            } catch (JSONException var7) {
                return Util.getGeneralError(-1, resData);
            }
        } else {
            return AipError.NET_TIMEOUT_ERROR.toJsonResult();
        }
    }
}
