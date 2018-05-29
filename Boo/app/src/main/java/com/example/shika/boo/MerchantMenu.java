package com.example.shika.boo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MerchantMenu extends AppCompatActivity {

    List<Merchant_Menu> lstBook ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_menu);

        lstBook = new ArrayList<>();
        lstBook.add(new Merchant_Menu(R.drawable.mu1));
        lstBook.add(new Merchant_Menu(R.drawable.mu2));
        lstBook.add(new Merchant_Menu(R.drawable.mu3));
        lstBook.add(new Merchant_Menu(R.drawable.mu4));
        lstBook.add(new Merchant_Menu(R.drawable.mu2));
        lstBook.add(new Merchant_Menu(R.drawable.mu1));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        Merchant_RecyclerViewAdapter myAdapter = new Merchant_RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);


    }
}