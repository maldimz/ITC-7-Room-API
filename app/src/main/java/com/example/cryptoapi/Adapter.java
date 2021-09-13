package com.example.cryptoapi;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptoapi.database.Entity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Entity> entities;

    public Adapter(Context context, List<Entity> temps){
        this.context = context;
        this.entities = temps;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(entities.get(position));
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(Entity entity) {
            CardView cardView = itemView.findViewById(R.id.cv_main);
            ArrayList<TextView> textViews = new ArrayList<>(
                    Arrays.asList(
                            itemView.findViewById(R.id.tv_id),
                            itemView.findViewById(R.id.tv_nama),
                            itemView.findViewById(R.id.tv_harga_isi),
                            itemView.findViewById(R.id.tv_volume_isi)
                    )
            );
            NumberFormat df = new DecimalFormat("#.###");
            textViews.get(0).setText(entity.getId());
            textViews.get(1).setText(entity.getNama());
            textViews.get(2).setText(df.format(entity.getHarga()) + " USD");
            textViews.get(3).setText(df.format(entity.getVol24h()));

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("test", "onClick: Ter klick");
                    Intent pindah = new Intent(context, DetailActivity.class);
                    pindah.putExtra("id", entity.getId());
                    pindah.putExtra("nama", entity.getNama());
                    pindah.putExtra("harga", entity.getHarga());
                    pindah.putExtra("vol24", entity.getVol24h());
                    pindah.putExtra("change1h", entity.getChange1h());
                    pindah.putExtra("change24h", entity.getChange24h());
                    pindah.putExtra("change7d", entity.getChange7d());
                    pindah.putExtra("status", entity.getStatus());
                    pindah.putExtra("time", entity.getTime());
                    context.startActivity(pindah);
                }
            });
        }
    }

}
