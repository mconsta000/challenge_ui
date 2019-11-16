package org.mconsta000.challenge.service;

import java.util.List;

import org.mconsta000.challenge.model.PartyModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * PartiesService
 */
public interface PartiesService {
    @GET("parties/")
    Call<List<PartyModel>> listParties();

    @GET("parties/{id}/")
    Call<PartyModel> getParty(@Path("id") Integer id);
}