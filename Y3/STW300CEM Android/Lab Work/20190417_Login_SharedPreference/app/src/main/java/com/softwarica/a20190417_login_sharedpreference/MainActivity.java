package com.softwarica.a20190417_login_sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login , btn_register;
    private EditText et_username, et_password;

    private String username, password;
    private Intent intent, intentDashboard;

    SharedPreferences preferences;
    private String sp_username, sp_password;

    InputMethodManager inputManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);


        intent = new Intent(MainActivity.this, Registration.class);
        intentDashboard = new Intent(MainActivity.this, Dashboard.class);

        preferences = getSharedPreferences("registration_data", Context.MODE_PRIVATE);
        inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:
                username = et_username.getText().toString();
                password = et_password.getText().toString();

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                sp_username = preferences.getString("username", "NA");
                sp_password = preferences.getString("password", "NA");

                if (username==sp_username && password==sp_password){
                    startActivity(intentDashboard);
                }else{
                   Toast.makeText(getApplicationContext(),"Username or Password incorrect.",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_register:
                startActivity(intent);
                break;
        }
    }
}