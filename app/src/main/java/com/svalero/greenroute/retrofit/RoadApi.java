package com.svalero.greenroute.retrofit;

import com.svalero.greenroute.data.Road;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RoadApi {

    @GET("/greenroute/roads")
    Call<List<Road>> getRoads();
}
