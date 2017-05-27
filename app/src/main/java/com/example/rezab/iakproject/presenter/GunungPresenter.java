package com.example.rezab.iakproject.presenter;

import android.util.Log;

import com.example.rezab.iakproject.adapter.GAdapter;
import com.example.rezab.iakproject.interactor.GunungContract;
import com.example.rezab.iakproject.model.Gunung;
import com.example.rezab.iakproject.model.Gunung_;
import com.example.rezab.iakproject.service.CoreInteractorImpl;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rezab on 26/05/2017.
 */

public class GunungPresenter implements GunungContract.Presenter {
    private static final String TAG = "GunungPresenter";

    private CoreInteractorImpl mInteractor;
    private GunungContract.View mView;
    private List<Gunung> mGunung;
    private List<Gunung_> mG = new ArrayList();
    public GAdapter gAdapter;
    public GunungPresenter(CoreInteractorImpl mInteractor) {
        this.mInteractor = mInteractor;
        mGunung = new ArrayList<>();
    }

    @Override
    public void bind(GunungContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }

    @Override
    public void getGunungHistory() {
        mInteractor.getGunungHistoryTransaction()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Gunung>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage(), e);
                        if(mView == null){
                            return;
                        }
                        mView.hideProgress(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Gunung> quotesEntities) {
//                        for(int i = 0;i < quotesEntities.size() ; i++) {
//                            getGunungsHistory((Observable<List<Gunung_>>) quotesEntities.get(i).getGunung());
//                        }
                        for(int a = 0; a < quotesEntities.size(); a++){
                            String pulau = quotesEntities.get(a).getPulau();
//                            mView.hideProgress(""+quotesEntities.get(a).getGunung().size());
                            if(quotesEntities.get(a).getGunung().size() > 1) {
//                                quotesEntities.get(a).getGunung().size()
                                for (int q = 0; q < quotesEntities.get(a).getGunung().size(); q++) {
                                    String nama = quotesEntities.get(a).getGunung().get(q).getNamaGunung();
                                    String foto = quotesEntities.get(a).getGunung().get(q).getFotoGunung();
                                    String tinggi = quotesEntities.get(a).getGunung().get(q).getTinggiGunung();
//                                    mView.hideProgress("NAMA :" + nama + " | TINGGI : " + tinggi + " | FOTO :" + foto + "A :" + a + "Q :" + q);
                                mG.add(new Gunung_(pulau,nama,tinggi,foto));
//                                mG.addAll(quotesEntities.get(a).getGunung());
                                }
                            }
                        }
                                mView.updateGunung(mG);
                    }
                });
    }

    @Override
    public void getGunungsHistory(List<Gunung_> gunung) {
    }
}
