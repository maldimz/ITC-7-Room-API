package com.example.cryptoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        getData();



    }

    private void getData(){
        Log.d("CEK DATA", "Data di dapatkan");
       /* pindah.putExtra("id", entity.getId());
        pindah.putExtra("nama", entity.getNama());
        pindah.putExtra("harga", entity.getHarga());
        pindah.putExtra("vol24", entity.getVol24h());
        pindah.putExtra("change1h", entity.getChange1h());
        pindah.putExtra("change24h", entity.getChange24h());
        pindah.putExtra("change7d", entity.getChange7d());
        pindah.putExtra("status", entity.getStatus());
        pindah.putExtra("time", entity.getTime());*/

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
            tvTest = findViewById(R.id.tv_test);
            tvTest.setText(getIntent().getStringExtra("nama"));
        }
    }
}