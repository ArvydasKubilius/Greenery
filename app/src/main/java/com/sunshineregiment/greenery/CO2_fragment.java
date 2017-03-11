package com.sunshineregiment.greenery;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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
        showLit(convertToLitres);
        showLCo2(convertToCo2);
        showTrees(convertToTrees);

    }
    public void showLit(TextView text){
        double lit = 20;
        text.setText("You have saved " + lit + " litres of fuel");
    }
    public void showLCo2(TextView text){
        int co2 = 50000;
        text.setText("You have saved " + co2 + " grams of CO2");
    }
    public void showTrees(TextView text){
        double treesSaved = 100;
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