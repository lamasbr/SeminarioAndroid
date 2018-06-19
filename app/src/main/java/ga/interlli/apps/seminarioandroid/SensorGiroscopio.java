package ga.interlli.apps.seminarioandroid;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.content.Context;
import android.widget.TextView;

public class SensorGiroscopio extends Activity implements SensorEventListener {

    TextView tv_gyro_X, tv_gyro_Y, tv_gyro_Z;
    private SensorManager sensorManager;
    private Sensor gyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_giroscopio);
        binding();

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, gyro, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this, gyro);
    }

    @Override
    protected void onStop(){
        super.onStop();
        sensorManager.unregisterListener(this, gyro);
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1)
    {
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        //if sensor is unreliable, return void
        //if (event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE)
        //{
        //    return;
        //}

        //else it will output the Roll, Pitch and Yawn values
        tv_gyro_X.setText("Eixo X: "+ Float.toString(event.values[0]));
        tv_gyro_Y.setText("Eixo Y: "+ Float.toString(event.values[1]));
        tv_gyro_Z.setText("Eixo Z: "+ Float.toString(event.values[2]));
    }

    private void binding() {
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        tv_gyro_X = (TextView) findViewById(R.id.tv_gyro_X);
        tv_gyro_Y = (TextView) findViewById(R.id.tv_gyro_Y);
        tv_gyro_Z = (TextView) findViewById(R.id.tv_gyro_Z);
    }
}
