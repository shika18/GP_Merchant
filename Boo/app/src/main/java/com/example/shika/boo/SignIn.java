package com.example.shika.boo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignIn extends AppCompatActivity {
    Button ss;
   // FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ss = (Button) findViewById(R.id.button_signin);


    }

    public void reg(View v){
        Intent too = new Intent(this,MapsActivity.class);
        startActivity(too);
    }
}
