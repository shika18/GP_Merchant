package com.example.shika.boo;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Spider extends AppCompatActivity {

    private static final String productURL = "http://192.168.1.3/LBA/api.php";

    List<PersonUtils> productList;
    RecyclerView recyclerView;
View vv;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spider);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);
        productList = new ArrayList<>();
      //  initViews();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, productURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject product = array.getJSONObject(i);
                                productList.add(new PersonUtils (
                                        product.getString("firstname"),
                                        product.getString("lastname"),
                                        product.getString("jobprofile"),
                                        product.getString("pik")
                                ));
                            }

                            CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(Spider.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void initViews() {
        //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Set Back Icon on Activity


        recyclerView = (RecyclerView) vv.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //Set RecyclerView type according to intent value

        //getSupportActionBar().setTitle("Staggered GridLayout Manager");
        recyclerView
                .setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));// Here 2 is no. of columns to be displayed

    }

}