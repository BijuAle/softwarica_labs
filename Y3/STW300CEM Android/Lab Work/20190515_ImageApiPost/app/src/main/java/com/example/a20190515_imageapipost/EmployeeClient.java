package com.example.a20190515_imageapipost;


import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface EmployeeClient {

    @GET("employee/{id}")
    Call<Employee> getEmployeeById(@Path("id") int id);

    @POST("3/upload")
    @Multipart
    Call<ResponseBody> upload(@Header("Authorization") String clientId, @Part() MultipartBody.Part file);

    @PUT("update/{id}")
    Call<ResponseBody> updateEmployee(
            @Path("id") String id,
            @Body Employee employee
    );
}