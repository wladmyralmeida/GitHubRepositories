package br.com.example.githubrepositories.services;

import retrofit2.Retrofit;

public class ApiClient {
    public static final String BASE_URL = "https://api.github.com/";

    //Lib Similar ao Dio do Flutter para consumir apis;
    private static Retrofit retrofit = null;

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
        }
        return retrofit;
    }
}
