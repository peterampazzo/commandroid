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

import it.unive.dais.legodroid.lib.EV3;
import it.unive.dais.legodroid.lib.comm.BluetoothConnection;
import it.unive.dais.legodroid.lib.plugs.TachoMotor;
import it.unive.dais.legodroid.lib.util.Prelude;

import static it.unive.dais.legodroid.lib.plugs.TachoMotor.Type.LARGE;
import static it.unive.dais.legodroid.lib.plugs.TachoMotor.Type.MEDIUM;

public class Drawing extends AppCompatActivity implements View.OnClickListener{
   protected int[][] A = new int[RIGHE][COLONNE];

    A[2][0]=1;
    A[3][0]=1;
    A[4][0]=1;
    A[5][0]=1;
    A[6][0]=1;
    A[7][0]=1;
    A[1][1]=1;
    A[4][1]=1;
    A[0][2]=1;
    A[4][2]=1;
    A[1][3]=1;
    A[4][3]=1;
    A[2][4]=1;
    A[3][4]=1;
    A[4][4]=1;
    A[5][4]=1;
    A[6][4]=1;
    A[7][4]=1;





    protected int[][] B = new int[RIGHE][COLONNE];

    B[0][0]=1;
    B[1][0]=1;
    B[2][0]=1;
    B[3][0]=1;
    B[4][0]=1;
    B[5][0]=1;
    B[6][0]=1;
    B[7][0]=1;
    B[0][1]=1;
    B[0][2]=1;
    B[0][3]=1;
    B[1][4]=1;
    B[2][4]=1;
    B[3][2]=1;
    B[3][3]=1;
    B[4][2]=1;
    B[4][3]=1;
    B[5][4]=1;
    B[6][4]=1;
    B[7][1]=1;
    B[7][2]=1;
    B[7][3]=1;

    protected int[][] C = new int[RIGHE][COLONNE];

    C[2][0]=1;
    C[3][0]=1;
    C[4][0]=1;
    C[5][0]=1;
    C[1][1]=1;
    C[6][1]=1;
    C[0][2]=1;
    C[7][2]=1;
    C[0][3]=1;
    C[7][3]=1;
    C[0][4]=1;
    C[7][4]=1;

    protected int[][] D = new int[RIGHE][COLONNE];

    D[0][0]=1;
    D[1][0]=1;
    D[2][0]=1;
    D[3][0]=1;
    D[4][0]=1;
    D[5][0]=1;
    D[6][0]=1;
    D[7][0]=1;
    D[0][1]=1;
    D[7][1]=1;
    D[0][2]=1;
    D[7][2]=1;
    D[1][3]=1;
    D[6][3]=1;
    D[2][4]=1;
    D[3][4]=1;
    D[4][4]=1;
    D[5][4]=1;

    protected int[][] E = new int[RIGHE][COLONNE];

    E[0][0]=1;
    E[1][0]=1;
    E[2][0]=1;
    E[3][0]=1;
    E[4][0]=1;
    E[5][0]=1;
    E[6][0]=1;
    E[7][0]=1;
    E[0][1]=1;
    E[3][1]=1;
    E[4][1]=1;
    E[7][1]=1;
    E[0][2]=1;
    E[3][2]=1;
    E[4][2]=1;
    E[7][2]=1;
    E[0][3]=1;
    E[3][3]=1;
    E[4][3]=1;
    E[7][3]=1;
    E[0][4]=1;
    E[7][4]=1;

    protected int[][] F = new int[RIGHE][COLONNE];

    F[0][0]=1;
    F[1][0]=1;
    F[2][0]=1;
    F[3][0]=1;
    F[4][0]=1;
    F[5][0]=1;
    F[6][0]=1;
    F[7][0]=1;
    F[0][1]=1;
    F[1][1]=1;
    F[2][1]=1;
    F[3][1]=1;
    F[4][1]=1;
    F[5][1]=1;
    F[6][1]=1;
    F[7][1]=1;
    F[0][3]=1;
    F[1][3]=1;
    F[3][3]=1;
    F[0][4]=1;
    F[1][4]=1;
    F[3][4]=1;
    F[0][5]=1;
    F[1][5]=1;

    protected int[][] G = new int[RIGHE][COLONNE];

    G[1][0]=1;
    G[2][0]=1;
    G[3][0]=1;
    G[4][0]=1;
    G[5][0]=1;
    G[6][0]=1;
    G[0][1]=1;
    G[7][1]=1;
    G[0][2]=1;
    G[7][2]=1;
    G[0][3]=1;
    G[4][3]=1;
    G[7][3]=1;
    G[0][4]=1;
    G[4][4]=1;
    G[5][4]=1;
    G[6][4]=1;

    protected int[][] H = new int[RIGHE][COLONNE];

