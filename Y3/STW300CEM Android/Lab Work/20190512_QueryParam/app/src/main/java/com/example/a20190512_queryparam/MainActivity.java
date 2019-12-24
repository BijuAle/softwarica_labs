package com.example.a20190512_queryparam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_get;
    TextView tv_emp;
    EditText et_emp_id;

    EmployeeClient employeeClient;
    static final String TAG = "JOE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_get = findViewById(R.id.btn_get);
        btn_get.setOnClickListener(this);

        tv_emp = findViewById(R.id.tv_emp);
        et_emp_id = findViewById(R.id.et_emp_id);

        initRequest();
    }

    void initRequest() {
        String BASE_URL = "http://dummy.restapiexample.com/api/v1/";
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(httpClient.build()).build();
        employeeClient = retrofit.create(EmployeeClient.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:

                Call<Employee> call = employeeClient.getEmployeeById(Integer.parseInt(et_emp_id.getText().toString()));
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        Log.d(TAG, response.body().toString());
                        tv_emp.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Log.d(TAG, t.getLocalizedMessage());
                    }
                });

        }
    }

}
