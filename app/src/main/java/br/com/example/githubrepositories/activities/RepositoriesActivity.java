package br.com.example.githubrepositories.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.example.githubrepositories.R;
import br.com.example.githubrepositories.adapter.RepositoryAdapter;
import br.com.example.githubrepositories.models.Repository;
import br.com.example.githubrepositories.res.APIClient;
import res.RepositoryRoutes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoriesActivity extends AppCompatActivity {

    TextView textUserName;
    String recievedUserName;
    RecyclerView recyclerViewRepositories;
    List<Repository> repositoryList = new ArrayList<>();
    RecyclerView.Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);

        Bundle extras = getIntent().getExtras();
        recievedUserName = extras.getString("username");

        textUserName = findViewById(R.id.textUserName);
        textUserName.setText("User:" + recievedUserName);

        recyclerViewRepositories = findViewById(R.id.recyclerViewRepositories);

        recyclerViewRepositories.setLayoutManager(new LinearLayoutManager(this));

        recyclerAdapter = new RepositoryAdapter(repositoryList, R.layout.list_item_repository, getApplicationContext());
        recyclerViewRepositories.setAdapter(recyclerAdapter);

        loadRepositories();
    }

    private void loadRepositories() {
        RepositoryRoutes apiService = APIClient.getClient().create(RepositoryRoutes.class);

        Call<List<Repository>> callRepositoriesList = apiService.getRepo(recievedUserName);
        callRepositoriesList.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                repositoryList.clear();
                repositoryList.addAll(response.body());
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Log.d("Respository: " , t.toString());
            }
        });
    }
}