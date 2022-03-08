package com.mytelecome.Interface;

import com.mytelecome.Modal.Login.Userlogin;
import com.mytelecome.Modal.VerifyInvoice.VerifyInvoice;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Apicall {
    @FormUrlEncoded
    @POST("index.php")
    Call<Userlogin> login(
            @Field("apikey") String apikey,
            @Field("login") String login,
            @Field("username") String username,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("index.php")
    Call<VerifyInvoice> verifyInvoice(
            @Field("invauth") String invauth,
            @Field("apikey") String apikey,
            @Field("verifyInvoice") String verifyInvoice,
            @Field("auth_key") String auth_key

    );
//
//    Call<ResponseLogin> login(
//            @Body String apikey,
//            @Body String login,
//            @Body String username,
//            @Body String password
//    );
}
