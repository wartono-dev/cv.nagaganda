package com.wartono.my.API;

import com.wartono.my.Model.Login.ResponLoginData;
import com.wartono.my.Model.Register.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {


     @FormUrlEncoded
     @POST("login.php")
     Call<ResponLoginData> loginResponse (
             @Field("username") String username,
             @Field("password") String password
     );

     @FormUrlEncoded
     @POST("ResponseRegister.php")
     Call<ResponseRegister> RegisterResponse (
             @Field("username") String username,
             @Field("name") String name,
             @Field("password") String password
     );

}



