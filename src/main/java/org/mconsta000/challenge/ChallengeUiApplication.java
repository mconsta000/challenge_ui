package org.mconsta000.challenge;

import org.mconsta000.challenge.service.FoesService;
import org.mconsta000.challenge.service.PartiesService;
import org.mconsta000.challenge.service.PlayersService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SpringBootApplication
public class ChallengeUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeUiApplication.class, args);
	}

	@Bean
	public Retrofit getRetrofit() {
		return new Retrofit.Builder()
		.addConverterFactory(GsonConverterFactory.create())
		.baseUrl("http://localhost:8000/calc/")
		.build();
	}

	@Bean
	public FoesService getFoesService(Retrofit retrofit) {
		return retrofit.create(FoesService.class);
	}

	@Bean
	public PlayersService getPlayersService(Retrofit retrofit) {
		return retrofit.create(PlayersService.class);
	}

	@Bean
	public PartiesService getPartiesService(Retrofit retrofit) {
		return retrofit.create(PartiesService.class);
	}
}
