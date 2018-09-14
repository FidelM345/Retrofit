package com.example.thebeast.retrofitapp.Remote;

import com.example.thebeast.retrofitapp.Model.Pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET
    Call<List<Pojo>> getNearByPlaces(@Url String url);


}
