package com.example.thebeast.retrofitapp;

import com.example.thebeast.retrofitapp.Remote.ApiClient;
import com.example.thebeast.retrofitapp.Remote.ApiInterface;

public class ClientInterface_Connection {


    private static final String GOOGLE_API_URL="https://jsonplaceholder.typicode.com/";

    public static ApiInterface apiInterface(){

        return ApiClient.getClient(GOOGLE_API_URL).create(ApiInterface.class);
    }
}
