package com.example.shika.boo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FragmentA extends android.app.Fragment {

    ListView listView;
    ImageButton favbtn;
    // Array of integers points to images stored in .... res/drawable
    int[] flags = new int[]{
            R.drawable.b1,
            R.drawable.b10,
            R.drawable.b11,
            R.drawable.b12,
            R.drawable.b2,
            R.drawable.b3,
            R.drawable.b4,
            R.drawable.b5,
            R.drawable.b6,
            R.drawable.b8,
            R.drawable.bb,
            R.drawable.bb2,
            R.drawable.bb3,
            R.drawable.bb4,
            R.drawable.bb5,
            R.drawable.bb6,
            R.drawable.bb7,
            R.drawable.bb8,
            R.drawable.bb9,
            R.drawable.bb10,
            R.drawable.bb11,
            R.drawable.bb12,
            R.drawable.bb13,
            R.drawable.bb14,
            R.drawable.bb16,
            R.drawable.bb17,
            R.drawable.bb18,
            R.drawable.bb19,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vi= inflater.inflate(R.layout.fragment_a, container, false);

        MapsActivity.btn.setVisibility(View.GONE);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 18; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("logo", Integer.toString(flags[i]));
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = {"logo"};

        // Ids of views in listview_layout
        int[] to = {R.id.logo};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), aList, R.layout.favlist, from, to);


        listView = (ListView) vi.findViewById(R.id.listview);






        // Setting the adapter to the listView
        listView.setAdapter(adapter);

        return vi;
    }


}
