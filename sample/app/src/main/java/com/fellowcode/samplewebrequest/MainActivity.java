package com.fellowcode.samplewebrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.fellowcode.webrequest.ReqMethod;
import com.fellowcode.webrequest.RespListener;
import com.fellowcode.webrequest.WebRequest;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = (TextView)findViewById(R.id.notification);

        SendGETRequest();
    }

    void SendGETRequest(){
        RespListener listener = new RespListener() {
            @Override
            public void onResponse(String response) {
                notification.setText(response);
            }
        };
        WebRequest web = new WebRequest("http://google.com", listener);
        RequestQueue queue = Volley.newRequestQueue(this);
        //Add value
        web.AddField("key1", "value1");

        //Add array
        ArrayList<String> values = new ArrayList<>();
        values.add("value2");
        values.add("value3");
        web.AddList("key2", values);

        //start request
        queue.add(web);
    }
    void SendPOSTRequest(){
        RespListener listener = new RespListener() {
            @Override
            public void onResponse(String response) {
                notification.setText(response);
            }
        };

        //write your url for post request
        WebRequest web = new WebRequest(ReqMethod.POST, "http://url", listener);
        RequestQueue queue = Volley.newRequestQueue(this);
        //Add value
        web.AddField("key1", "value1");

        //Add array
        ArrayList<String> values = new ArrayList<>();
        values.add("value2");
        values.add("value3");
        web.AddList("key2", values);

        //start request
        queue.add(web);
    }
}
