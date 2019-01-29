package com.example.retrofit.retrofits;

import com.example.retrofit.models.FlowerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerServiceApi {

    @GET("bins/ypmow")
    Call<FlowerResponse> getFlowerResponse();

}
