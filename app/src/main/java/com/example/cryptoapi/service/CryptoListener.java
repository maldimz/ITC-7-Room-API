package com.example.cryptoapi.service;

public interface CryptoListener<T> {
    void onSuccess(T items);
    void onFailed(String msg);
}
