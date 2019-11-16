package org.mconsta000.challenge.service;

import java.util.List;

import org.mconsta000.challenge.model.FoeModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FoesService {
    @GET("foes/")
    Call<List<FoeModel>> listFoes();

    @GET("foes/{id}/")
    Call<FoeModel> getFoe(@Path("id") Integer id);
  }