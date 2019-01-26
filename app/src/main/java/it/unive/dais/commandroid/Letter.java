package it.unive.dais.commandroid;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import it.unive.dais.legodroid.lib.EV3;
import it.unive.dais.legodroid.lib.comm.BluetoothConnection;
import it.unive.dais.legodroid.lib.plugs.TachoMotor;
import it.unive.dais.legodroid.lib.util.Prelude;

import static it.unive.dais.legodroid.lib.plugs.TachoMotor.Type.LARGE;
import static it.unive.dais.legodroid.lib.plugs.TachoMotor.Type.MEDIUM;

public class Letter extends AppCompatActivity {

    protected int[][] A = new int[RIGHE][COLONNE];
    protected int[][] B = new int[RIGHE][COLONNE];
    protected int[][] C = new int[RIGHE][COLONNE];
    protected int[][] D = new int[RIGHE][COLONNE];
    protected int[][] E = new int[RIGHE][COLONNE];
    protected int[][] F = new int[RIGHE][COLONNE];
    protected int[][] G = new int[RIGHE][COLONNE];
    protected int[][] H = new int[RIGHE][COLONNE];
    protected int[][] I = new int[RIGHE][COLONNE];
    protected int[][] J = new int[RIGHE][COLONNE];
    protected int[][] K = new int[RIGHE][COLONNE];
    protected int[][] L = new int[RIGHE][COLONNE];
    protected int[][] M = new int[RIGHE][COLONNE];
    protected int[][] N = new int[RIGHE][COLONNE];
    protected int[][] O = new int[RIGHE][COLONNE];
    protected int[][] P = new int[RIGHE][COLONNE];
    protected int[][] Q = new int[RIGHE][COLONNE];
    protected int[][] r = new int[RIGHE][COLONNE];
    protected int[][] S = new int[RIGHE][COLONNE];
    protected int[][] T = new int[RIGHE][COLONNE];
    protected int[][] U = new int[RIGHE][COLONNE];
    protected int[][] V = new int[RIGHE][COLONNE];
    protected int[][] W = new int[RIGHE][COLONNE];
    protected int[][] X = new int[RIGHE][COLONNE];
    protected int[][] Y = new int[RIGHE][COLONNE];
    protected int[][] Z = new int[RIGHE][COLONNE];

    protected int[][] draw;

    private  String x;
    private int length;
    private char[] y;



    protected int[][][] array;




