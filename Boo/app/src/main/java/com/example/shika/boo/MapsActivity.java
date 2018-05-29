package com.example.shika.boo;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;
import java.util.Map;

import eu.long1.spacetablayout.SpaceTabLayout;
import noman.googleplaces.NRPlaces;
import noman.googleplaces.Place;
import noman.googleplaces.PlaceType;
import noman.googleplaces.PlacesListener;

public class MapsActivity extends BaseActivity implements OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener {

    private GoogleMap mMap;
    private FrameLayout view_stub; //This is the framelayout to keep your content view
    private NavigationView navigation_view; // The new navigation view from Android Design Library. Can inflate menu resources. Easy
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentA fragmentA;
    InterstsFragment interstsFragment;
    ProfileFragment profileFragment;
    SavedOffersFragment savedOffersFragment;
    Myprof myprof;
    private FragmentB fragmentB;
    private Map fragmentMap;
    Intent too;
    private Menu drawerMenu;
    String[] listItems;
     static Button btn;

    SpaceTabLayout tabLayout;
    FragmentManager fragmentManager = getSupportFragmentManager();
    ViewPager viewPager;

    private BottomNavigationView bottomNavigationView;
    private static final LatLng MOUNTAIN_VIEW = new LatLng(29.866866, 31.315270);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     if(googleServicesAvailable()) {
         Toast.makeText(this, "done successfully..", Toast.LENGTH_LONG).show();
         setContentView(R.layout.activity_maps);
       //  initMap();} else {


     }



        btn = (Button) findViewById(R.id.popup);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                listItems = new String[]{"Minimum than 1 KM","Minimum than 2 KM","Minimum than 5 KM","Minimum than 10 KM","Minimum than 20 KM"};
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(MapsActivity.this);
                mbuilder.setTitle("Radius");
                mbuilder.setIcon(R.drawable.radi);
                int checkeditem;
                mbuilder.setSingleChoiceItems(listItems , -1,new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int i){
                      //  dialogInterface.dismiss();
                    }
                });
                mbuilder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int i){
                        dialogInterface.dismiss();
                    }
                });
                mbuilder.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int i){
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog mDialog = mbuilder.create();
                mDialog.show();
            }

        });


/*
        //add the fragments you want to display in a List
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentA());
        fragments.add(new FragmentB());
        fragments.add(new FragmentC());
        fragments.add(new FragmentD());
        fragments.add(new FragmentE());

        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_mainz);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (SpaceTabLayout) findViewById(R.id.spaceTabLayout);

        tabLayout.initialize(viewPager, fragmentManager, fragments , savedInstanceState);

        tabLayout.setTabOneOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Welcome to SpaceTabLayout", Snackbar.LENGTH_SHORT);

                snackbar.show();
            }
        });

        tabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "" + tabLayout.getCurrentPosition(), Toast.LENGTH_SHORT).show();
            }
        });
*/





            fragmentA =  new FragmentA();
            interstsFragment = new InterstsFragment();
        fragmentB =  new FragmentB();
profileFragment = new ProfileFragment();
savedOffersFragment = new SavedOffersFragment();
      //  fragmentMap =  new Map();
myprof = new Myprof();


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
      //  too = new Intent(this,FragmentA.class);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.inicioItem) {
                    finish();
                    startActivity(getIntent());
                    return true;
                }
                 else if (item.getItemId() == R.id.camaraItem) {
                    setFragment(interstsFragment);
                    return true;
                } else if (item.getItemId() == R.id.favoritosItem) {
                    setFragment(fragmentA);
return true;
                } else if (item.getItemId() == R.id.perfilItem) {
                  setFragment(myprof);
           // setFragment(savedOffersFragment);
                    return true;
                }

                return true;
            }
        });
    }




private void setFragment(Fragment fragment){
    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.main_frame,fragment);
    fragmentTransaction   .addToBackStack(null)
            .commit();
}

    private void setFragments(android.support.v4.app.Fragment frag){
        android.support.v4.app.FragmentTransaction fragmentTrans= getSupportFragmentManager().beginTransaction();
        fragmentTrans.replace(R.id.main_frame,frag);
        fragmentTrans.commit();
    }




  /*  public void  initMap(){
        MapFragment mapfragment =(MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapfragment.getMapAsync(this);
    }*/

   public boolean googleServicesAvailable(){
       GoogleApiAvailability api = GoogleApiAvailability.getInstance();
       int isAvailable = api.isGooglePlayServicesAvailable(this);
       if(isAvailable == ConnectionResult.SUCCESS){
           return true;
       }else if(api.isUserResolvableError(isAvailable)){
           Dialog dialog = api.getErrorDialog(this,isAvailable,0);
           dialog.show();
       }else{
           Toast.makeText(this, "can't connect to play services", Toast.LENGTH_LONG).show();
       }
         return false;
   }

    public void onMapReady(GoogleMap map) {

/*
        new NRPlaces.Builder()
                .listener((PlacesListener) this)
                .key("AIzaSyBP53_cPyIpb-9Xk4sQp3Irpz-HRFeIJws")
                .latlng(33.721328, 73.057838)
                .radius(500)
                .type(PlaceType.GYM)
                .build()
                .execute();

*/


        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(MOUNTAIN_VIEW)      // Sets the center of the map to Mountain View
                .zoom(17)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private void goToLocation(double lat , double lng){
        LatLng ll = new LatLng(lat , lng);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(ll);
        mMap.moveCamera(cameraUpdate);
    }


    public boolean onNavigationItemSelected(MenuItem menuitem) {
        Intent x;
        Class fragmentClass;
        int id = menuitem.getItemId();

         if(id == R.id.ctg){
            x = new Intent(this, MainActivity.class);
            startActivity(x);}
        else if(id == R.id.likes){
            x = new Intent(this, SavedOffers.class);
            startActivity(x);}
        else if(id == R.id.prize){
            x = new Intent(this, RewardsActivity.class);
            startActivity(x);}
        else if(id == R.id.login){
            x = new Intent(this, SignIn.class);
            startActivity(x);}

        else if(id == R.id.main){
            x = new Intent(this, MapsActivity.class);
            startActivity(x);}

        return false;

    }

    private void setupdrawercontent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            public boolean onNavigationItemSelected(MenuItem item){
                onNavigationItemSelected(item);
                return true;
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }



}