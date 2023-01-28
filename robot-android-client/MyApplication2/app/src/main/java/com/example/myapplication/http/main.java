package com.example.myapplication.http;

import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class main {

    public static final String TAG = "YOUR-TAG-NAME";
    /**
     * 发送请求（使用 OKHttp）
     */
    private static void sendByOKHttp(String url,String con) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MediaType postrequestjsontype = MediaType.parse("application/json; charset=utf-8");
                OkHttpClient client = new OkHttpClient();
                RequestBody body = RequestBody.create(postrequestjsontype,con);
                System.out.println(body);
                Request request = new Request.Builder().url(url).post(body).tag(" ").build();
                System.out.println(request);
                try {
                    Response response = client.newCall(request).execute();//发送请求

                    String result = response.body().string();
                    String msg = response.message();
//                    System.out.println("response");
//                    System.out.println(response);
                    System.out.println( "result: " + result);
                    System.out.println( "msg: " + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args)
    {
        String url="http://10.164.38.47:8100";
        String con="hello";
        sendByOKHttp(url,con);

    }
}
