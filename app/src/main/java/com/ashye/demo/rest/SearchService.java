package com.ashye.demo.rest;

import com.ashye.rest.BaseApi;
import com.ashye.rest.converter.StringConverter;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.Url;

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


    private interface EchoApi {
        @GET
        Call<String> echo(@Url String url);
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

    public void setListener(ResultListener<String> listener) {
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

    public void echo(ResultListener<String> listener) {
        EchoApi echoApi = getService(EchoApi.class);
        Call<String> call = echoApi.echo("http://www.playaround.tk/echo");
        this.listener = listener;
        call.enqueue(new CallResultWrapper<String>(this.listener));
    }
}
