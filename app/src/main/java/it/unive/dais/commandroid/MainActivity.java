package it.unive.dais.commandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import it.unive.dais.legodroid.lib.EV3;

public class MainActivity extends AppCompatActivity {

    EV3 ev3 = new EV3(new BluetoothConnection("EV3").connect());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
