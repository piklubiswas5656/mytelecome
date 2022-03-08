package com.mytelecome.ApiController;


import com.mytelecome.Constant.Constant;
import com.mytelecome.Interface.Apicall;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {

    private static ApiController clintObject;
    private static Retrofit retrofit;


    public ApiController() {

//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
//                .callTimeout(60, TimeUnit.MINUTES)
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .writeTimeout(60, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
                .build();
    }

    public static synchronized ApiController getInstance() {
        if (clintObject == null) {
            clintObject = new ApiController();
        }

        return clintObject;
    }

    public Apicall getapi() {

        return retrofit.create(Apicall.class);

    }

}

