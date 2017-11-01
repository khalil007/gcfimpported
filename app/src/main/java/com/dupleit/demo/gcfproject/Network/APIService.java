package com.dupleit.demo.gcfproject.Network;

import com.dupleit.demo.gcfproject.modal.UserUImodel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    //for login
    @FormUrlEncoded
    @POST("getUidata")
    Call<UserUImodel> getUidata(@Field("test") String test);

}