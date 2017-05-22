package com.example.rezab.iakproject.interactor;

import android.text.Editable;

/**
 * Created by rezab on 22/05/2017.
 */

public interface CalculatorInterface {
    Integer set(Integer data);
    void kali();
    void bagi();
    void kurang();
    void tambah();
    void hitung();
    void c();
    String back();
    Integer getOne(Integer data);
}
