package com.sunshineregiment.greenery;

/**
 * Object that handle the login activity
 * 
 * @author Sunshine Regiment
 *
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

	/**
	 * Loads up the login screen
	 * 
	 * @param the state of the application
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
    }

	/**
	 * Handle the button click activity
	 * 
	 * @param button
	 * @return boolean true
	 */
    public boolean onClick(View view){
        int id = view.getId();
        if (id == R.id.btn_login){
            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.link_signup) {
            Intent myIntent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(myIntent);
        }
        return true;
    }

}
