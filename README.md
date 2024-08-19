# StepCounter


The Step Counter App is an Android application designed to track the number of steps you take using your smartphone's built-in accelerometer. The app features a minimalistic user interface with a display that shows the current step count in real time.
This project was made using Android Studio.

Key Features:
Real-time Step Counting: The app listens to the device's accelerometer sensor to detect your movements and counts steps based on the acceleration data.
Step Simulation: For testing purposes, the app includes a "Simulate Steps" button that artificially increases the step count. This feature can simulate a set number of steps to see how the app responds without physically moving.

How It Works:
Sensor Registration: When the app is opened or resumed, it registers the accelerometer sensor to start tracking movements.
Movement Detection: The app continuously monitors the accelerometer data. When a significant movement is detected (based on a threshold value for acceleration), it increments the step count.
Step Display: The current step count is displayed in a TextView on the app's main screen.
Pausing Tracking: When the app is paused, the accelerometer sensor is unregistered to save battery and resources.
![image](https://github.com/user-attachments/assets/982305b3-93ba-4456-9446-3b3a7b83cc5f)

Additional Notes:
The app's current implementation of step detection is basic and may require calibration (adjusting the acceleration threshold) for accuracy.
The step simulation feature is primarily for testing and does not replicate the full functionality of physical movement.
The app works in real time on the phone but in simulation it does not work anymore.

![image](https://github.com/user-attachments/assets/ba0422ed-4385-4169-bfa1-c370537d2f7c)