    H[0][0]=1;
    H[1][0]=1;
    H[2][0]=1;
    H[3][0]=1;
    H[4][0]=1;
    H[5][0]=1;
    H[6][0]=1;
    H[7][0]=1;
    H[3][1]=1;
    H[4][1]=1;
    H[3][2]=1;
    H[4][2]=1;
    H[3][3]=1;
    H[4][3]=1;
    H[0][4]=1;
    H[1][4]=1;
    H[2][4]=1;
    H[3][4]=1;
    H[4][4]=1;
    H[5][4]=1;
    H[6][4]=1;
    H[7][4]=1;

    protected int[][] I = new int[RIGHE][COLONNE];

    I[0][0]=1;
    I[7][0]=1;
    I[0][1]=1;
    I[7][1]=1;
    I[0][2]=1;
    I[1][2]=1;
    I[2][2]=1;
    I[3][2]=1;
    I[4][2]=1;
    I[5][2]=1;
    I[6][2]=1;
    I[7][2]=1;
    I[0][3]=1;
    I[7][3]=1;
    I[0][4]=1;
    I[7][4]=1;

    protected int[][] J = new int[RIGHE][COLONNE];

    J[0][4]=1;
    J[1][4]=1;
    J[2][4]=1;
    J[3][4]=1;
    J[4][4]=1;
    J[5][4]=1;
    J[6][3]=1;
    J[7][2]=1;
    J[7][1]=1;
    J[6][0]=1;

    protected int[][] K = new int[RIGHE][COLONNE];

    K[0][0]=1;
    K[1][0]=1;
    K[2][0]=1;
    K[3][0]=1;
    K[4][0]=1;
    K[5][0]=1;
    K[6][0]=1;
    K[7][0]=1;
    K[3][1]=1;
    K[4][1]=1;
    K[2][2]=1;
    K[5][2]=1;
    K[1][3]=1;
    K[6][3]=1;
    K[0][4]=1;
    K[7][4]=1;

    protected int[][] L = new int[RIGHE][COLONNE];

    L[0][0]=1;
    L[1][0]=1;
    L[2][0]=1;
    L[3][0]=1;
    L[4][0]=1;
    L[5][0]=1;
    L[6][0]=1;
    L[7][0]=1;
    L[7][1]=1;
    L[7][2]=1;
    L[7][3]=1;
    L[7][4]=1;

    protected int[][] M = new int[RIGHE][COLONNE];

    M[0][0]=1;
    M[1][0]=1;
    M[2][0]=1;
    M[3][0]=1;
    M[4][0]=1;
    M[5][0]=1;
    M[6][0]=1;
    M[7][0]=1;
    M[1][1]=1;
    M[2][2]=1;
    M[1][3]=1;
    M[0][4]=1;
    M[1][4]=1;
    M[2][4]=1;
    M[3][4]=1;
    M[4][4]=1;
    M[5][4]=1;
    M[6][4]=1;
    M[7][4]=1;

    protected int[][] N = new int[RIGHE][COLONNE];

    N[0][0]=1;
    N[1][0]=1;
    N[2][0]=1;
    N[3][0]=1;
    N[4][0]=1;
    N[5][0]=1;
    N[6][0]=1;
    N[7][0]=1;
    N[2][1]=1;
    N[3][2]=1;
    N[4][3]=1;
    N[0][4]=1;
    N[1][4]=1;
    N[2][4]=1;
    N[3][4]=1;
    N[4][4]=1;
    N[5][4]=1;
    N[6][4]=1;
    N[7][4]=1;

    protected int[][] O = new int[RIGHE][COLONNE];

    O[1][0]=1;
    O[2][0]=1;
    O[3][0]=1;
    O[4][0]=1;
    O[5][0]=1;
    O[6][0]=1;
    O[0][1]=1;
    O[7][1]=1;
    O[0][2]=1;
    O[7][2]=1;
    O[0][3]=1;
    O[7][3]=1;
    O[1][4]=1;
    O[2][4]=1;
    O[3][4]=1;
    O[4][4]=1;
    O[5][4]=1;
    O[6][4]=1;

    protected int[][] P = new int[RIGHE][COLONNE];

    P[0][0]=1;
    P[1][0]=1;
    P[2][0]=1;
    P[3][0]=1;
    P[4][0]=1;
    P[5][0]=1;
    P[6][0]=1;
    P[7][0]=1;
    P[0][1]=1;
    P[3][1]=1;
    P[0][2]=1;
    P[3][2]=1;
    P[0][3]=1;
    P[3][3]=1;
    P[1][4]=1;
    P[2][4]=1;

    protected int[][] Q = new int[RIGHE][COLONNE];

    Q[1][0]=1;
    Q[2][0]=1;
    Q[3][0]=1;
    Q[4][0]=1;
    Q[5][0]=1;
    Q[6][0]=1;
    Q[0][1]=1;
    Q[7][1]=1;
    Q[0][2]=1;
    Q[4][2]=1;
    Q[7][2]=1;
    Q[0][3]=1;
    Q[5][3]=1;
    Q[7][3]=1;
    Q[1][4]=1;
    Q[2][4]=1;
    Q[3][4]=1;
    Q[4][4]=1;
    Q[6][4]=1;

    protected int[][] R = new int[RIGHE][COLONNE];

