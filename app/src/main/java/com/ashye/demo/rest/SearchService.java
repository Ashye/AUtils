package com.ashye.demo.rest;

import com.ashye.rest.BaseApi;
import com.ashye.rest.converter.StringConverter;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Administrator on 2015/12/16.
 */
public class SearchService extends BaseApi {

    /**
     * 1. 定义接口
     */
    private interface SearchApi {
        @GET("/baidu")
        Call<String> search(@Query("kw") String key);
    }

    /**
     * 2. 初始化，并设置解析器
     */
    public SearchService() {
        super();
        init(new StringConverter());
    }

    private ResultListener<String> listener;
    public SearchService(ResultListener<String> listener) {
        this();
        this.listener = listener;
    }


    /**
     * 3. 获取接口实例，并请求
     * @param key
     * @param listener
     */
    public void search(String key, final ResultListener<String> listener) {
        SearchApi searchApi = getService(SearchApi.class);
        Call<String> call = searchApi.search(key);
        this.listener = listener;
        call.enqueue(new CallResultWrapper<String>(this.listener));
    }
}
