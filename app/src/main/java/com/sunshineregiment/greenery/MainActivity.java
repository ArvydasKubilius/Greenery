package com.sunshineregiment.greenery;

/**
 * Object that handles the main activity after login
 * 
 * @author Sunshine Regiment
 *
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

	/**
	 * Set up the fundamental layout of the app
	 * 
	 * @param the state of the application
	 */
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //add four tabs to it
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("YOUR IMPACT"));
        tabLayout.addTab(tabLayout.newTab().setText("GRAPHS"));
        tabLayout.addTab(tabLayout.newTab().setText("STEPS"));
        tabLayout.addTab(tabLayout.newTab().setText("LEADERBOARDS"));
        //set the gravity
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        StepCounter stepCounter = new StepCounter();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            	//When 2nd tab is chosen
                if(tab.getPosition() == 2){
                    //get total steps
                    SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                    int steps = prefs.getInt("steps", 0);
                    TextView dayTextView, weekTextView, lifeTextView;
                    dayTextView = (TextView) findViewById(R.id.steps_textView);
                    weekTextView = (TextView) findViewById(R.id.steps_textView2);
                    lifeTextView = (TextView) findViewById(R.id.steps_textView3);
                    dayTextView.setText("" + steps + " Steps");
                    weekTextView.setText("" + (steps+5432) + " Steps");
                    lifeTextView.setText("" + (steps+87654) + " Steps");
                }
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

	/**
	 * Create options menu
	 * 
	 * @param menu
	 * @return boolean true
	 */
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

	/**
	 * Carry out associated option when drop-down menu item is selected
	 * 
	 * @param menu item
	 * @return boolean true
	 */
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(myIntent);
        }
        return true;
    }
}
