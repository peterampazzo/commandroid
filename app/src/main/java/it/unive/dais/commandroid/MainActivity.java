package it.unive.dais.commandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import it.unive.dais.legodroid.lib.EV3;
import it.unive.dais.legodroid.lib.plugs.TachoMotor;
import it.unive.dais.legodroid.lib.plugs.TouchSensor;
import it.unive.dais.legodroid.lib.util.Prelude;

import static it.unive.dais.legodroid.lib.plugs.TachoMotor.Type.LARGE;
import static it.unive.dais.legodroid.lib.plugs.TachoMotor.Type.MEDIUM;

public class MainActivity extends AppCompatActivity {

    TachoMotor motor;
    TachoMotor motor1;
    TachoMotor motor2;
    Future<Boolean> touched1;
    protected int[][] draw ;
    protected int[][] W = new int[RIGHE][COLONNE];
    protected int[][] quadrato = new int[RIGHE][COLONNE];
    protected int[][] cerchio = new int[RIGHE][COLONNE];
    protected int[][] x = new int[RIGHE][COLONNE];
    protected int[][] infinito = new int[RIGHE][COLONNE];
    int count=0;
    int toggle;
    Connection c;
    Switch random;

    private static int RIGHE = 8;
    private static int COLONNE = 8;

    void init() {            //funzione che mi inizializza le matrici per la dimostrazione iniziale

        quadrato[0][0] = 1;
        quadrato[1][0] = 1;
        quadrato[2][0] = 1;
        quadrato[3][0] = 1;
        quadrato[4][0] = 1;
        quadrato[5][0] = 1;
        quadrato[6][0] = 1;
        quadrato[7][0] = 1;
        quadrato[0][1] = 1;
        quadrato[7][1] = 1;
        quadrato[0][2] = 1;
        quadrato[7][2] = 1;
        quadrato[0][3] = 1;
        quadrato[7][3] = 1;
        quadrato[0][4] = 1;
        quadrato[7][4] = 1;
        quadrato[0][5] = 1;
        quadrato[7][5] = 1;
        quadrato[0][6] = 1;
        quadrato[7][6] = 1;
        quadrato[0][7] = 1;
        quadrato[1][7] = 1;
        quadrato[2][7] = 1;
        quadrato[3][7] = 1;
        quadrato[4][7] = 1;
        quadrato[5][7] = 1;
        quadrato[6][7] = 1;
        quadrato[7][7] = 1;

        cerchio[3][0] = 1;
        cerchio[4][0] = 1;
        cerchio[2][1] = 1;
        cerchio[5][1] = 1;
        cerchio[1][2] = 1;
        cerchio[6][2] = 1;
        cerchio[0][3] = 1;
        cerchio[7][3] = 1;
        cerchio[0][4] = 1;
        cerchio[7][4] = 1;
        cerchio[1][5] = 1;
        cerchio[6][5] = 1;
        cerchio[2][6] = 1;
        cerchio[5][6] = 1;
        cerchio[3][7] = 1;
        cerchio[4][7] = 1;

        x[0][0] = 1;
        x[7][0] = 1;
        x[1][1] = 1;
        x[6][1] = 1;
        x[2][2] = 1;
        x[5][2] = 1;
        x[3][3] = 1;
        x[4][3] = 1;
        x[3][4] = 1;
        x[4][4] = 1;
        x[2][5] = 1;
        x[5][5] = 1;
        x[1][6] = 1;
        x[6][6] = 1;
        x[0][7] = 1;
        x[7][7] = 1;

        infinito[1][0] = 1;
        infinito[2][0] = 1;
        infinito[3][0] = 1;
        infinito[4][0] = 1;
        infinito[5][0] = 1;
        infinito[6][0] = 1;
        infinito[1][1] = 1;
        infinito[6][1] = 1;
        infinito[2][2] = 1;
        infinito[5][2] = 1;
        infinito[3][3] = 1;
        infinito[4][3] = 1;
        infinito[3][4] = 1;
        infinito[4][4] = 1;
        infinito[2][5] = 1;
        infinito[5][5] = 1;
        infinito[1][6] = 1;
        infinito[6][6] = 1;
        infinito[1][7] = 1;
        infinito[2][7] = 1;
        infinito[3][7] = 1;
        infinito[4][7] = 1;
        infinito[5][7] = 1;
        infinito[6][7] = 1;
        infinito[0][0] = 1;
        infinito[7][0] = 1;
        infinito[0][7] = 1;
        infinito[7][7] = 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button disegno_libero = findViewById(R.id.disegnoLibero);      //prendo i bottoni dal layout
        Button disegno_lettere = findViewById(R.id.disegnoLettere);
        random = findViewById(R.id.random);

        init();   //inizializzo le matrici

        disegno_libero.setOnClickListener(v -> { this.startActivity(new Intent(this, Drawing.class));});        //setto i listener dei due bottoni che mi porteranno alle altre activities
        disegno_lettere.setOnClickListener(v -> { this.startActivity(new Intent(this, Letter.class));});

        c = (Connection) getApplication();  //prendo  l'istanza di Connection
        toggle=c.getToogle();
        random.setOnClickListener(v->{if(toggle==0){ c.setToogle(); toggle=1;}}); //setto il listener del switch in modo tale da attivare le altre modalità dell'app
        EV3 ev3 = c.getEv3();       //prendo l'istanza di ev3 dalla Connection

        if(toggle==1){
            random.setChecked(true);
        }
        Prelude.trap(() -> ev3.run(MainActivity.this::cycle));  //faccio partire la funzione cycle sull'ev3


    }

