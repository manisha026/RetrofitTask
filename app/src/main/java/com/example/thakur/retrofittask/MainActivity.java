package com.example.thakur.retrofittask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
Button r_register;
TextView r_login;
EditText r_email,r_password,r_name,r_city,r_company,r_phone,r_state;

public String remail,rpassword,rname,rcity,rcompany,rphone,rstate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r_email=findViewById(R.id.r_email);
        r_password=findViewById(R.id.r_password);
        r_name=findViewById(R.id.r_name);
        r_city=findViewById(R.id.r_city);
        r_company=findViewById(R.id.r_company);
        r_phone=findViewById(R.id.r_phone);
        r_state=findViewById(R.id.r_state);

        r_register=findViewById(R.id.r_register);
        r_login=findViewById(R.id.r_login);

        r_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent=new Intent(MainActivity.this,Dashboard.class);
//                startActivity(intent);


                Register();

            }
        });

        r_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
    }

    void Register() {


        RetrofitApi.getApi();
        ApiService apiService=RetrofitApi.retrofitApi.retrofit.create(ApiService.class);

        remail=r_email.getText().toString();
        rpassword=r_password.getText().toString();
        rname=r_name.getText().toString();
        rcity=r_city.getText().toString();
        rcompany=r_company.getText().toString();
        rphone=r_phone.getText().toString();
        rstate=r_state.getText().toString();

        apiService.Truckeruserregister(remail,rpassword,rname,rcity,rphone,rcompany,rstate,"1","android").enqueue(new Callback<ShipperRegisterModel>() {
            @Override
            public void onResponse(Call<ShipperRegisterModel> call, Response<ShipperRegisterModel> response) {

                String res=response.body().getSuccess();

                if (res.equalsIgnoreCase("1")){
                    Intent intent=new Intent(MainActivity.this,Dashboard.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, response.body().getMessage() , Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ShipperRegisterModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}