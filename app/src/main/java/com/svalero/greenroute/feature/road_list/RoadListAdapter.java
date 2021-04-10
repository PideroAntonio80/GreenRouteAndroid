package com.svalero.greenroute.feature.road_list;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.svalero.greenroute.R;
import com.svalero.greenroute.data.Road;
import com.svalero.greenroute.feature.road_detail.RoadDetailActivity;

import java.util.ArrayList;

public class RoadListAdapter extends RecyclerView.Adapter<RoadListAdapter.RoadViewHolder> {

    private ArrayList<Road> roads;

    public RoadListAdapter(ArrayList<Road> roads) {
        this.roads = roads;
    }

    public static class RoadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView image;
        public TextView name;
        public TextView date;
        public Context context;
        public CardView card;

        public Road myRoad;

        public RoadViewHolder(@NonNull View v) {
            super(v);

            context = v.getContext();
            card = v.findViewById(R.id.cvRoad);
            image = v.findViewById(R.id.ivRoad);
            name = v.findViewById(R.id.tvRoadName);
            date = v.findViewById(R.id.tvRoadDate);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, RoadDetailActivity.class);
            intent.putExtra("my_road", myRoad);
            context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public RoadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_road, parent,false);

        return new RoadViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RoadViewHolder holder, int position) {
        Road road = roads.get(position);

        Picasso.get().load(road.getImage()).into(holder.image);
        holder.name.setText(road.getName());
        holder.date.setText(road.getBuildDate());

        holder.myRoad = road;
    }

    @Override
    public int getItemCount() {
        return roads.size();
    }


}
