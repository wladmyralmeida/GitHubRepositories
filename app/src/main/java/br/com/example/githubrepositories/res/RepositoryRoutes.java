package res;

import java.util.List;

import br.com.example.githubrepositories.models.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepositoryRoutes {
    @GET("/users/{user}/repos")
    Call<List<Repository>> getRepo(@Path("user") String name);

}



