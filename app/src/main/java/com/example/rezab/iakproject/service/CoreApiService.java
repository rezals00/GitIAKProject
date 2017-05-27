package com.example.rezab.iakproject.service;

import com.example.rezab.iakproject.model.Gunung;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by rezab on 26/05/2017.
 */

public interface CoreApiService {
    String END_POINT = "questions";

    @GET(END_POINT)
    rx.Observable<List<Gunung>> getGunung();
}
