package br.com.example.githubrepositories.res;

import br.com.example.githubrepositories.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserRoutes {
    @GET("/users/{user}")
    Call<User> getUser(@Path("user") String user);
}




