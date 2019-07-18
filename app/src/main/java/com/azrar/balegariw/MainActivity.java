package com.azrar.balegariw;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ImageView navHeader;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Demo");
        navHeader = findViewById(R.id.logoNav);


        drawerLayout = findViewById(R.id.container);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.navigation_view);
        View naView = navigationView.inflateHeaderView(R.layout.navigation_header);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                UserMenuSelector(menuItem);
                return false;
            }
        });


    }

    private void UserMenuSelector(MenuItem menuItem) {

        switch (menuItem.getItemId()) {


            case R.id.nav_messages:
                SendUserToMessageActivity();
                break;

            case R.id.nav_settings:
                SendUserToSettingsActivity();
                break;

            case R.id.nav_about:
               SendUserToAbouttActivity();
                break;
        }

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)){

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void SendUserToSettingsActivity()
    {
        Intent SettingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(SettingsIntent);
    }

    private void SendUserToAbouttActivity()
    {
        Intent AboutIntent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(AboutIntent);
    }

    private void SendUserToMessageActivity() {

        Intent MessageIntent = new Intent(MainActivity.this, MessagesActivity.class);
        startActivity(MessageIntent);
    }




    private void ShowToast (String message){

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}