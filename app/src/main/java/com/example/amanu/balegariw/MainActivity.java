package com.example.amanu.balegariw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.transition.Slide;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
int x = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton toggle = findViewById(R.id.menu_button);
        final DrawerLayout NavDrawer = findViewById(R.id.drawer_layout);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(x == 1){
                    NavDrawer.openDrawer((int) Gravity.LEFT);
                    x  = 2;
                }else{
                    NavDrawer.closeDrawer((int) Gravity.LEFT);
                    x  = 1;
                }
            }

        });
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new MapFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_container, fragment)
                    .commit();
            return true;

        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        Fragment fragment = null;
        switch (Item.getItemId()){
            case R.id.navigation_home:
                fragment = new RoutesFragment();
                break;
            case R.id.navigation_dashboard:
                fragment = new MapFragment();
                break;
            case R.id.navigation_notifications:
                fragment = new MessagesFragment();
                break;
        }
        return loadFragment(fragment);
    }


}