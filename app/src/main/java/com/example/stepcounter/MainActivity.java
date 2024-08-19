package com.example.stepcounter;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private boolean isSensorRegistered = false;
    private int stepCount = 0;
    private TextView stepCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepCountTextView = findViewById(R.id.stepCountTextView);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

        Button simulateButton = findViewById(R.id.simulateButton);
        simulateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simulateSteps(10); // Change the number of steps as needed
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometer != null && !isSensorRegistered) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            isSensorRegistered = true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isSensorRegistered) {
            sensorManager.unregisterListener(this);
            isSensorRegistered = false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            float acceleration = (float) Math.sqrt(x * x + y * y + z * z);

            if (acceleration > 10) { // You can adjust this threshold based on your testing
                stepCount++;
                updateStepCount();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Does nothing for now
    }

    private void updateStepCount() {
        runOnUiThread(() -> stepCountTextView.setText("Step Count: " + stepCount));
    }

    private void simulateSteps(int numSteps) {
        for (int i = 0; i < numSteps; i++) {
            simulateStep();
        }
    }

    private void simulateStep() {
        // Simulate a step by providing fake acceleration values
        float[] values = new float[3];
        values[0] = (float) Math.random() * 2; // Random X-axis acceleration
        values[1] = (float) Math.random() * 2; // Random Y-axis acceleration
        values[2] = (float) Math.random() * 2; // Random Z-axis acceleration
        //does not actually work its just a button
        //i wanted to use this if i could not make the app work on my phone
        //so left this ideea
        // Simulate a step by calling onSensorChanged directly with fake acceleration values
        onSensorChanged(accelerometer, values);
    }

    private void onSensorChanged(Sensor accelerometer, float[] values) {
    }
}