    void setLetter() {

        A[4][0] = 1;
        A[5][0] = 1;
        A[6][0] = 1;
        A[7][0] = 1;
        A[1][1] = 1;
        A[4][1] = 1;
        A[0][2] = 1;
        A[4][2] = 1;
        A[1][3] = 1;
        A[4][3] = 1;
        A[2][4] = 1;
        A[3][4] = 1;
        A[4][4] = 1;
        A[5][4] = 1;
        A[6][4] = 1;
        A[7][4] = 1;

        B[0][0] = 1;
        B[1][0] = 1;
        B[2][0] = 1;
        B[3][0] = 1;
        B[4][0] = 1;
        B[5][0] = 1;
        B[6][0] = 1;
        B[7][0] = 1;
        B[0][1] = 1;
        B[0][2] = 1;
        B[0][3] = 1;
        B[1][4] = 1;
        B[2][4] = 1;
        B[3][2] = 1;
        B[3][3] = 1;
        B[4][2] = 1;
        B[4][3] = 1;
        B[5][4] = 1;
        B[6][4] = 1;
        B[7][1] = 1;
        B[7][2] = 1;
        B[7][3] = 1;

        C[2][0] = 1;
        C[3][0] = 1;
        C[4][0] = 1;
        C[5][0] = 1;
        C[1][1] = 1;
        C[6][1] = 1;
        C[0][2] = 1;
        C[7][2] = 1;
        C[0][3] = 1;
        C[7][3] = 1;
        C[0][4] = 1;
        C[7][4] = 1;

        D[0][0] = 1;
        D[1][0] = 1;
        D[2][0] = 1;
        D[3][0] = 1;
        D[4][0] = 1;
        D[5][0] = 1;
        D[6][0] = 1;
        D[7][0] = 1;
        D[0][1] = 1;
        D[7][1] = 1;
        D[0][2] = 1;
        D[7][2] = 1;
        D[1][3] = 1;
        D[6][3] = 1;
        D[2][4] = 1;
        D[3][4] = 1;
        D[4][4] = 1;
        D[5][4] = 1;

        E[0][0] = 1;
        E[1][0] = 1;
        E[2][0] = 1;
        E[3][0] = 1;
        E[4][0] = 1;
        E[5][0] = 1;
        E[6][0] = 1;
        E[7][0] = 1;
        E[0][1] = 1;
        E[3][1] = 1;
        E[4][1] = 1;
        E[7][1] = 1;
        E[0][2] = 1;
        E[3][2] = 1;
        E[4][2] = 1;
        E[7][2] = 1;
        E[0][3] = 1;
        E[3][3] = 1;
        E[4][3] = 1;
        E[7][3] = 1;
        E[0][4] = 1;
        E[7][4] = 1;

        F[0][0] = 1;
        F[1][0] = 1;
        F[2][0] = 1;
        F[3][0] = 1;
        F[4][0] = 1;
        F[5][0] = 1;
        F[6][0] = 1;
        F[7][0] = 1;
        F[0][1] = 1;
        F[1][1] = 1;
        F[2][1] = 1;
        F[3][1] = 1;
        F[4][1] = 1;
        F[5][1] = 1;
        F[6][1] = 1;
        F[7][1] = 1;
        F[0][3] = 1;
        F[1][3] = 1;
        F[3][3] = 1;
        F[0][4] = 1;
        F[1][4] = 1;
        F[3][4] = 1;
        F[0][5] = 1;
        F[1][5] = 1;

        G[1][0] = 1;
        G[2][0] = 1;
        G[3][0] = 1;
        G[4][0] = 1;
        G[5][0] = 1;
        G[6][0] = 1;
        G[0][1] = 1;
        G[7][1] = 1;
        G[0][2] = 1;
        G[7][2] = 1;
        G[0][3] = 1;
        G[4][3] = 1;
        G[7][3] = 1;
        G[0][4] = 1;
        G[4][4] = 1;
        G[5][4] = 1;
        G[6][4] = 1;

        H[0][0] = 1;
        H[1][0] = 1;
        H[2][0] = 1;
        H[3][0] = 1;
        H[4][0] = 1;
        H[5][0] = 1;
        H[6][0] = 1;
        H[7][0] = 1;
        H[3][1] = 1;
        H[4][1] = 1;
        H[3][2] = 1;
        H[4][2] = 1;
        H[3][3] = 1;
        H[4][3] = 1;
        H[0][4] = 1;
        H[1][4] = 1;
        H[2][4] = 1;
        H[3][4] = 1;
        H[4][4] = 1;
        H[5][4] = 1;
        H[6][4] = 1;
        H[7][4] = 1;

        I[0][0] = 1;
        I[7][0] = 1;
        I[0][1] = 1;
        I[7][1] = 1;
        I[0][2] = 1;
        I[1][2] = 1;
        I[2][2] = 1;
        I[3][2] = 1;
        I[4][2] = 1;
        I[5][2] = 1;
        I[6][2] = 1;
        I[7][2] = 1;
        I[0][3] = 1;
        I[7][3] = 1;
        I[0][4] = 1;
        I[7][4] = 1;

        J[0][4] = 1;
        J[1][4] = 1;
        J[2][4] = 1;
        J[3][4] = 1;
        J[4][4] = 1;
        J[5][4] = 1;
        J[6][3] = 1;
        J[7][2] = 1;
        J[7][1] = 1;
        J[6][0] = 1;

        K[0][0] = 1;
        K[1][0] = 1;
        K[2][0] = 1;
        K[3][0] = 1;
        K[4][0] = 1;
        K[5][0] = 1;
        K[6][0] = 1;
        K[7][0] = 1;
        K[3][1] = 1;
        K[4][1] = 1;
        K[2][2] = 1;
        K[5][2] = 1;
        K[1][3] = 1;
        K[6][3] = 1;
        K[0][4] = 1;
        K[7][4] = 1;

        L[0][0] = 1;
        L[1][0] = 1;
        L[2][0] = 1;
        L[3][0] = 1;
        L[4][0] = 1;
        L[5][0] = 1;
        L[6][0] = 1;
        L[7][0] = 1;
        L[7][1] = 1;
        L[7][2] = 1;
        L[7][3] = 1;
        L[7][4] = 1;

        M[0][0] = 1;
        M[1][0] = 1;
        M[2][0] = 1;
        M[3][0] = 1;
        M[4][0] = 1;
        M[5][0] = 1;
        M[6][0] = 1;
        M[7][0] = 1;
        M[1][1] = 1;
        M[2][2] = 1;
        M[1][3] = 1;
        M[0][4] = 1;
        M[1][4] = 1;
        M[2][4] = 1;
        M[3][4] = 1;
        M[4][4] = 1;
        M[5][4] = 1;
        M[6][4] = 1;
        M[7][4] = 1;

        N[0][0] = 1;
        N[1][0] = 1;
        N[2][0] = 1;
        N[3][0] = 1;
        N[4][0] = 1;
        N[5][0] = 1;
        N[6][0] = 1;
        N[7][0] = 1;
        N[2][1] = 1;
        N[3][2] = 1;
        N[4][3] = 1;
        N[0][4] = 1;
        N[1][4] = 1;
        N[2][4] = 1;
        N[3][4] = 1;
        N[4][4] = 1;
        N[5][4] = 1;
        N[6][4] = 1;
        N[7][4] = 1;

        O[1][0] = 1;
        O[2][0] = 1;
        O[3][0] = 1;
        O[4][0] = 1;
        O[5][0] = 1;
        O[6][0] = 1;
        O[0][1] = 1;
        O[7][1] = 1;
        O[0][2] = 1;
        O[7][2] = 1;
        O[0][3] = 1;
        O[7][3] = 1;
        O[1][4] = 1;
        O[2][4] = 1;
        O[3][4] = 1;
        O[4][4] = 1;
        O[5][4] = 1;
        O[6][4] = 1;

        P[0][0] = 1;
        P[1][0] = 1;
        P[2][0] = 1;
        P[3][0] = 1;
        P[4][0] = 1;
        P[5][0] = 1;
        P[6][0] = 1;
        P[7][0] = 1;
        P[0][1] = 1;
        P[3][1] = 1;
        P[0][2] = 1;
        P[3][2] = 1;
        P[0][3] = 1;
        P[3][3] = 1;
        P[1][4] = 1;
        P[2][4] = 1;

        Q[1][0] = 1;
        Q[2][0] = 1;
        Q[3][0] = 1;
        Q[4][0] = 1;
        Q[5][0] = 1;
        Q[6][0] = 1;
        Q[0][1] = 1;
        Q[7][1] = 1;
        Q[0][2] = 1;
        Q[4][2] = 1;
        Q[7][2] = 1;
        Q[0][3] = 1;
        Q[5][3] = 1;
        Q[7][3] = 1;
        Q[1][4] = 1;
        Q[2][4] = 1;
        Q[3][4] = 1;
        Q[4][4] = 1;
        Q[6][4] = 1;

        r[1][0] = 1;
        r[2][0] = 1;
        r[3][0] = 1;
        r[4][0] = 1;
        r[5][0] = 1;
        r[6][0] = 1;
        r[7][0] = 1;
        r[0][1] = 1;
        r[3][1] = 1;
        r[4][1] = 1;
        r[0][2] = 1;
        r[3][2] = 1;
        r[5][2] = 1;
        r[0][3] = 1;
        r[3][3] = 1;
        r[6][3] = 1;
        r[1][4] = 1;
        r[2][4] = 1;
        r[7][4] = 1;

        S[1][0] = 1;
        S[2][0] = 1;
        S[7][0] = 1;
        S[0][1] = 1;
        S[3][1] = 1;
        S[4][1] = 1;
        S[7][1] = 1;
        S[0][2] = 1;
        S[3][2] = 1;
        S[4][2] = 1;
        S[7][2] = 1;
        S[0][3] = 1;
        S[3][3] = 1;
        S[4][3] = 1;
        S[7][3] = 1;
        S[0][4] = 1;
        S[5][4] = 1;
        S[6][4] = 1;

        T[0][0] = 1;
        T[0][1] = 1;
        T[0][2] = 1;
        T[1][2] = 1;
        T[2][2] = 1;
        T[3][2] = 1;
        T[4][2] = 1;
        T[5][2] = 1;
        T[6][2] = 1;
        T[7][2] = 1;
        T[0][3] = 1;
        T[0][4] = 1;

        U[0][0] = 1;
        U[1][0] = 1;
        U[2][0] = 1;
        U[3][0] = 1;
        U[4][0] = 1;
        U[5][0] = 1;
        U[6][1] = 1;
        U[6][2] = 1;
        U[7][2] = 1;
        U[6][3] = 1;
        U[7][3] = 1;
        U[0][4] = 1;
        U[1][4] = 1;
        U[2][4] = 1;
        U[3][4] = 1;
        U[4][4] = 1;
        U[5][4] = 1;
        U[7][1] = 1;

        V[0][0] = 1;
        V[1][0] = 1;
        V[2][0] = 1;
        V[3][0] = 1;
        V[4][0] = 1;
        V[5][0] = 1;
        V[6][1] = 1;
        V[7][2] = 1;
        V[6][3] = 1;
        V[0][4] = 1;
        V[1][4] = 1;
        V[2][4] = 1;
        V[3][4] = 1;
        V[4][4] = 1;
        V[5][4] = 1;

        W[1][0] = 1;
        W[2][0] = 1;
        W[3][0] = 1;
        W[4][0] = 1;
        W[5][0] = 1;
        W[6][1] = 1;
        W[7][1] = 1;
        W[6][2] = 1;
        W[7][2] = 1;
        W[6][3] = 1;
        W[7][3] = 1;
        W[0][4] = 1;
        W[1][4] = 1;
        W[2][4] = 1;
        W[3][4] = 1;
        W[4][4] = 1;
        W[5][4] = 1;
        W[0][0] = 1;

        X[0][0] = 1;
        X[7][0] = 1;
        X[1][1] = 1;
        X[2][1] = 1;
        X[6][1] = 1;
        X[7][1] = 1;
        X[2][2] = 1;
        X[3][2] = 1;
        X[4][2] = 1;
        X[5][2] = 1;
        X[1][3] = 1;
        X[2][3] = 1;
        X[5][3] = 1;
        X[6][3] = 1;
        X[0][4] = 1;
        X[7][4] = 1;

        Y[0][0] = 1;
        Y[1][1] = 1;
        Y[2][2] = 1;
        Y[3][2] = 1;
        Y[4][2] = 1;
        Y[5][2] = 1;
        Y[6][2] = 1;
        Y[7][2] = 1;
        Y[1][3] = 1;
        Y[0][4] = 1;

        Z[0][0] = 1;
        Z[5][0] = 1;
        Z[6][0] = 1;
        Z[7][0] = 1;
        Z[0][1] = 1;
        Z[4][1] = 1;
        Z[5][1] = 1;
        Z[7][1] = 1;
        Z[0][2] = 1;
        Z[3][2] = 1;
        Z[4][2] = 1;
        Z[7][2] = 1;
        Z[0][3] = 1;
        Z[2][3] = 1;
        Z[3][3] = 1;
        Z[7][3] = 1;
        Z[0][4] = 1;
        Z[1][4] = 1;
        Z[2][4] = 1;
        Z[7][4] = 1;




    }

