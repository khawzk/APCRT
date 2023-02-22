package com.example.myapplication.http;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class Api {

    public static final String TAG = "YOUR-TAG-NAME";

    private static final OkHttpClient client = initializeClient();
    private static final ExecutorService threadPool = Executors.newSingleThreadExecutor();

    private static final Object LOCK = new Object();

    public static OkHttpClient initializeClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor())
                .build();
    }

    /**
     * 发送请求（使用 OKHttp）
     */
    public void sendByOKHttp(String url, String con) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MediaType postrequestjsontype = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(postrequestjsontype, con);
                //System.out.println(body);

                Request request = new Request.Builder().url(url).post(body).tag("").build();
                System.out.println(request);
                try {
                    Response response = client.newCall(request).execute();//发送请求
                    String result = response.body().string();
                    System.out.println("成功 ");
                    //System.out.println( "result: " + result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    /**
     * 发送请求（使用 OKHttp）
     */
    public void sendGetRequest(String url, String con) {
        threadPool.execute(() -> {
            MediaType postrequestjsontype = MediaType.parse("application/json; charset=utf-8");
            //System.out.println(body);

            try {
                RequestBody body = RequestBody.create(postrequestjsontype, con);
                Request request = new Request.Builder().url(url).get().build();
                Response response = client.newCall(request).execute();//发送请求
                String result = response.body().string();
                //System.out.println( "result: " + result);
            } catch (RuntimeException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 发送请求（使用 OKHttp）
     */
    public void asyncSendGetRequest(String url, String con, Callback callback) {
        MediaType postrequestjsontype = MediaType.parse("application/json; charset=utf-8");
        //System.out.println(body);

        try {
            RequestBody body = RequestBody.create(postrequestjsontype, con);
            Request request = new Request.Builder().url(url).get().build();
            client.newCall(request).enqueue(callback);//发送请求
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
