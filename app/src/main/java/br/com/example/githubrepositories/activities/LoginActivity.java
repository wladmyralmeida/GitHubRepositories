package br.com.example.githubrepositories.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.example.githubrepositories.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUserName = findViewById(R.id.input_username);
        btnLogin = findViewById(R.id.btn_login);
    }

    public void getUser(View view) {

        Intent i = new Intent(LoginActivity.this, UserActivity.class);
        i.putExtra("STRING_I_NEED", editTextUserName.getText().toString());
        startActivity(i);
    }
}