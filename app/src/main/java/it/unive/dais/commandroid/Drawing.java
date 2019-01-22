package it.unive.dais.commandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import it.unive.dais.legodroid.lib.EV3;
import it.unive.dais.legodroid.lib.comm.BluetoothConnection;

public class Drawing extends AppCompatActivity implements View.OnClickListener{

    private static int RIGHE = 7;
    private static int COLONNE = 4;
    private Button[][] buttons = new Button[RIGHE][COLONNE];
    protected int[][] draw = new int[RIGHE][COLONNE];

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            EV3 ev3 = new EV3(new BluetoothConnection("EV3").connect());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //FloatingButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // non inviare se la matrice è nulla
                if(!buttonsNull()){
                    Snackbar.make(view, "Non hai selezionato nessuna casella", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        // Commandroid: genera due matrice, azzera quella "draw" e inizializza "buttons"
        for(int i = 0; i < RIGHE; i++){
            for(int y = 0; y < COLONNE; y++){
                String buttonID = "b" + i + y;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][y] = (Button) findViewById(resID);
                buttons[i][y].setOnClickListener(this);
                draw[i][y] = 0;
            }
        }
    }


    private void draw(int[][] matrix){
        //codice
    }
    public void ButtonsOnClick(Button button, int x, int y){
        if(draw[x][y] == 0){
            buttons[x][y].setText("X");
            draw[x][y] = 1;
        }
        else{
            buttons[x][y].setText("");
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
            default:
                break;
        }
    }
}

