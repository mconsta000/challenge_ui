package org.mconsta000.challenge.service;

import java.util.List;

import org.mconsta000.challenge.service.model.PlayerModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * PlayersService
 */
public interface PlayersService {
    @GET("players/")
    Call<List<PlayerModel>> listPlayers();

    @GET("players/{id}/")
    Call<PlayerModel> getPlayer(@Path("id") Integer id);
}