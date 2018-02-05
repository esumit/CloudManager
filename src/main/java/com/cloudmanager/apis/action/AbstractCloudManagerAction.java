package com.cloudmanager.apis.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public abstract class AbstractCloudManagerAction{
    protected Gson getGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }
}
