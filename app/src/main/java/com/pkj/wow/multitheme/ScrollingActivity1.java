package com.pkj.wow.multitheme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pkj.wow.multitheme.adapter.RecyclerViewClickListener;
import com.pkj.wow.multitheme.adapter.ThemeAdapter;
import com.pkj.wow.multitheme.model.Theme;
import com.pkj.wow.multitheme.util.ThemeUtil;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity1 extends BaseActivity1 {
    public static List<Theme> mThemeList = new ArrayList<>();
    public static int selectedTheme = 0;
    private RecyclerView mRecyclerView;
    private ThemeAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initBottomSheet();
        prepareThemeData();
    }

    private void initBottomSheet(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new ThemeAdapter(mThemeList, this,new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ScrollingActivity1.this.recreate();
                    }
                },400);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),4);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void prepareThemeData() {
        mThemeList.clear();
        mThemeList.addAll(ThemeUtil.getThemeList());
        mAdapter.notifyDataSetChanged();
    }

    public void nextPage(View view) {
        startActivity(new Intent(this, DemoActivity.class));
    }
}
