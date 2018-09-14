package com.example.thebeast.retrofitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.thebeast.retrofitapp.Model.Pojo;
import com.example.thebeast.retrofitapp.Remote.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Recycler_Adapter recycler_adapter;

    List<Pojo> bloglist;

    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface=ClientInterface_Connection.apiInterface();//intilizing retrofit interface

        bloglist=new ArrayList<>();




        nearByPlace();


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);







    }


    private void nearByPlace() {


        String url=getUrl();

        apiInterface.getNearByPlaces(url)
                .enqueue(new Callback<List<Pojo>>() {
                    @Override
                    public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {


                        bloglist=response.body();//results are stored in this list
                        recycler_adapter=new Recycler_Adapter(bloglist);
                        recyclerView.setAdapter(recycler_adapter);
                    }

                    @Override
                    public void onFailure(Call<List<Pojo>> call, Throwable t) {

                    }
                });



    }



    private String getUrl() {

        StringBuilder googlePlacesUri=new StringBuilder("https://jsonplaceholder.typicode.com");
        googlePlacesUri.append("/posts");

        return googlePlacesUri.toString();
    }
}
