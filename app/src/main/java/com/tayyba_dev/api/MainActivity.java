package com.tayyba_dev.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.tayyba_dev.api.adapter.CustomAdapter;
import com.tayyba_dev.api.model.Hits;
import com.tayyba_dev.api.services.GetData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Hits> hits;
    ListView listView;
    CustomAdapter customAdapter;
    ArrayList<Hits> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.view);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GetData.baseur)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetData getData=retrofit.create(GetData.class);
        Call<List<Hits>> call=getData.getResult();

        call.enqueue(new Callback<List<Hits>>() {
            @Override
            public void onResponse(Call<List<Hits>> call, Response<List<Hits>> response) {

               hits=response.body();
               sendData();


            }

            @Override
            public void onFailure(Call<List<Hits>> call, Throwable t) {

            }
        });

    }

    void sendData() {
    customAdapter= new CustomAdapter(MainActivity.this,hits);
    listView.setAdapter(customAdapter);}
}