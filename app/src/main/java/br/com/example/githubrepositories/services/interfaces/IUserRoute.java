package br.com.example.githubrepositories.services.interfaces;

import br.com.example.githubrepositories.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IUserRoute {

    @GET("/users/{user}")
    Call<User> getUser(@Path("user") String user);
}
