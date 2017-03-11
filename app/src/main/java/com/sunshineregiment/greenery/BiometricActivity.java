package com.sunshineregiment.greenery;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import butterknife.ButterKnife;

public class BiometricActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biometric);
        ButterKnife.inject(this);
    }
//rivate boolean gender;//false = male, true = female
    public boolean onClick(View view){
        int id = view.getId();
        if (id == R.id.btn_submit){
            SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("age", Integer.parseInt(((EditText)findViewById(R.id.age)).getText().toString()));
            editor.putFloat("height", Float.parseFloat((((EditText)findViewById(R.id.height)).getText().toString())));
            editor.putFloat("weight", Float.parseFloat((((EditText)findViewById(R.id.weight)).getText().toString())));
            editor.commit();
            Intent myIntent = new Intent(BiometricActivity.this, MainActivity.class);
            startActivity(myIntent);
        }
        return true;
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked) {
                    SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("gender", false);
                    editor.commit();
                    break;
                }
            case R.id.radio_female:
                if (checked) {
                    SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("gender", true);
                    editor.commit();
                    break;
                }
        }
    }
}
