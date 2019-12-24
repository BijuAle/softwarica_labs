package com.example.a20190515_imageapipost;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    byte[] byteArray;
    EmployeeClient employeeClient;
    MultipartBody.Part body;

    EditText et_id, et_search;
    TextView tv_name, tv_salary, tv_age;
    Button btn_update;

    String BASE_URL;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        et_search = findViewById(R.id.et_Search);
        tv_age = findViewById(R.id.tv_age)
        tv_name = findViewById(R.id.tv_name);
        tv_salary = findViewById(R.id.tv_salary)

        toBitMap();
        toMultiPart();
        setBaseURL_Emp();
        initRequest();
    }

    void toBitMap() {
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.b);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byteArray = byteArrayOutputStream.toByteArray();
    }

    void toMultiPart() {
        body = MultipartBody.Part.createFormData(
                "image",
                "humming_bird",
                RequestBody.create(MediaType.parse("image/*"), byteArray)
        );
    }

    void setBaseURL_Emp() {
        BASE_URL = "https://api.imgur.com/";
    }

    void setBaseURL_Image() {
        BASE_URL = "https://demo/";
    }

    void initRequest() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(httpClient.build()).build();
        employeeClient = retrofit.create(EmployeeClient.class);


        Call<ResponseBody> call = employeeClient.upload("Client-ID 6803e8b51da1ab7", body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("TAG", response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                setBaseURL_Emp();
        }
    }
}
}

