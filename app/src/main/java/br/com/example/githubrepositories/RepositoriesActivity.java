package br.com.example.githubrepositories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.example.githubrepositories.adapter.RepositoryAdapter;
import br.com.example.githubrepositories.models.Repository;

public class RepositoriesActivity extends AppCompatActivity {

    TextView textUserName;
    String recievedUserName;
    RecyclerView recyclerViewRepositories;
    List<Repository> repositoryList = new ArrayList<Repository>();
    RecyclerView.Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);

        Bundle extras = getIntent().getExtras();
        recievedUserName = extras.getString("user_name");

        textUserName = findViewById(R.id.textUserName);
        textUserName.setText("User:" + recievedUserName);

        recyclerViewRepositories = findViewById(R.id.recyclerViewRepositories);

        recyclerViewRepositories.setLayoutManager(new LinearLayoutManager(this));

        recyclerAdapter = new RepositoryAdapter(repositoryList, R.layout.list_item_repository, getApplicationContext());
        recyclerViewRepositories.setAdapter(recyclerAdapter);

    }
}