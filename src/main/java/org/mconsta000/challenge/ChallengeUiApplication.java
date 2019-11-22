package org.mconsta000.challenge;

import org.mconsta000.challenge.service.EncountersService;
import org.mconsta000.challenge.service.FoeEncountersService;
import org.mconsta000.challenge.service.FoesService;
import org.mconsta000.challenge.service.PartiesService;
import org.mconsta000.challenge.service.PlayersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SpringBootApplication
public class ChallengeUiApplication {
	@Value("${challenge.api.baseUrl}")
	private String baseUrl;

	public static void main(final String[] args) {
		SpringApplication.run(ChallengeUiApplication.class, args);
	}

	@Bean
	public Retrofit getRetrofit(OkHttpClient client) {
		return new Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl(baseUrl)
			.client(client)
			.build();
	}

	@Bean
	OkHttpClient getOkHttpClient() {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(Level.BASIC);

		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();

		return client;
	}

	@Bean
	public FoesService getFoesService(final Retrofit retrofit) {
		return retrofit.create(FoesService.class);
	}

	@Bean
	public FoeEncountersService getFoeEncountersService(final Retrofit retrofit) {
		return retrofit.create(FoeEncountersService.class);
	}

	@Bean
	public EncountersService getEncountersService(final Retrofit retrofit) {
		return retrofit.create(EncountersService.class);
	}

	@Bean
	public PlayersService getPlayersService(final Retrofit retrofit) {
		return retrofit.create(PlayersService.class);
	}

	@Bean
	public PartiesService getPartiesService(final Retrofit retrofit) {
		return retrofit.create(PartiesService.class);
	}
}
