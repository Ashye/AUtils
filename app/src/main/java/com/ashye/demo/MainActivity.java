package com.ashye.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ashye.demo.rest.SearchService;
import com.ashye.demo.storage.DataController;
import com.ashye.rest.BaseApi;
import com.ashye.restdemo.R;

import java.nio.channels.IllegalSelectorException;

public class MainActivity extends AppCompatActivity {

    private DataController dataController;
    private SearchService searchService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataController = new DataController(this);
//        demo();
    }


    private void demo() {
        searchService = new SearchService();
        searchService.echo(new BaseApi.ResultListener<String>() {
            @Override
            public void onSuccess(String data) {
                Log.e("sss", ""+data);
            }

            @Override
            public void onFailure(String error) {
                Log.e("ssssssssaaaaa", ""+error);
            }
        });
    }
}
