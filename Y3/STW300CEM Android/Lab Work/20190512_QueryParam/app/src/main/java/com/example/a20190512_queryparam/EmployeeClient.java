package com.example.a20190512_queryparam;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeClient {

    @GET("employee/{id}")
    Call<Employee> getEmployeeById(
            @Path("id") int id
    );
}
