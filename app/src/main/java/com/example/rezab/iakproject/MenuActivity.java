package com.example.rezab.iakproject;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rezab.iakproject.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {
    private ActivityMenuBinding menuBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuBinding = DataBindingUtil.setContentView(this,R.layout.activity_menu);
        menuBinding.calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,CalculatorActivity.class);
                startActivity(intent);
            }
        });
        menuBinding.hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,HotelActivity.class);
                startActivity(intent);
            }
        });
    }
}
