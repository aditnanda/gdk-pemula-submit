package com.nand_project.praktikumdesainkomputer;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView recyclerView;

    RecyclerViewAdapter myAdapter;

    ArrayList<Model> dataSet;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet = new ArrayList<>();

        recyclerView = findViewById(R.id.recycle);

        // SwipeRefreshLayout
        mSwipeRefreshLayout = findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        if(myAdapter != null){
            dataSet.clear();
            myAdapter.notifyDataSetChanged();
            onPost();
        }else {
            onPost();
        }




    }

    private void onPost() {
        mSwipeRefreshLayout.post(new Runnable() {

            @Override
            public void run() {

                mSwipeRefreshLayout.setRefreshing(true);
                initData();
            }
        });


    }

    private void initData() {
        mSwipeRefreshLayout.setRefreshing(true);
        Model model = new Model("Pengembangan Teknologi Mobile","Pada praktikum ini diharapkan mahasiswa dapat mengetahui cara membuat aplikasi Android","Senin-Sabtu",R.drawable.android);
        dataSet.add(model);

        model = new Model("Pengembangan Teknologi Website","Pada praktikum ini diharapkan mahasiswa dapat mengetahui cara membuat web menggunakan PHP Codeigniter","Senin-Sabtu",R.drawable.codeigniter);
        dataSet.add(model);

        model = new Model("Dasar Komputer","Pada praktikum ini diharapkan mahasiswa dapat mengetahui dasar-dasar komputer","Sabtu",R.drawable.daskom);
        dataSet.add(model);

        setAdapter(dataSet);
        mSwipeRefreshLayout.setRefreshing(false);

    }

    private void setAdapter(ArrayList<Model> list){

        myAdapter = new RecyclerViewAdapter(MainActivity.this, list) ;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onRefresh() {
        if(myAdapter != null){
            dataSet.clear();
            myAdapter.notifyDataSetChanged();
            initData();
        }else {
            initData();
        }

    }
}