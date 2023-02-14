package com.salvador.mariscal.guiapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.salvador.mariscal.guiapractica.Model.Digimons;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> datos=new ArrayList<>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listViewNoticias);
        arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, datos);
        listView.setAdapter(arrayAdapter);
        getDigimons();
    }

    private void getDigimons(){

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://digimon-api.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApiDigimon DigimonApi =  retrofit.create(MyApiDigimon.class);
        Call<List<Digimons>> call= DigimonApi.getDigimons();
        call.enqueue(new Callback<List<Digimons>>() {
            @Override
            public void onResponse(Call<List<Digimons>> call, Response<List<Digimons>> response) {
                for (Digimons digimon: response.body()){
                    datos.add(digimon.getName());
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Digimons>> call, Throwable t) {

            }
        });

    }

}