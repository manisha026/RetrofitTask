package com.example.thakur.retrofittask;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Thakur on 6/26/2018.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("shipper_register ")
    Call<ShipperRegisterModel> Truckeruserregister(@Field("email")String email,
                                            @Field("password")String password,
                                             @Field("name")String name,
                                             @Field("city")String city,
                                             @Field("phone")String mobile,
                                                   @Field("company")String company_name,
                                                   @Field("state")String state,
                                                   @Field("device_type")String device_type,
                                                   @Field("reg_id")String reg_id);

    @FormUrlEncoded
    @POST("shipper_login")
    Call<ShipperLoginModel>userLogin(@Field("email")String email,
                                         @Field("password")String password,
                                         @Field("reg_id")String reg_id,
                                     @Field("device_type")String device_type);

}
