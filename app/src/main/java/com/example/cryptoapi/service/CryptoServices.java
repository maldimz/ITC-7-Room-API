package com.example.cryptoapi.service;

import com.example.cryptoapi.model.AssetsItem;
import com.example.cryptoapi.model.CryptoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CryptoServices {
    Retrofit retrofit = null;

    public CryptoAPI getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(CryptoAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CryptoAPI.class);
    }

    public void getAsset(final CryptoListener <List<AssetsItem>> listener){
        getAPI().getCrypto().enqueue(new Callback<CryptoResponse>() {
            @Override
            public void onResponse(Call<CryptoResponse> call, Response<CryptoResponse> response) {
                // response.body() adalah hasil data yang diperoleh dari API lalu disimpan ke dalam variabel data
                CryptoResponse data = response.body();

                if (data != null && data.getAssets() != null ){
                    listener.onSuccess(data.getAssets());
                }
            }

            @Override
            public void onFailure(Call<CryptoResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }


}
