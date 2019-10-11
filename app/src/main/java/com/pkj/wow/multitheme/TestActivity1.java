package com.pkj.wow.multitheme;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class TestActivity1 extends BaseActivity1 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
