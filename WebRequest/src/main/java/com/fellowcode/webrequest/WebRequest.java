package com.fellowcode.webrequest;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

/**
 * Created by sergo on 11.09.2017.
 */

public class WebRequest extends StringRequest{
    private ArrayList<String> keys;
    private ArrayList<String> values;

    public WebRequest(String url, Response.Listener<String> listener) {
        super(Method.GET, url, listener, null);

        keys = new ArrayList<>();
        values = new ArrayList<>();
    }
    public WebRequest(int method, String url, Response.Listener<String> listener) {
        super(method, url, listener, null);

        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    public void AddField(String key, String value)
    {
        keys.add(key);
        values.add(value);
    }
    public void AddList(String key, ArrayList<String> value){
        for(String aValue : value) AddField(key, aValue);
    }
    public void AddList(String key, String[] value){
        for (String aValue : value) AddField(key, aValue);
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        if (keys.size() > 0) {
            StringBuilder builder = new StringBuilder("");
            for (int i=0;i<keys.size();i++) {
                builder.append("&").append(keys.get(i));
                builder.append("=").append(values.get(i));
            }
            if (builder.length() > 0) { // ! isEmpty()
                builder.deleteCharAt(0);
            }
            Log.d("deb6", builder.toString());
            return builder.toString().getBytes();
        }
        return null;
    }
}
