package com.sunshineregiment.greenery;

import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

/**
 * Opening splash page for application.
 */
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    /**
     * When user taps the screen, it takes them to the login page
     */
    public boolean onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_start) {
            Intent myIntent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(myIntent);
            return true;
        }
        return false;
    }
}