    private static int RIGHE = 8;
    private static int COLONNE = 8;
    TachoMotor motor;
    TachoMotor motor1;
    TachoMotor motor2;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter);
        setSupportActionBar(findViewById(R.id.my_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button print_button = findViewById(R.id.print_button);
       // Button create_button = findViewById(R.id.create_button);

        EditText edit_t = findViewById(R.id.edit_text);



         print_button.setOnClickListener(
                 view -> {
                     x = edit_t.getText().toString();
                     y = x.toCharArray();
                     length = y.length;
                     try{
                         EV3 ev3 = new EV3(new BluetoothConnection("EV3").connect());
                         for(int i=length-1;i>=0;i--){
                             if(y[i]=='A' || y[i]=='a'){
                                 draw = A;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='B' || y[i]=='b'){
                                 draw = B;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='C' || y[i]=='c'){
                                 draw = C;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='D' || y[i]=='d'){
                                 draw = D;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='E' || y[i]=='e'){
                                 draw = E;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='F' || y[i]=='f'){
                                 draw = F;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='G' || y[i]=='g'){
                                 draw = G;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='H' || y[i]=='h'){
                                 draw = H;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='I' || y[i]=='i'){
                                 draw = I;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='J' || y[i]=='j'){
                                 draw = J;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='K' || y[i]=='k'){
                                 draw = K;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='L' || y[i]=='l'){
                                 draw = L;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='M' || y[i]=='m'){
                                 draw = M;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='N' || y[i]=='n'){
                                 draw = N;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='O'|| y[i]=='o'){
                                 draw = O;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='P'|| y[i]=='p'){
                                 draw = P;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='Q'|| y[i]=='q'){
                                 draw = Q;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='R'|| y[i]=='r'){
                                 draw = r;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='S'|| y[i]=='s'){
                                 draw = S;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='T'|| y[i]=='t'){
                                 draw = T;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='U'|| y[i]=='u'){
                                 draw = U;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='V'|| y[i]=='v'){
                                 draw = V;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='W'|| y[i]=='w'){
                                 draw = W;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='X'|| y[i]=='x'){
                                 draw = X;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='Y'|| y[i]=='y'){
                                 draw = Y;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }
                             if(y[i]=='Z'|| y[i]=='z') {
                                 draw = Z;
                                 Prelude.trap(() -> ev3.run(Letter.this::draw));
                             }

                         }

                     }
                     catch (IOException e){
                     e.printStackTrace();
                     }


                 });


    }
    public void draw(EV3.Api api){
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
            for(int y = COLONNE-1; i >= 0; y--){
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
}
