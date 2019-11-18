package org.mconsta000.challenge.service;

import java.util.List;

import org.mconsta000.challenge.service.model.FoeEncounterModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * FoeEncounterService
 */
public interface FoeEncountersService {
    @GET("foe-encounters/")
    Call<List<FoeEncounterModel>> listFoeEncounters();

    @GET("foe-encounters/{id}/")
    Call<FoeEncounterModel> getFoeEncounter(@Path("id") Integer id);
  }