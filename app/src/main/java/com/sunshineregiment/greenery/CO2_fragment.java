package com.sunshineregiment.greenery;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Zikoz on 10/03/2017.
 */
public class CO2_fragment extends Fragment {
    
    private BiometricProfile profile;
    private Conversions conversion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_co2, container, false);
    }

    //private boolean resumeHasRun = false;

    @Override
    public void onResume() {
        
        super.onResume();
        ImageView image = (ImageView) getActivity().findViewById(R.id.img_switcher);
        TextView convertToLitres = (TextView) getActivity().findViewById(R.id.conversion_liters);
        TextView convertToCo2 = (TextView) getActivity().findViewById(R.id.conversion_co2_grams);
        TextView convertToTrees = (TextView) getActivity().findViewById(R.id.conversion_trees);

        int n = 3;
        image.setScaleX(n);
        image.setScaleY(n);

        drawTree(image);
        profile = new BiometricProfile(20, 70, 1.75, false);//age, weight, height, gender
        conversion = new Conversions(2000,profile,true);//steps taken, profile, diesel engine (true = yes)
        showLit(convertToLitres, conversion);
        showLCo2(convertToCo2, conversion);
        showTrees(convertToTrees, conversion);
        
        //todo: dynamically set these values

        

    }
    public void showLit(TextView text, Conversions conversion){
        double lit = conversion.getFuel();
        text.setText("You have saved " + (Math.floor(lit * 100 +.5)/100) + " litres of fuel");
    }
    public void showLCo2(TextView text, Conversions conversion){
        double co2 = conversion.getCO2();
        text.setText("You have saved " + (int) co2 + " grams of CO2");
    }
    public void showTrees(TextView text, Conversions conversion){
        double treesSaved = conversion.getTreeDays();
        text.setText("You have saved "+ (int) treesSaved + " tree days of CO2");
    }

    public void drawTree(ImageView image) {
        int bronzeT = 100,
                silverT = 300,
                goldT = 500;
        SharedPreferences prefs = getActivity().getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        int steps = prefs.getInt("steps", 0);
        if (steps < bronzeT) {
            image.setImageResource(R.drawable.tree1);
        } else if (steps >= bronzeT && steps < silverT) {
            image.setImageResource(R.drawable.tree2);
        } else if (steps >= silverT && steps < goldT) {
            image.setImageResource(R.drawable.tree3);
        } else if (steps >= goldT) {
            image.setImageResource(R.drawable.tree4);
        }


    }


}