package com.salvador.mariscal.guiapractica;

import com.salvador.mariscal.guiapractica.Model.Digimons;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyApiDigimon {

    String API_ROUTE="/api/digimon";

    @GET(API_ROUTE)
    Call<List<Digimons>> getDigimons();

    @FormUrlEncoded
    @POST(API_ROUTE)
    Call<List<Digimons>> postDigimons(
            @Field("name") String name,
            @Field("url") String url,
            @Field("level") String lvl

    );
}
