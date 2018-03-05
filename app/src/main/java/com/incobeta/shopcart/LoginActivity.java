package com.incobeta.shopcart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.goToRegisterButton:
                //open register activity
                Intent registerIntent = new Intent(this, RegisterActivity.class);
                startActivity(registerIntent);
                break;
            case R.id.loginButton:
                //login user and proceed to dashboard
                Intent dashboardIntent = new Intent(this, DashActivity.class);
                startActivity(dashboardIntent);
        }
    }
}
