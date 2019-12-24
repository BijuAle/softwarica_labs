package com.example.a20190508networking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeClient {
    @GET("employees")
    Call<List<Employee>> getEmployees();
}
