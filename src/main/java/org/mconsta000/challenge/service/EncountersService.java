package org.mconsta000.challenge.service;

import java.util.List;

import org.mconsta000.challenge.service.model.EncountersModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * EncountersService
 */
public interface EncountersService {
    @GET("encounters/")
    Call<List<EncountersModel>> listEncounters();

    @GET("encounters/{id}/")
    Call<EncountersModel> getEncounter(@Path("id") Integer id);
}