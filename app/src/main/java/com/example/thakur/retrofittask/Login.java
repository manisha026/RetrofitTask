package com.example.thakur.retrofittask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
Button l_login;
EditText l_email,l_password;
    public String lemail,lpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        l_email=findViewById(R.id.l_email);
        l_password=findViewById(R.id.l_password);

        l_login=findViewById(R.id.l_login);
        l_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logins();


            }
        });
    }
    void logins() {

        RetrofitApi.getApi();
        ApiService apiService=RetrofitApi.retrofitApi.retrofit.create(ApiService.class);

        lemail=l_email.getText().toString();
        lpassword=l_password.getText().toString();

        apiService.userLogin(lemail,lpassword,"1","android").enqueue(new Callback<ShipperLoginModel>() {
            @Override
            public void onResponse(Call<ShipperLoginModel> call, Response<ShipperLoginModel> response) {
                String res=response.body().getSuccess();
                if (res.equalsIgnoreCase("1")){
                    Intent intent=new Intent(Login.this,Dashboard.class);
                    startActivity(intent);
                    Toast.makeText(Login.this, "success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Login.this, response.body().getMessage() , Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ShipperLoginModel> call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
