package com.mytelecome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mytelecome.ApiController.ApiController;
import com.mytelecome.Constant.Constant;
import com.mytelecome.Modal.Login.Userlogin;
import com.mytelecome.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import soup.neumorphism.NeumorphButton;

public class Login extends AppCompatActivity {
    //wid
    TextView demo;
    EditText email, password;
    NeumorphButton login;
    ImageView logo;
    //val
    Context context = Login.this;
    Call<Userlogin> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        clickevent();
        checkuserExistence();
    }


    private void init() {
        demo = findViewById(R.id.demo);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);
        logo = findViewById(R.id.logo);

    }

    private void clickevent() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getdata();
            }
        });

    }

    private void getdata() {

        call = ApiController.getInstance().getapi().login(
                Constant.apikey,
                Constant.Login,
                "sadirul",
                "sadirul"
        );


        call.enqueue(new Callback<Userlogin>() {
            @Override
            public void onResponse(Call<Userlogin> call, Response<Userlogin> response) {
                Userlogin obj = response.body();
                try {
                    Toast.makeText(getApplicationContext(), obj.getMsg(), Toast.LENGTH_LONG).show();
                    if (obj.getStatus().toString().equals("success")) {
                        SharedPreferences sp = getSharedPreferences(Constant.Login, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString(Constant.Username, obj.getData().getUsername());
                        editor.putString(Constant.Auth_Key, obj.getData().getAuthKey());
                        editor.commit();
                        editor.apply();
                        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                        startActivity(intent);
                    }

                } catch (Exception e) {

                }


            }

            @Override
            public void onFailure(Call<Userlogin> call, Throwable t) {

            }
        });
    }


    //
    public void checkuserExistence() {
        SharedPreferences sp = getSharedPreferences(Constant.Login, MODE_PRIVATE);
        if (sp.contains(Constant.Username)) {
            startActivity(new Intent(context, Dashboard.class));
        }


    }
}