package com.softwarica.a20190407_androidjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSave, btnPrint;

    EditText txtId, txtName, txtAddress;

    ArrayList<User> userList;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        btnSave  = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnPrint = findViewById(R.id.btnPrint);
        btnPrint.setOnClickListener(this);

        txtId = findViewById(R.id.userId);
        txtName =findViewById(R.id.userName);
        txtAddress = findViewById(R.id.userAddress);
        userList = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Log.d("TAG", FlowerFactory.getFlower("Orchid"));
        Log.d("TAG", FlowerFactory.getFlower("Rose"));*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:

                user = new User();
                user.setId(txtId.getText().toString());
                user.setAddress(txtAddress.getText().toString());
                user.setName(txtName.getText().toString());
                userList.add(user);

                break;
            case R.id.btnPrint:
                for(int i =0; i<userList.size(); i++){
                    Log.d("TAG", (userList.get(i)).toString());
                }
        }
    }


}
