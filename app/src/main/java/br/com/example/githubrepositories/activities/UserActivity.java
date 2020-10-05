package br.com.example.githubrepositories.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.example.githubrepositories.helper.ImageDownloader;
import br.com.example.githubrepositories.models.User;
import br.com.example.githubrepositories.res.APIClient;
import br.com.example.githubrepositories.res.UserRoutes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import br.com.example.githubrepositories.R;
public class UserActivity extends AppCompatActivity {
    ImageView avatarImg;
    TextView userNameTV;
    TextView followersTV;
    TextView followingTV;
    TextView logIn;
    TextView email;
    Button ownedrepos;

    Bundle extras;
    String newString;

    Bitmap myImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        avatarImg = (ImageView) findViewById(R.id.avatar);
        userNameTV = (TextView) findViewById(R.id.username);
        followersTV = (TextView) findViewById(R.id.followers);
        followingTV = (TextView) findViewById(R.id.following);
        logIn = (TextView) findViewById(R.id.login);
        email = (TextView) findViewById(R.id.email);
        ownedrepos = (Button) findViewById(R.id.btnOwnedRepos);

        extras = getIntent().getExtras();
        newString = extras.getString("STRING_I_NEED");

        System.out.println(newString);
        loadData();
    }

    public void loadOwnRepos(View view) {

        Intent intent = new Intent(UserActivity.this, RepositoriesActivity.class);
        intent.putExtra("username", newString);
        startActivity(intent);
    }

    public void loadData() {
        final UserRoutes apiService =
                APIClient.getClient().create(UserRoutes.class);

        Call<User> call = apiService.getUser(newString);
        call.enqueue(new Callback<User>() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<User> call, Response<User>
                    response) {

                ImageDownloader task = new ImageDownloader();

                try {
                    myImage = task.execute(response.body().getAvatar()).get();

                } catch (Exception e) {

                    e.printStackTrace();

                }

                avatarImg.setImageBitmap(myImage);
                avatarImg.getLayoutParams().height = 220;
                avatarImg.getLayoutParams().width = 220;

                if (response.body().getName() == null) {
                    userNameTV.setText("No name provided");
                } else {
                    userNameTV.setText("Username: " + response.body().getName());
                }

                followersTV.setText("Followers: " + response.body().getFollowers());
                followingTV.setText("Following: " + response.body().getFollowing());
                logIn.setText("LogIn: " + response.body().getLogin());

                if (response.body().getEmail() == null) {
                    email.setText("No email provided");
                } else {
                    email.setText("Email: " + response.body().getEmail());
                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Failed!" + t.toString());
            }
        });
    }
}

