package com.example.amanu.balegariw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
