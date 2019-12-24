package com.softwarica.a20190520_apiapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String HOST = "http://127.0.0.1:3000";
    Retrofit retrofit;
    HeroClient heroClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadHeroes();
    }

    private void createInstance() {
        retrofit = new Retrofit.Builder().baseUrl(HOST).addConverterFactory(GsonConverterFactory.create()).build();
        heroClient = retrofit.create(HeroClient.class);
    }

    private void loadHeroes() {
        createInstance();
        Call<List<Hero>> callHero = heroClient.getHeroes();
        callHero.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroList = response.body();
                Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
