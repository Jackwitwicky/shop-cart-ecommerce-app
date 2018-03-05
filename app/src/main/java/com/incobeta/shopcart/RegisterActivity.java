package com.incobeta.shopcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registerBackButton:
                //back to login
                finish();
                break;
            case R.id.registerButton:
                //sign up the user then proceed to home
                break;
        }
    }
}