    private void cycle(EV3.Api api) {                                //funzione che a rotazione mi stampa un quadrato,cerchio,x e il simbolo dell'infinito
        TouchSensor button = api.getTouchSensor(EV3.InputPort._2);
        while (toggle==0) {
            try {
                touched1 = button.getPressed();
                if (touched1.get()) {                                 //controllo se il pulsante è stato premuto, se è stato premuto inizia a disegnare
                    motor = api.getTachoMotor(EV3.OutputPort.B);
                    motor1 = api.getTachoMotor(EV3.OutputPort.A);
                    motor2 = api.getTachoMotor(EV3.OutputPort.C);
                    TouchSensor reset = api.getTouchSensor(EV3.InputPort._1);        //assegno il bottone di reset
                    int i, y;
                    try {
                        motor.setType(LARGE);
                        motor1.setType(MEDIUM);
                        motor2.setType(LARGE);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (count == 0)                              //setto cosa disegnare
                        draw = quadrato;
                    if (count == 1)
                        draw = cerchio;
                    if (count == 2)
                        draw = x;
                    if (count == 3)
                        draw = infinito;


                    for (i = RIGHE - 1; i >= 0; i--) {
                        for (y = 0; y < COLONNE; y++) {
                            if (draw[i][y] == 1) {
                                try {
                                    motor.setStepPower(120, 0, 360, 0, true);   //muove il motore
                                    motor.waitCompletion();                                                     //aspetta il completamento dell'azione da parte del motore
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            try {
                                motor1.setStepPower(-120, 0, 30, 0, true);
                                motor1.waitCompletion();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        try {
                            motor1.setStepPower(120, 0, 240, 0, true);    //porto indietro il braccio della stampante dopo ogni riga disegnata
                            motor1.waitCompletion();
                            motor2.setStepPower(120, 0, 15, 0, true);
                            motor2.waitCompletion();
                            Future<Boolean> touched = reset.getPressed();                               //inizializzo il bottone di reset dell'ev3
                            if (touched.get()) {
                                i = -2;              //reset
                                toggle=1;
                                c.setToogle();
                                finish();
                                startActivity(new Intent(this, MainActivity.class));     //ricarico l'activity

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }

                    }
                    count = (count + 1) % 4;
                    try {
                        motor2.setStepPower(50, 0, 1000, 0, true);   //getto fuori il foglio alla fine della stampa
                        motor2.waitCompletion();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


        }
    }
}
