package com.example.iit.navigation;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        /*if (id == R.id.home) {
            fragment = new HomeFragment();
        }*/
        if (id == R.id.fb) {
            bundle.putString("url", "https://www.facebook.com/androidhungerAH");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.gplus) {
            bundle.putString("url", "https://plus.google.com/+Androidhunger");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.twitter) {
            bundle.putString("url", "https://www.twitter.com/android_hunger");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.github) {
            bundle.putString("url", "https://github.com/avinashn/androidhunger.com");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.youtube) {
            bundle.putString("url", "https://www.youtube.com/androidhunger");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
