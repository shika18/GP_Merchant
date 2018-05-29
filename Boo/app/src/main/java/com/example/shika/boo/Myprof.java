package com.example.shika.boo;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import angtrim.com.fivestarslibrary.FiveStarsDialog;
import angtrim.com.fivestarslibrary.NegativeReviewListener;
import angtrim.com.fivestarslibrary.ReviewListener;

public class Myprof extends android.app.Fragment {
    private ViewPager viewPager;
  //  FragmentManager fragmentManager = getSupportFragmentManager();
    String[] listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vi = inflater.inflate(R.layout.activity_myprof, container, false);
      //  getSupportActionBar().hide();
        MapsActivity.btn.setVisibility(View.GONE);

        CardView cardView = (CardView) vi.findViewById(R.id.car1);
        CardView cardView2 = (CardView) vi.findViewById(R.id.car2);
        CardView cardView3 = (CardView) vi.findViewById(R.id.car3);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent in = new Intent(getActivity(),SavedOffers.class);
                startActivity(in);

            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent in = new Intent(getActivity(),Saved_offActivity.class);
                startActivity(in);

            }
        });

        return vi;
    }
}





