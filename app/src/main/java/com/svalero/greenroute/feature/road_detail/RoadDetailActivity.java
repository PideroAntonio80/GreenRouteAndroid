package com.svalero.greenroute.feature.road_detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.svalero.greenroute.R;
import com.svalero.greenroute.data.Road;

public class RoadDetailActivity extends AppCompatActivity {

    private ImageView imageDetail;
    private TextView nameDetail, dateDetail, lengthDetail, tollDetail;

    private Road road;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_detail);

        initComponents();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            road = (Road) bundle.getSerializable("my_road");
        }

        showRoad();
    }

    public void initComponents() {
        imageDetail = findViewById(R.id.ivRoadDetailImage);
        nameDetail = findViewById(R.id.tvRoadDetailName);
        dateDetail = findViewById(R.id.tvRoadDetailDate);
        lengthDetail = findViewById(R.id.tvRoadDetailLength);
        tollDetail = findViewById(R.id.tvRoadDetailToll);
    }

    public void showRoad() {
        Picasso.get().load(road.getImage()).into(imageDetail);
        nameDetail.setText(road.getName());
        dateDetail.setText(road.getBuildDate());
        lengthDetail.setText(String.valueOf(road.getLength()));
        Resources res = getResources();
        String positive = res.getString(R.string.positive);
        String negative = res.getString(R.string.negative);
        String option = "";
        option = road.isToll() ? positive : negative;
        tollDetail.setText(option);
    }
}