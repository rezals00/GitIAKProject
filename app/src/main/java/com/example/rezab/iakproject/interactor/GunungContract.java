package com.example.rezab.iakproject.interactor;

import com.example.rezab.iakproject.adapter.GAdapter;
import com.example.rezab.iakproject.model.Gunung;
import com.example.rezab.iakproject.model.Gunung_;
import com.example.rezab.iakproject.util.GunungPresenter;
import com.example.rezab.iakproject.util.GunungView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by rezab on 26/05/2017.
 */

public interface GunungContract {
    interface View extends GunungView<Presenter> {

        void updateGunung(List<Gunung_> gunungs);

        void showProgress();

        void hideProgress(String e);
    }

    interface Presenter extends GunungPresenter<View> {

        void getGunungHistory();
        void getGunungsHistory(List<Gunung_> gunung);

    }
}
