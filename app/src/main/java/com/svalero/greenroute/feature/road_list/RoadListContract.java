package com.svalero.greenroute.feature.road_list;

import android.content.Context;

import com.svalero.greenroute.data.Road;

import java.util.ArrayList;

public interface RoadListContract {

    interface view {
        void success(ArrayList<Road> roads);
        void error(String message);
    }

    interface Presenter{
        void getRoads(Context context);
    }

    interface Model{

        void getRoadsWS(Context context, OnListRoadsListener onListRoadsListener);

        interface OnListRoadsListener{
            void resolve(ArrayList<Road> roads);
            void reject(String message);
        }
    }
}
