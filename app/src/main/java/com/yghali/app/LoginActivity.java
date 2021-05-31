package com.yghali.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText login, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);



//        connetionBtn.setEnabled(false);
//
//        if (login.getText().length() !=0 && pwd.getText().length() !=0 )
//            connetionBtn.setEnabled(true);

    }

    public void LogIn(View view) {
        login = findViewById(R.id.loginTxt);
        pwd = findViewById(R.id.passwordTxt);
        findViewById(R.id.enregistrerBTN).setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });



    }
}