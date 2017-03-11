package com.sunshineregiment.greenery;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.support.v7.widget.AppCompatDrawableManager.get;

/**
 * Created by Zikoz on 10/03/2017.
 */

public class Step_counter_fragment extends Fragment implements SensorEventListener {


    private TextView textView;

    private SensorManager mSensorManager;

    private Sensor mStepCounterSensor;

    private Sensor mStepDetectorSensor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //debugging
//        if (getActivity() == null){
//            Log.d("stepcounterfragment", "onCreateView: NULL ACT ");
//        } else {
//            Log.d("stepcounterfragment", "onCreateView: NOT NULL ACT ");
//        }

        textView = (TextView) getActivity().findViewById(R.id.steps_textView);

        mSensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mStepDetectorSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);


        return inflater.inflate(R.layout.fragment_step_counter, container, false);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        final Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];
        }
        final int value2 = value;
        try {
            if (textView != null) {
                textView.getHandler().post(new Runnable() {

                    @Override
                    public void run() {
                        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER || sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
                            textView.setText("" + value2);
                            SharedPreferences prefs = getContext().getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putInt("steps", value2);
                            editor.commit();
                        }
                    }
                });
            } else {
                textView = (TextView) getActivity().findViewById(R.id.steps_textView);
            }
        } catch (Exception e) {
            //Do nothing
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onResume() {

        super.onResume();

        mSensorManager.registerListener(this, mStepCounterSensor, SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mStepDetectorSensor, SensorManager.SENSOR_DELAY_FASTEST);

    }

    public void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this, mStepDetectorSensor);
    }

}