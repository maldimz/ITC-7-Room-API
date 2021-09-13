package com.example.cryptoapi.service;

import com.example.cryptoapi.model.CryptoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {
    String URL_BASE = "https://www.cryptingup.com/"; //Link

    @GET("api/assets")//Method mengambil data
    Call<CryptoResponse> getCrypto();
}
