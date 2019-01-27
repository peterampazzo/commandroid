package it.unive.dais.commandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import it.unive.dais.legodroid.lib.EV3;
import it.unive.dais.legodroid.lib.comm.BluetoothConnection;
import it.unive.dais.legodroid.lib.plugs.TachoMotor;
import it.unive.dais.legodroid.lib.plugs.TouchSensor;
import it.unive.dais.legodroid.lib.util.Prelude;

import static it.unive.dais.legodroid.lib.plugs.TachoMotor.Type.LARGE;
import static it.unive.dais.legodroid.lib.plugs.TachoMotor.Type.MEDIUM;

public class Drawing extends AppCompatActivity implements View.OnClickListener{

    private static int RIGHE = 8;
    private static int COLONNE = 8;
    private CheckBox[][] buttons = new CheckBox[RIGHE][COLONNE];
    protected int[][] draw = new int[RIGHE][COLONNE];
    TachoMotor motor;
    TachoMotor motor1;
    TachoMotor motor2;

    // controlla se matrice e' nulla
    protected boolean buttonsNull(){
        for(int i = 0; i < RIGHE; i++){
            for(int y = 0; y < COLONNE; y++){
                if (draw[i][y] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {
            EV3 ev3 = new EV3(new BluetoothConnection("EV3").connect());
            FloatingActionButton fab =  findViewById(R.id.fab);
            fab.setOnClickListener(v -> Prelude.trap(() -> ev3.run(Drawing.this::draw)));

            // Commandroid: genera due matrice, azzera quella "draw" e inizializza "buttons"
            for(int i = 0; i < RIGHE; i++){
                    for(int y = 0; y < COLONNE; y++){
                        String buttonID = "b" + i + y;
                        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                        buttons[i][y] =  findViewById(resID);
                        buttons[i][y].setOnClickListener(this);
                        draw[i][y] = 0;
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private void draw(EV3.Api api){
        motor = api.getTachoMotor(EV3.OutputPort.B);
        motor1 = api.getTachoMotor(EV3.OutputPort.A);
        motor2 = api.getTachoMotor(EV3.OutputPort.C);
        TouchSensor reset = api.getTouchSensor(EV3.InputPort._1);
        int i,y;
        try {
            motor.setType(LARGE);
            motor1.setType(MEDIUM);
            motor2.setType(LARGE);


        } catch (IOException e) {
            e.printStackTrace();
        }
        for(i =RIGHE-1; i >=0; i--){
            for(y = 0; y < COLONNE; y++){
                if(draw[i][y]==1){
                    try {
                        motor.setStepPower(80,0,360,0,true);
                        motor.waitCompletion();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    motor1.setStepPower(-70,0,30,0,true);
                    motor1.waitCompletion();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            try {
                motor1.setStepPower(70,0,240,0,true);
                motor1.waitCompletion();
                motor2.setStepPower(70,0,15,0,true);
                motor2.waitCompletion();
                Future<Boolean> touched = reset.getPressed();
                if(touched.get()){
                    i=-2;              //reset
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        try {
            motor2.setStepPower(20,0,1000,0,true);
            motor2.waitCompletion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ButtonsOnClick(Button button, int x, int y){
        if(draw[x][y] == 0){
            draw[x][y] = 1;
        }
        else{
            draw[x][y] = 0;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //riga 0
            case R.id.b00:
                ButtonsOnClick(buttons[0][0], 0, 0);
                break;
            case R.id.b01:
                ButtonsOnClick(buttons[0][1], 0, 1);
                break;
            case R.id.b02:
                ButtonsOnClick(buttons[0][2], 0, 2);
                break;
            case R.id.b03:
                ButtonsOnClick(buttons[0][3], 0, 3);
                break;
            case R.id.b04:
                ButtonsOnClick(buttons[0][4], 0, 4);
                break;
            case R.id.b05:
                ButtonsOnClick(buttons[0][5], 0, 5);
                break;
            case R.id.b06:
                ButtonsOnClick(buttons[0][6], 0, 6);
                break;
            case R.id.b07:
                ButtonsOnClick(buttons[0][7], 0, 7);
                break;

            //riga 1
            case R.id.b10:
                ButtonsOnClick(buttons[1][0], 1, 0);
                break;
            case R.id.b11:
                ButtonsOnClick(buttons[1][1], 1, 1);
                break;
            case R.id.b12:
                ButtonsOnClick(buttons[1][2], 1, 2);
                break;
            case R.id.b13:
                ButtonsOnClick(buttons[1][3], 1, 3);
                break;
            case R.id.b14:
                ButtonsOnClick(buttons[1][4], 1, 4);
                break;
            case R.id.b15:
                ButtonsOnClick(buttons[1][5], 1, 5);
                break;
            case R.id.b16:
                ButtonsOnClick(buttons[1][6], 1, 6);
                break;
            case R.id.b17:
                ButtonsOnClick(buttons[1][7], 1, 7);
                break;


            //riga 2
            case R.id.b20:
                ButtonsOnClick(buttons[2][0], 2, 0);
                break;
            case R.id.b21:
                ButtonsOnClick(buttons[2][1], 2, 1);
                break;
            case R.id.b22:
                ButtonsOnClick(buttons[2][2], 2, 2);
                break;
            case R.id.b23:
                ButtonsOnClick(buttons[2][3], 2, 3);
                break;
            case R.id.b24:
                ButtonsOnClick(buttons[2][4], 2, 4);
                break;
            case R.id.b25:
                ButtonsOnClick(buttons[2][5], 2, 5);
                break;
            case R.id.b26:
                ButtonsOnClick(buttons[2][6], 2, 6);
                break;
            case R.id.b27:
                ButtonsOnClick(buttons[2][7], 2, 7);
                break;
            //riga 3
            case R.id.b30:
                ButtonsOnClick(buttons[3][0], 3, 0);
                break;
            case R.id.b31:
                ButtonsOnClick(buttons[3][1], 3, 1);
                break;
            case R.id.b32:
                ButtonsOnClick(buttons[3][2], 3, 2);
                break;
            case R.id.b33:
                ButtonsOnClick(buttons[3][3], 3, 3);
                break;
            case R.id.b34:
                ButtonsOnClick(buttons[3][4], 3, 4);
                break;
            case R.id.b35:
                ButtonsOnClick(buttons[3][5], 3, 5);
                break;
            case R.id.b36:
                ButtonsOnClick(buttons[3][6], 3, 6);
                break;
            case R.id.b37:
                ButtonsOnClick(buttons[3][7], 3, 7);
                break;
            //riga 4
            case R.id.b40:
                ButtonsOnClick(buttons[4][0], 4, 0);
                break;
            case R.id.b41:
                ButtonsOnClick(buttons[4][1], 4, 1);
                break;
            case R.id.b42:
                ButtonsOnClick(buttons[4][2], 4, 2);
                break;
            case R.id.b43:
                ButtonsOnClick(buttons[4][3], 4, 3);
                break;
            case R.id.b44:
                ButtonsOnClick(buttons[4][4], 4, 4);
                break;
            case R.id.b45:
                ButtonsOnClick(buttons[4][5], 4, 5);
                break;
            case R.id.b46:
                ButtonsOnClick(buttons[4][6], 4, 6);
                break;
            case R.id.b47:
                ButtonsOnClick(buttons[4][7], 4, 7);
                break;
            //riga 5
            case R.id.b50:
                ButtonsOnClick(buttons[5][0], 5, 0);
                break;
            case R.id.b51:
                ButtonsOnClick(buttons[5][1], 5, 1);
                break;
            case R.id.b52:
                ButtonsOnClick(buttons[5][2], 5, 2);
                break;
            case R.id.b53:
                ButtonsOnClick(buttons[5][3], 5, 3);
                break;
            case R.id.b54:
                ButtonsOnClick(buttons[5][4], 5, 4);
                break;
            case R.id.b55:
                ButtonsOnClick(buttons[5][5], 5, 5);
                break;
            case R.id.b56:
                ButtonsOnClick(buttons[5][6], 5, 6);
                break;
            case R.id.b57:
                ButtonsOnClick(buttons[5][7], 5, 7);
                break;
            //riga 6
            case R.id.b60:
                ButtonsOnClick(buttons[6][0], 6, 0);
                break;
            case R.id.b61:
                ButtonsOnClick(buttons[6][1], 6, 1);
                break;
            case R.id.b62:
                ButtonsOnClick(buttons[6][2], 6, 2);
                break;
            case R.id.b63:
                ButtonsOnClick(buttons[6][3], 6, 3);
                break;
            case R.id.b64:
                ButtonsOnClick(buttons[6][4], 6, 4);
                break;
                case R.id.b65:
                ButtonsOnClick(buttons[6][5], 6, 5);
                break;
            case R.id.b66:
                ButtonsOnClick(buttons[6][6], 6, 6);
                break;
            case R.id.b67:
                ButtonsOnClick(buttons[6][7], 6, 7);
                break;
            //riga 7
            case R.id.b70:
                ButtonsOnClick(buttons[7][0], 7, 0);
                break;
                case R.id.b71:
                ButtonsOnClick(buttons[7][1], 7, 1);
                    break;

            case R.id.b72:
                ButtonsOnClick(buttons[7][2], 7, 2);
                break;

            case R.id.b73:
                ButtonsOnClick(buttons[7][3], 7, 3);
                break;

            case R.id.b74:
                ButtonsOnClick(buttons[7][4], 7, 4);
                break;

            case R.id.b75:
                ButtonsOnClick(buttons[7][5], 7,5 );
                break;

            case R.id.b76:
                ButtonsOnClick(buttons[7][6], 7, 6);
                break;
            case R.id.b77:
                ButtonsOnClick(buttons[7][7], 7, 7);
                break;

            default:
                break;
        }
    }
}

