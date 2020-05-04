package com.example.offertry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerview;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<HashMap<String, String>> arrayListNews;
    static String description1;
     static String discount1;
    static String instant1;
    static String shop1;
    static String code1;
    static  String day1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview = findViewById(R.id.RecyclerView);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerview.setLayoutManager(mLayoutManager);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        mRecyclerview.setLayoutManager(gridLayoutManager);



        callAPI();
    }
    private void callAPI() {//
        RequestQueue queue = Volley.newRequestQueue(this);
        //String url = "https://api.myjson.com/bins/1eits2";
       // String url = "https://alkakasbe2020.000webhostapp.com/Saree_img/offercomplate.json";
        String url = " http://www.pherywala.sparsematrix.co.in/sareeapp/sareeapp_offers/offercomplate.json";
        //String url = "https://chandansatyendraprasad.000webhostapp.com/tests";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("=====", "=========response:" + response);
                        parseAPIResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
    }

    private void parseAPIResponse(String response) {

        try {
            JSONObject objResponse = new JSONObject(response);
            JSONArray arrayHeadlines = objResponse.getJSONArray("headlines");
            arrayListNews = new ArrayList<>();

            for (int i = 0; i < arrayHeadlines.length(); i++) {
                JSONObject objItem = arrayHeadlines.getJSONObject(i);
                //String title = objItem.getString("title");
                String imgUrl = objItem.getString("imgUrl");
                String description = objItem.getString("description");

                String shop=objItem.getString("shop");
                String code=objItem.getString("code");
                String day=objItem.getString("day");

                String discount=objItem.getString("discount");

                 String instant=objItem.getString("instant");


                HashMap<String, String> map = new HashMap<>();
               // map.put("title", title);
                map.put("url", imgUrl);
                map.put("detail", description);
                map.put("co", code);
                map.put("int",instant);

                map.put("dis",discount);

                map.put("sh",shop);
                map.put("da",day);


                arrayListNews.add(map);
            }

            //set adapter
            mAdapter = new HomeListAdapter(MainActivity.this, arrayListNews);
            mRecyclerview.setAdapter(mAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
