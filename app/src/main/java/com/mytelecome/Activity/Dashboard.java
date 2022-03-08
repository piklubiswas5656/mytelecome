package com.mytelecome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mytelecome.Constant.Constant;
import com.mytelecome.R;

import soup.neumorphism.NeumorphButton;

public class Dashboard extends AppCompatActivity {
    TextView username;
    NeumorphButton logout;
    String usernamee;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
        clickevent();
        SharedPreferences getShared = getSharedPreferences(Constant.Login, MODE_PRIVATE);
        usernamee = getShared.getString(Constant.Username, "username");
        username.setText(usernamee.toString());
    }

    private void init() {
        username = findViewById(R.id.username);
        logout = findViewById(R.id.logoutBtn);
    }

    private void clickevent() {
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sp = getSharedPreferences(Constant.Login, MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.remove(Constant.Username).commit();
                editor.apply();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });
    }

    public void qrscan(View view) {
        startActivity(new Intent(getApplicationContext(), QurcodeScanner.class));
    }
}