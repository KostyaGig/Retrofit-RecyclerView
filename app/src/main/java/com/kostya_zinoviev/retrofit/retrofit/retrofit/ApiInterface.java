package com.kostya_zinoviev.retrofit.retrofit.retrofit;

import com.kostya_zinoviev.retrofit.retrofit.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("products.json")
    Call<List<Product>> getAllProduct();

}
