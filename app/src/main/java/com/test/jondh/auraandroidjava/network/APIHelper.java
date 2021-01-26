package com.test.jondh.auraandroidjava.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;

public class APIHelper {

    private static APIHelper instance;
    public static APIHelper getInstance(Context context) {
        if (instance == null) {
            instance = new APIHelper(context);
        }
        return instance;
    }

    private final RequestQueue queue;

    private APIHelper(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public void getImageInfo(String imageId, Response.Listener<PicsumInfo> listener, Response.ErrorListener errorListener) {
        String url = String.format(Locale.getDefault(), "https://picsum.photos/id/%s/info", imageId);
        Gson gson = new Gson();
        SimpleVolleyRequest<PicsumInfo> simpleVolleyRequest = new SimpleVolleyRequest<PicsumInfo>(url,null, listener, errorListener) {

            @Override
            public PicsumInfo get(String json) {
                return gson.fromJson(json, PicsumInfo.class);
            }

        };
        queue.add(simpleVolleyRequest);
    }

    public void getList(Response.Listener<List<PicsumInfo>> listener, Response.ErrorListener errorListener) {
        String url = "https://picsum.photos/v2/list";
        Gson gson = new Gson();
        SimpleVolleyRequest<List<PicsumInfo>> simpleVolleyRequest = new SimpleVolleyRequest<List<PicsumInfo>>(url, null, listener, errorListener) {

            @Override
            public List<PicsumInfo> get(String json) {
                Type collectionType = new TypeToken<List<PicsumInfo>>(){}.getType();
                return gson.fromJson(json, collectionType);
            }

        };
        queue.add(simpleVolleyRequest);
    }
}
