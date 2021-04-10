package com.svalero.greenroute.feature.road_list;

import android.content.Context;

import com.svalero.greenroute.data.Road;
import com.svalero.greenroute.retrofit.RoadNetwork;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoadListModel implements RoadListContract.Model {

    @Override
    public void getRoadsWS(Context context, final OnListRoadsListener onListRoadsListener) {

        RoadNetwork roadNetwork = new RoadNetwork(context);
        final Call<List<Road>> request = roadNetwork.getRoads();

        request.enqueue(new Callback<List<Road>>() {
            @Override
            public void onResponse(Call<List<Road>> call, Response<List<Road>> response) {
                if (response != null && response.body() != null) {
                    onListRoadsListener.resolve(new ArrayList<>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Road>> call, Throwable t) {
                t.fillInStackTrace();
                onListRoadsListener.reject(t.getLocalizedMessage());
            }
        });

    }
}
