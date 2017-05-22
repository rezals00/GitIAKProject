package com.example.rezab.iakproject.presenter;

import android.text.TextUtils;

import com.example.rezab.iakproject.MainActivity;
import com.example.rezab.iakproject.interactor.LoginInterface;
import com.example.rezab.iakproject.interactor.MainInterface;

/**
 * Created by rezab on 21/05/2017.
 */

public class MainPresenter implements LoginInterface {
    private MainInterface mainInterface;

    public MainPresenter(MainActivity mainActivity) {
        this.mainInterface = mainActivity;
    }

    @Override

    public void login(String username, String password) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mainInterface.emptydata();
        } else {
            if(username.equals("reza1234")&& password.equals("reza1234")) {
                mainInterface.success(username);
            } else {
                mainInterface.invaliddata();
            }
        }
    }
}
