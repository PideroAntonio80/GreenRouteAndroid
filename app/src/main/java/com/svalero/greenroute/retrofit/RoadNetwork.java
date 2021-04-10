package com.svalero.greenroute.retrofit;

import android.content.Context;

import com.svalero.greenroute.data.Road;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RoadNetwork {

    private static final String URL_ROADS = "http://192.168.1.142:8080/";

    private Retrofit retrofit;
    private Context context;

    public RoadNetwork(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(URL_ROADS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<List<Road>> getRoads() {
        RoadApi api = retrofit.create(RoadApi.class);
        return api.getRoads();
    }
}
