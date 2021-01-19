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

import com.wartono.my.API.APIInterface;
import com.wartono.my.Model.Register.ResponseRegister;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etUsername, etPassword,etName;
    Button btnRegister;
    TextView tvLoginn;
    String Username;
    String Password;
    String Name;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etRegisterUsername);
        etPassword = findViewById(R.id.etRegisterPassword);
        etName = findViewById(R.id.etRegisterName);

        tvLoginn = findViewById(R.id.tvLogin);
        tvLoginn.setOnClickListener(this);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                Username = etUsername.getText().toString();
                Name = etName.getText().toString();
                Password = etPassword.getText().toString();
                Register(Username, Name, Password);
                break;

            case R.id.tvLogin:
                Intent Intent = new Intent(this, LoginActivity.class);
                startActivity(Intent);
                break;
        }

    }

        private void Register (String username, String name,String password) {
            Call<ResponseRegister> loginCall = apiInterface.RegisterResponse(username, name, password);
            loginCall.enqueue(new Callback<ResponseRegister>() {
                @Override
                public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                    Intent Intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(Intent);
                }

                @Override
                public void onFailure(Call<ResponseRegister> call, Throwable throwable) {

                }
            }
            );
        }
}
