package com.example.cryptoapi.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "assets")
public class Entity {
    public static final String TABLE_NAME = "assets";

    @NonNull @PrimaryKey
    private String id;
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "harga")
    private double harga;
    @ColumnInfo(name = "vol24h")
    private double vol24h;
    @ColumnInfo(name = "change1h")
    private double change1h;
    @ColumnInfo(name = "change24h")
    private double change24h;
    @ColumnInfo(name = "change7d")
    private double change7d;
    @ColumnInfo(name = "status")
    private String status;
    @ColumnInfo(name = "time")
    private String time;

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public double getVol24h() {
        return vol24h;
    }

    public double getChange1h() {
        return change1h;
    }

    public double getChange24h() {
        return change24h;
    }

    public double getChange7d() {
        return change7d;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    public Entity(String id, String nama, double harga, double vol24h, double change1h, double change24h, double change7d, String status, String time) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.vol24h = vol24h;
        this.change1h = change1h;
        this.change24h = change24h;
        this.change7d = change7d;
        this.status = status;
        this.time = time;
    }

}
