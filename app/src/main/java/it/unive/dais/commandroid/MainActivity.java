package it.unive.dais.commandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import it.unive.dais.legodroid.lib.EV3;
import it.unive.dais.legodroid.lib.plugs.TachoMotor;
//import it.unive.dais.legodroid.lib.comm.BluetoothConnection;
//import it.unive.dais.legodroid.lib.plugs.GyroSensor;
//import it.unive.dais.legodroid.lib.plugs.LightSensor;
//import it.unive.dais.legodroid.lib.plugs.Plug;
//import it.unive.dais.legodroid.lib.plugs.TachoMotor;
//import it.unive.dais.legodroid.lib.plugs.TouchSensor;
//import it.unive.dais.legodroid.lib.plugs.UltrasonicSensor;
//import it.unive.dais.legodroid.lib.util.Consumer;
//import it.unive.dais.legodroid.lib.util.Prelude;
//import it.unive.dais.legodroid.lib.util.ThrowingConsumer;

public class MainActivity extends AppCompatActivity {

    EV3 ev3 = new EV3(new BluetoothConnection("EV3").connect());

    public MainActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
