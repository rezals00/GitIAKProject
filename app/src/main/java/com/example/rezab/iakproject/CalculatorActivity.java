package com.example.rezab.iakproject;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rezab.iakproject.databinding.ActivityCalculatorBinding;
import com.example.rezab.iakproject.interactor.CalcInterface;
import com.example.rezab.iakproject.presenter.CalculatorPresenter;

public class CalculatorActivity extends AppCompatActivity implements CalcInterface {
    private ActivityCalculatorBinding cBinding;
    private CalculatorPresenter cPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cBinding = DataBindingUtil.setContentView(this,R.layout.activity_calculator);
        cPresenter = new CalculatorPresenter(this);


        cBinding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.set(0)+"");
            }
        });
        cBinding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.set(1)+"");
            }
        });
        cBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.set(2)+"");
            }
        });
        cBinding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.set(3)+"");
            }
        });
        cBinding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.set(4)+"");

            }
        });
        cBinding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.set(5)+"");

            }
        });
        cBinding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.set(6)+"");
            }
        });
        cBinding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.set(7)+"");
            }
        });
        cBinding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.set(8)+"");

            }
        });
        cBinding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.set(9)+"");

            }
        });
        cBinding.buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPresenter.tambah();
            }
        });
        cBinding.buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPresenter.kali();
            }
        });
        cBinding.buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPresenter.kurang();
            }
        });
        cBinding.buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPresenter.bagi();
            }
        });
        cBinding.buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText("");
                cPresenter.c();
            }
        });
        cBinding.buttoneql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPresenter.hitung();
            }
        });
        cBinding.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBinding.edt1.setText(cPresenter.back()+"");
            }
        });
    }

    @Override
    public void setTextEdt(String data) {

        cBinding.edt1.setText(data);
        cBinding.textView2.setText(data);

    }

}
