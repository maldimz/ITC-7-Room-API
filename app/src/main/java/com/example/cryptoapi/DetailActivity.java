package com.example.cryptoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ArrayList<TextView> textViews = new ArrayList<>();
    private int[] textViewId = {
        R.id.tv_id_detail, //0
        R.id.tv_nama_detail, //1
        R.id.tv_harga_detail, //2
        R.id.tv_volume_detail, //3
        R.id.tv_change1h, //4
        R.id.tv_change24h, //5
        R.id.tv_change7d, //6
    };

    String id, nama;
    double harga, volume, change1h, change24h, change7d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail);

        for (int value : textViewId) textViews.add(findViewById(value));

        getData();
        setData();
    }

    private void setData() {
        NumberFormat df = new DecimalFormat("#.###");
        NumberFormat dc = new DecimalFormat("#.#######");
        NumberFormat dn = new DecimalFormat("#,###,###");

        Log.d("CEK DATA", "Data di set");
        textViews.get(0).setText(id);
        textViews.get(1).setText(nama);

        if(harga < 0.001)
            textViews.get(2).setText(dc.format(harga));
        else
            textViews.get(2).setText(df.format(harga));

        textViews.get(3).setText(dn.format(volume));
        setWarna(change1h, 4);
        setWarna(change24h, 5);
        setWarna(change7d, 6);


    }

    private void setWarna(double angka, int index){
        NumberFormat df = new DecimalFormat("#.##");
        textViews.get(index).setText(df.format(angka) + " %");

        if(angka < 0)
            textViews.get(index).setTextColor(Color.parseColor("#FDAE1515"));
        else
            textViews.get(index).setTextColor(Color.parseColor("#FD176520"));


    }

    private void getData(){

        if(
                getIntent().hasExtra("id") &&
                        getIntent().hasExtra("nama") &&
                        getIntent().hasExtra("harga") &&
                        getIntent().hasExtra("vol24") &&
                        getIntent().hasExtra("change1h") &&
                        getIntent().hasExtra("change24h") &&
                        getIntent().hasExtra("change7d") &&
                        getIntent().hasExtra("status") &&
                        getIntent().hasExtra("time")
        ){
            Log.d("CEK DATA", "Data di dapatkan");
            id = getIntent().getStringExtra("id");
            nama = getIntent().getStringExtra("nama");
            harga = getIntent().getDoubleExtra("harga", 0);
            volume = getIntent().getDoubleExtra("vol24",0);
            change1h = getIntent().getDoubleExtra("change1h", 0);
            change24h = getIntent().getDoubleExtra("change24h",0);
            change7d = getIntent().getDoubleExtra("change7d", 0);
        }else{
            Log.d("CEK DATA", "Data Gagal");
        }
    }
}