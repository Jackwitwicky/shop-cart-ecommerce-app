package com.incobeta.shopcart;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0f);
        }

        //setup the fab
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.dashboardCartFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cartIntent = new Intent(DashActivity.this, CartActivity.class);
                startActivity(cartIntent);
            }
        });

        //setup the tab
        TabLayout tabLayout = findViewById(R.id.categoryTab);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().toString().equals(getResources().getString(R.string.women_text))) {
                    //open women clothes
                    WomenFragment womenFragment = new WomenFragment();

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.mainContent, womenFragment).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //open women tab by default
        //open women clothes
        WomenFragment womenFragment = new WomenFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainContent, womenFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            //open cart activity
            Intent cartIntent = new Intent(this, CartActivity.class);

            startActivity(cartIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
