package com.softwarica.a20190520_apiapplication;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface HeroClient {

    @GET("heroes")
    Call<List<Hero>> getHeroes();

    @GET("heroes/{id}")
    Call<Hero> getHeroById(@Path("id") int id);

    @POST("heroes")
    Call<Void> addHero(@Body Hero hero);

    @PUT("heroes/{id}")
    Call<Void> updateHero(@Path("id") String id, @Body Hero hero);

    @DELETE ("heroes/{id}")
    Call<Void> deleteHero(@Path("id") String id);
}



