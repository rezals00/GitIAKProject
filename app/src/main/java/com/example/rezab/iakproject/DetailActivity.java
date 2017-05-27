package com.example.rezab.iakproject;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rezab.iakproject.databinding.ActivityDetailBinding;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        setSupportActionBar(mBinding.toolbar);
        ImageView im = mBinding.imageView2;
        Intent intent = getIntent();
        String Nama = intent.getStringExtra("Nama");
        String Pulau = intent.getStringExtra("Pulau");
        String Tinggi = intent.getStringExtra("Tinggi");
        String Foto = intent.getStringExtra("Foto");
        setTitle("Gunung "+intent.getStringExtra("Nama"));
        Picasso.with(getApplicationContext()).load(Foto).fit().into(im);
        mBinding.include.info.setText("Gunung "+ Nama +" Tereletak Di Pulau "+Pulau +"Gunung "+Nama+" Memiliki Tinggi Sekitar" +Tinggi);
        mBinding.button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        Toast.makeText(this, "WIDTH :"+im.getMaxWidth()+"| HEIGHT:"+im.getMaxHeight(), Toast.LENGTH_SHORT).show();
    }
}
