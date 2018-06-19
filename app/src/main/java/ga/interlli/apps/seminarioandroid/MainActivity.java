package ga.interlli.apps.seminarioandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Telas
    final int TELA_ACELEROMETRO = 1;
    final int TELA_GIROSCOPIO = 2;

    Button btnAcelerometro, btnGiroscopio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();
        btnClick();

    }

    private void binding() {
        btnAcelerometro = (Button) findViewById(R.id.btnAcelerometro);
        btnGiroscopio = (Button) findViewById(R.id.btnGiroscopio);
    }

    private void btnClick() {

        btnAcelerometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SensorAcelerometro.class);
                startActivityForResult(it, TELA_ACELEROMETRO);
            }
        });

        btnGiroscopio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SensorGiroscopio.class);
                startActivityForResult(it, TELA_GIROSCOPIO);
            }
        });
    }
}