    R[1][0]=1;
    R[2][0]=1;
    R[3][0]=1;
    R[4][0]=1;
    R[5][0]=1;
    R[6][0]=1;
    R[7][0]=1;
    R[0][1]=1;
    R[3][1]=1;
    R[4][1]=1;
    R[0][2]=1;
    R[3][2]=1;
    R[5][2]=1;
    R[0][3]=1;
    R[3][3]=1;
    R[6][3]=1;
    R[1][4]=1;
    R[2][4]=1;
    R[7][4]=1;

    protected int[][] S  = new int[RIGHE][COLONNE];

    S[1][0]=1;
    S[2][0]=1;
    S[7][0]=1;
    S[0][1]=1;
    S[3][1]=1;
    S[4][1]=1;
    S[7][1]=1;
    S[0][2]=1;
    S[3][2]=1;
    S[4][2]=1;
    S[7][2]=1;
    S[0][3]=1;
    S[3][3]=1;
    S[4][3]=1;
    S[7][3]=1;
    S[0][4]=1;
    S[5][4]=1;
    S[6][4]=1;

    protected int[][] T  = new int[RIGHE][COLONNE];

    T[0][0]=1;
    T[0][1]=1;
    T[0][2]=1;
    T[1][2]=1;
    T[2][2]=1;
    T[3][2]=1;
    T[4][2]=1;
    T[5][2]=1;
    T[6][2]=1;
    T[7][2]=1;
    T[0][3]=1;
    T[0][4]=1;

    protected int[][] U  = new int[RIGHE][COLONNE];

    U[0][0]=1;
    U[1][0]=1;
    U[2][0]=1;
    U[3][0]=1;
    U[4][0]=1;
    U[5][0]=1;
    U[6][1]=1;
    U[6][2]=1;
    U[7][2]=1;
    U[6][3]=1;
    U[7][3]=1;
    U[0][4]=1;
    U[1][4]=1;
    U[2][4]=1;
    U[3][4]=1;
    U[4][4]=1;
    U[5][4]=1;
    U[7][1]=1;

    protected int[][] V = new int[RIGHE][COLONNE];

    V[0][0]=1;
    V[1][0]=1;
    V[2][0]=1;
    V[3][0]=1;
    V[4][0]=1;
    V[5][0]=1;
    V[6][1]=1;
    V[7][2]=1;
    V[6][3]=1;
    V[0][4]=1;
    V[1][4]=1;
    V[2][4]=1;
    V[3][4]=1;
    V[4][4]=1;
    V[5][4]=1;

    protected int[][] W = new int[RIGHE][COLONNE];

    W[1][0]=1;
    W[2][0]=1;
    W[3][0]=1;
    W[4][0]=1;
    W[5][0]=1;
    W[6][1]=1;
    W[7][1]=1;
    W[6][2]=1;
    W[7][2]=1;
    W[6][3]=1;
    W[7][3]=1;
    W[0][4]=1;
    W[1][4]=1;
    W[2][4]=1;
    W[3][4]=1;
    W[4][4]=1;
    W[5][4]=1;
    W[0][0]=1;

    protected int[][] X = new int[RIGHE][COLONNE];

    X[0][0]=1;
    X[7][0]=1;
    X[1][1]=1;
    X[2][1]=1;
    X[6][1]=1;
    X[7][1]=1;
    X[2][2]=1;
    X[3][2]=1;
    X[4][2]=1;
    X[5][2]=1;
    X[1][3]=1;
    X[2][3]=1;
    X[5][3]=1;
    X[6][3]=1;
    X[0][4]=1;
    X[7][4]=1;

    protected int[][] Y = new int[RIGHE][COLONNE];

    Y[0][0]=1;
    Y[1][1]=1;
    Y[2][2]=1;
    Y[3][2]=1;
    Y[4][2]=1;
    Y[5][2]=1;
    Y[6][2]=1;
    Y[7][2]=1;
    Y[1][3]=1;
    Y[0][4]=1;

    protected int[][] Z = new int[RIGHE][COLONNE];

    Z[0][0]=1;
    Z[5][0]=1;
    Z[6][0]=1;
    Z[7][0]=1;
    Z[0][1]=1;
    Z[4][1]=1;
    Z[5][1]=1;
    Z[7][1]=1;
    Z[0][2]=1;
    Z[3][2]=1;
    Z[4][2]=1;
    Z[7][2]=1;
    Z[0][3]=1;
    Z[2][3]=1;
    Z[3][3]=1;
    Z[7][3]=1;
    Z[0][4]=1;
    Z[1][4]=1;
    Z[2][4]=1;
    Z[7][4]=1;






































































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
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {
            EV3 ev3 = new EV3(new BluetoothConnection("EV3").connect());
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(v -> Prelude.trap(() -> ev3.run(this::draw)));

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
        try {
            motor.setType(LARGE);
            motor1.setType(MEDIUM);
            motor2.setType(LARGE);


        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i =RIGHE-1; i >=0; i--){
            for(int y = 0; y < COLONNE; y++){
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
            } catch (IOException e) {
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

