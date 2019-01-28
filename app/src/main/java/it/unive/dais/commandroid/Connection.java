package it.unive.dais.commandroid;

import android.app.Application;
import android.content.res.Configuration;

import java.io.IOException;

import it.unive.dais.legodroid.lib.EV3;
import it.unive.dais.legodroid.lib.comm.BluetoothConnection;

public class Connection extends Application {


    private  EV3 ev3;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            ev3 = new EV3(new BluetoothConnection("EV3").connect());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public EV3 getEv3(){
        return ev3;
    }
}
