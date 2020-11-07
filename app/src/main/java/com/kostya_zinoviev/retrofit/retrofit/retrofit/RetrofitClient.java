package com.kostya_zinoviev.retrofit.retrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit retrofit;
    public static final String BASE_URL = "http://androidappsforyoutube.s3.ap-south-1.amazonaws.com/retrofit/";

    public static Retrofit getInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
