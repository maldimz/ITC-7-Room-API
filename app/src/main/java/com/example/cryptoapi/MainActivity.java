package com.example.cryptoapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.example.cryptoapi.database.Dao;
import com.example.cryptoapi.database.Database;
import com.example.cryptoapi.database.Entity;
import com.example.cryptoapi.model.AssetsItem;
import com.example.cryptoapi.service.CryptoListener;
import com.example.cryptoapi.service.CryptoServices;

import org.json.JSONException;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        new CryptoServices().getAsset(CryptoListener);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        SplashFragment mFragmentSplash = new SplashFragment();
        Fragment fragmentSplash = mFragmentManager.findFragmentByTag(SplashFragment.class.getSimpleName());

        if (!(fragmentSplash instanceof SplashFragment)) {
            mFragmentManager.beginTransaction()
                    .add(R.id.fl_main, mFragmentSplash, SplashFragment.class.getSimpleName())
                    .commit();
        }
    }

    CryptoListener<List<AssetsItem>> CryptoListener = new CryptoListener<List<AssetsItem>>() {
        @Override
        public void onSuccess(List<AssetsItem> items) {
            boolean check;
            Database databaseRoom = Database.getInstance(getApplication());
            Dao dao = databaseRoom.dao();
            //NumberFormat df = new DecimalFormat("#.###");
            Log.d("masuk sini", String.valueOf(items.size()));

            if (dao.getAllData().isEmpty()) check=true;
            else check=false;
            for(int i = 0; i < items.size(); i++){
                Entity entity = new Entity(
                        items.get(i).getId(),
                        items.get(i).getName(),
                        items.get(i).getPrice(),
                        items.get(i).getVolume24h(),
                        items.get(i).getChange1h(),
                        items.get(i).getChange24h(),
                        items.get(i).getChange7d(),
                        items.get(i).getStatus(),
                        items.get(i).getTime()
                );

                if(check) dao.insert(entity);
                else dao.update(entity);
            }
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR", msg);
            Database databaseROOM = Database.getInstance(getApplication());
            Dao dao = databaseROOM.dao();

            if(dao.getAllData().isEmpty()){
                Log.d("ISI DATABASE : ", "Kosongggg!!!");
            }else{
                Log.d("ISI DATABASE : ", "ADA!!!");
            }

        }
    };
}