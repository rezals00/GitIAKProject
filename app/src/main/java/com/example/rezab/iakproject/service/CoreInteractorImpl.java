package com.example.rezab.iakproject.service;

import android.content.Context;

import com.example.rezab.iakproject.interactor.GunungInteractor;
import com.example.rezab.iakproject.model.Gunung;

import java.util.List;

import rx.Observable;

/**
 * Created by rezab on 26/05/2017.
 */

public class CoreInteractorImpl implements GunungInteractor {
    private CoreApiService mCoreApi;
    private Context mContext;

    public CoreInteractorImpl(Context context){
        mCoreApi = CoreApiServiceBuilder.provideCoreApiService();
        mContext = context;
    }

    @Override
    public Observable<List<Gunung>> getGunungHistoryTransaction() {
        return mCoreApi.getGunung();
    }
}
