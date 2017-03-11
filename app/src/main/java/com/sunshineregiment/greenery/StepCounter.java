package com.sunshineregiment.greenery;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class StepCounter extends AppCompatActivity implements SensorEventListener {

        private ViewPager mViewPager;

        private TextView textView;

        private SensorManager mSensorManager;

        private Sensor mStepCounterSensor;

        private Sensor mStepDetectorSensor;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textView = (TextView) findViewById(R.id.stepNo);

            mSensorManager = (SensorManager)
                    getSystemService(Context.SENSOR_SERVICE);
            mStepCounterSensor = mSensorManager
                    .getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            mStepDetectorSensor = mSensorManager
                    .getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
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
                            }
                        }
                    });
                } else {
                    textView = (TextView) findViewById(R.id.stepNo);
                }
            } catch (Exception e){
                //Do nothing
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        protected void onResume() {

            super.onResume();

            mSensorManager.registerListener(this, mStepCounterSensor, SensorManager.SENSOR_DELAY_FASTEST);
            mSensorManager.registerListener(this, mStepDetectorSensor,SensorManager.SENSOR_DELAY_FASTEST);

        }

        protected void onStop() {
            super.onStop();
            mSensorManager.unregisterListener(this, mStepCounterSensor);
            mSensorManager.unregisterListener(this, mStepDetectorSensor);
        }
}

//My fragment_main.xml

//<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        xmlns:tools="http://schemas.android.com/tools"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:orientation="vertical"
//        android:paddingBottom="@dimen/activity_vertical_margin"
//        android:paddingLeft="@dimen/activity_horizontal_margin"
//        android:paddingRight="@dimen/activity_horizontal_margin"
//        android:paddingTop="@dimen/activity_vertical_margin"
//        tools:context="com.sunshineregiment.greenery.MainActivity$PlaceholderFragment">
//
//<TextView
//        android:id="@+id/section_label"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content" />
//
//<TextView
//        android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:textAlignment="center"
//                android:text="Step count:"
//                android:textSize="20sp" />
//
//<TextView
//        android:id="@+id/stepNo"
//                android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:textAlignment="center"
//                android:text="0"
//                android:textSize="20sp" />
//
//
//</LinearLayout>
