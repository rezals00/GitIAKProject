package com.example.rezab.iakproject.interactor;

import com.example.rezab.iakproject.model.Gunung;

import java.util.List;

import rx.Observable;

/**
 * Created by rezab on 26/05/2017.
 */

public interface GunungInteractor {
    Observable<List<Gunung>> getGunungHistoryTransaction();
}
