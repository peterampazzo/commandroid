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

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import it.unive.dais.legodroid.lib.EV3;
import it.unive.dais.legodroid.lib.plugs.TachoMotor;
import it.unive.dais.legodroid.lib.plugs.TouchSensor;

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
    private static int RIGHE = 8;
    private static int COLONNE = 8;
    void init() {

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
        Button disegno_libero = findViewById(R.id.disegnoLibero);
        Button disegno_lettere = findViewById(R.id.disegnoLettere);
        Button info = findViewById(R.id.info);
        disegno_libero.setOnClickListener(v -> { this.startActivity(new Intent(this, Drawing.class));});
        disegno_lettere.setOnClickListener(v -> { this.startActivity(new Intent(this, Letter.class));});
        info.setOnClickListener(v -> { this.startActivity(new Intent(this, Info.class));});


    }

    private void cycle(EV3.Api api) {
        TouchSensor random = api.getTouchSensor(EV3.InputPort._2);
        while (!api.ev3.isCancelled()) {

            try {
                touched1 = random.getPressed();
                if (touched1.get()) {
                    motor = api.getTachoMotor(EV3.OutputPort.B);
                    motor1 = api.getTachoMotor(EV3.OutputPort.A);
                    motor2 = api.getTachoMotor(EV3.OutputPort.C);
                    TouchSensor reset = api.getTouchSensor(EV3.InputPort._1);
                    int i, y;
                    try {
                        motor.setType(LARGE);
                        motor1.setType(MEDIUM);
                        motor2.setType(LARGE);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (count == 0)
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
                                    motor.setStepPower(80, 0, 360, 0, true);
                                    motor.waitCompletion();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            try {
                                motor1.setStepPower(-70, 0, 30, 0, true);
                                motor1.waitCompletion();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        try {
                            motor1.setStepPower(70, 0, 240, 0, true);
                            motor1.waitCompletion();
                            motor2.setStepPower(70, 0, 15, 0, true);
                            motor2.waitCompletion();
                            Future<Boolean> touched = reset.getPressed();
                            if (touched.get()) {
                                i = -2;              //reset
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
                        motor2.setStepPower(20, 0, 1000, 0, true);
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
