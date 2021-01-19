package com.wartono.my;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wartono.my.API.APIClient;
import com.wartono.my.API.APIInterface;
import com.wartono.my.Model.Login.ResponLoginData;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etUsername, etPassword;
    Button btnLogin;
    String username, password;
    TextView tvRegister;
    APIInterface apiInterface;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin   = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        tvRegister = findViewById(R.id.tvCreateAccount);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
            username = etUsername.getText().toString();
            password = etPassword.getText().toString();
            Login (username,password);
            break;

            case R.id.tvCreateAccount:
           Intent Intent = new Intent (this,RegisterActivity.class);
            startActivity(Intent);
            break;
        }

    }

    private void Login(String username, String password) {
        apiInterface = APIClient.getRetrofit().create(APIInterface.class);
        Call<ResponLoginData> loginCall = apiInterface.loginResponse(username,password);
        loginCall.enqueue(new Callback<ResponLoginData>() {
            @Override
            public void onResponse(Call<ResponLoginData> call, Response<ResponLoginData> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {

//                    sessionManager = new SessionManager(LoginActivity.this);
//                    ModelLoginData loginData = response.body().getLoginData();
//                    sessionManager.createLoginSession(loginData);

                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent Intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(Intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponLoginData> call, Throwable throwable) {
                Toast.makeText(LoginActivity.this, throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}