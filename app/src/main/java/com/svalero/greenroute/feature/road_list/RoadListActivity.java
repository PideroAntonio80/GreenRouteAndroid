package com.svalero.greenroute.feature.road_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.svalero.greenroute.R;
import com.svalero.greenroute.data.Road;

import java.util.ArrayList;

public class RoadListActivity extends AppCompatActivity implements RoadListContract.view {

    private RoadListPresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager lManager;
    private LinearLayout layoutError;
    private ProgressBar loading;
    private Button retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_list);

        initComponents();

        presenter = new RoadListPresenter(this);
        presenter.getRoads(this);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                layoutError.setVisibility(View.GONE);

                presenter.getRoads(getBaseContext());
            }
        });
    }

    public void initComponents() {
        recyclerView = findViewById(R.id.rvRoad);
        layoutError = findViewById(R.id.activity_road_list_layout_error);
        loading = findViewById(R.id.pbLoading);
        retry = findViewById(R.id.bRetry);
    }

    @Override
    public void success(ArrayList<Road> roads) {
        recyclerView.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);
        layoutError.setVisibility(View.GONE);

        recyclerView.setHasFixedSize(true);
        lManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lManager);

        RoadListAdapter adapter = new RoadListAdapter(roads);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
        layoutError.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
    }
}