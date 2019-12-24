package com.softwarica.a20190417_login_sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    private EditText et_firstname, et_lastname, et_username, et_password;

    private String firstname, lastname, username, password;
    private Button btn_register, btn_goto_login;
    private Intent intent;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        et_firstname = findViewById(R.id.et_firstname);
        et_lastname = findViewById(R.id.et_lastname);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
        btn_goto_login = findViewById(R.id.btn_goto_login);
        btn_goto_login.setOnClickListener(this);

        intent = new Intent(Registration.this, MainActivity.class);
        preferences = getSharedPreferences("registration_data", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                firstname = et_firstname.getText().toString();
                lastname = et_lastname.getText().toString();
                username = et_username.getText().toString();
                password = et_password.getText().toString();

                editor.putString("firstname", firstname);
                editor.putString("lastname", lastname);
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();

                break;
            case R.id.btn_goto_login:
                startActivity(intent);
                break;
        }
    }
}
