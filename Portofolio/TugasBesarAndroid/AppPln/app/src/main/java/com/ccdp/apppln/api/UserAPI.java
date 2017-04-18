package com.ccdp.apppln.api;

import com.ccdp.apppln.model.LoginResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Asus on 3/7/2017.
 */
public interface UserAPI {
    @FormUrlEncoded

    @POST("user/login")
    Call<LoginResult> login(@Field("username") String username,@Field("password") String password);

    @FormUrlEncoded
    @POST("user/logout")
    Call<LoginResult> logout(@Field("token") String token);

}
