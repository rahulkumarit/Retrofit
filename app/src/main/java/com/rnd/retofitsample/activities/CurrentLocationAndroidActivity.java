package com.rnd.retofitsample.activities;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.rnd.retofitsample.R;

import static com.rnd.retofitsample.R.id.textView;


/**
 * Created by Devrepublic-14 on 7/24/2017.
 */

public class CurrentLocationAndroidActivity extends BaseActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView txtView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_current_location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        txtView = (TextView) findViewById(R.id.txtView);
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        txtView.setText("x: " + values[0] + "\nY: " + values[1] + "\nZ: " + values[2]);
        Log.e("Sensors (X,Y,Z):", "" + values[0] + "," + values[1] + "," + values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
