package br.com.example.githubrepositories;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

    }
}