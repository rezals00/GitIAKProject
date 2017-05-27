package com.example.rezab.iakproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rezab.iakproject.DetailActivity;
import com.example.rezab.iakproject.R;
import com.example.rezab.iakproject.model.Gunung;
import com.example.rezab.iakproject.model.Gunung_;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rezab on 26/05/2017.
 */

public class GAdapter extends RecyclerView.Adapter<GAdapter.ViewHolder> {

        private List<Gunung_> mGunung;
        private Context mContext;
    public GAdapter( Context context,List<Gunung_> mGunung) {
            this.mGunung = mGunung;
            this.mContext = context;
        }

        @Override
        public GAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_gunung_view, parent, false);
            return new GAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(GAdapter.ViewHolder holder,int position) {

            final Gunung_ Gunung = mGunung.get(position);
            holder.Judul.setText("Gunung " + Gunung.getNamaGunung());
            holder.Lokasi.setText("Berada di pulau " + Gunung.getNamapulau());
            Picasso.with(mContext).load(Gunung.getFotoGunung()).fit().into(holder.imageView);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext.getApplicationContext(), DetailActivity.class);
                    intent.putExtra("Nama",Gunung.getNamaGunung());
                    intent.putExtra("Pulau",Gunung.getNamapulau());
                    intent.putExtra("Foto",Gunung.getFotoGunung());
                    intent.putExtra("Tinggi",Gunung.getTinggiGunung());
                    mContext.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mGunung.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView Judul,Lokasi;
//            CardView cardView;
            ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                  Judul = (TextView) itemView.findViewById(R.id.tv_nama);
                Lokasi = (TextView) itemView.findViewById(R.id.tv_pulau);
                imageView = (ImageView) itemView.findViewById(R.id.img_vi);
//                textView1 = (TextView) itemView.findViewById(R.id.tv_judul);
//                textView2 = (TextView) itemView.findViewById(R.id.tv_tentang);
//                textView3 = (TextView) itemView.findViewById(R.id.tv_isi);
//
//                cardView = (CardView) itemView.findViewById(R.id.card_view);
                //cardView.setOnClickListener(this);
            }

//        public void onClick(View v) {
//
//            if(v.getId() == R.id.card_view){
//                Intent intent = new Intent(mContext.getApplicationContext(), DetailActivity.class);
//                intent.putExtra("judul", ((TextView) v.findViewById(R.id.tv_judul)).getText());
//                intent.putExtra("tentang", ((TextView) v.findViewById(R.id.tv_tentang)).getText());
//                intent.putExtra("isi", ((TextView) v.findViewById(R.id.tv_isi)).getText());
//                mContext.startActivity(intent);
//            }
//        }
        }

}
