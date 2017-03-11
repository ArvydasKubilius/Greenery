package com.sunshineregiment.greenery.CalculateStep;

import com.sunshineregiment.greenery.BiometricProfile;

/**
 * Created by Zikoz on 11/03/2017.
 */

public class CalculateStep {
    public CalculateStep() {

    }
    /**
     * To calculate how many steps a person takes per km
     * according to their height and gender.
     *
     * Based on the stride length(length of each step).
     * Formula: Women .413 * height / Men .415 * height
     *
     * @param profile
     * @return number of steps per km
     */
    public static double step (BiometricProfile profile){
        double step;
        double stride_length;
        double height = profile.getHeight();//convert from metres to centimetres
        boolean gender = profile.getGender();

        if (gender) {
            stride_length = 0.413 * height;
            //convert to km
            stride_length /= 1000;
            //System.out.println("stride_length: " + stride_length);
        } else {
            stride_length = 0.415 * height;
            //convert to km
            stride_length /= 1000;
            //System.out.println("stride_length: " + stride_length);
        }
        step = 1/stride_length;

        return step;
    }
}