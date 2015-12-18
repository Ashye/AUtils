package com.ashye.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashye.demo.rest.SearchService;
import com.ashye.demo.storage.DataController;
import com.ashye.rest.BaseApi;
import com.ashye.restdemo.R;

public class MainActivity extends AppCompatActivity {

    private DataController dataController;
    private SearchService searchService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataController = new DataController(this);
        searchService = new SearchService(new BaseApi.ResultListener<String>() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onFailure(String error) {

            }
        });
    }
}
