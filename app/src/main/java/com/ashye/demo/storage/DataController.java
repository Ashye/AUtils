package com.ashye.demo.storage;

import android.content.Context;

import com.ashye.storage.SharePrefStorage;

/**
 * Created by Administrator on 2015/12/18.
 */
public class DataController extends SharePrefStorage {

    private Context context;

    public DataController(Context context) {
        this.context = context;
    }


    public boolean save() {
        return this.save(context, "key", "value");
    }

    public boolean save(String dbName) {
        this.setSharePreferenceName(dbName);
        return save(context, "key", "value");
    }

    public void load(String key) {
        int value = this.loadInt(context, key);
    }


    @Override
    protected void destroy() {
        super.destroy();
        context = null;
    }
}
