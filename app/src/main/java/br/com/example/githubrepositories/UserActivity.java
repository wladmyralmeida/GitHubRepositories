package br.com.example.githubrepositories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.example.githubrepositories.models.User;
import br.com.example.githubrepositories.services.ApiClient;
import br.com.example.githubrepositories.interfaces.IUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    ImageView imgAvatar;
    TextView textEmail, textLogin, textFollowing, textFollowers;
    Button btnOwnedRepository;

    Bundle extras;
    String extraUserName;

    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        imgAvatar = findViewById(R.id.avatar);
        textEmail = findViewById(R.id.email);
        textLogin = findViewById(R.id.logIn);
        textFollowing = findViewById(R.id.following);
        textFollowers = findViewById(R.id.followers);
        btnOwnedRepository = findViewById(R.id.btnOwnedRepos);

        extras = getIntent().getExtras();
        extraUserName = extras.getString("user_name");


        //Mudar para floatingActionButton do flutter
        btnOwnedRepository.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, RepositoriesActivity.class);
                intent.putExtra("user_name", extraUserName);
                startActivity(intent);
            }
        });

        loadData();
    }

    private void loadData() {
        final IUser apiService = ApiClient.getApiClient().create(IUser.class);

        Call<User> calledUserService = apiService.getUser(extraUserName);

        calledUserService.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}