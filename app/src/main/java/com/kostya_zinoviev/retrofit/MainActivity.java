package com.kostya_zinoviev.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kostya_zinoviev.retrofit.adapters.ProductAdapter;
import com.kostya_zinoviev.retrofit.retrofit.model.Product;
import com.kostya_zinoviev.retrofit.retrofit.retrofit.ApiInterface;
import com.kostya_zinoviev.retrofit.retrofit.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView productRecView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productRecView = findViewById(R.id.productRecView);
        productRecView.setLayoutManager(new LinearLayoutManager(this));


        apiInterface = RetrofitClient.getInstance().create(ApiInterface.class);

        Call<List<Product>> callProduct = apiInterface.getAllProduct();
        callProduct.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                List<Product> productList = response.body();

                setRecyclerData(productList);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }

    private void setRecyclerData(List<Product> products){
        ProductAdapter adapter = new ProductAdapter(products,this);

        productRecView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
