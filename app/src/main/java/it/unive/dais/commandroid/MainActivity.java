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

import it.unive.dais.legodroid.lib.EV3;
import it.unive.dais.legodroid.lib.plugs.TachoMotor;

public class MainActivity extends AppCompatActivity {

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        Intent intent1, intent2;
        switch(id)
        {
            case R.id.MAIN_1:
			/*
			 	Codice di gestione della voce MAIN_1
			 *//*
                intent1 = new Intent(this, OnBoarding.class);
                this.startActivity(intent1);

                break;
            case R.id.MAIN_2:
			/*
			 	Codice di gestione della voce MAIN_2
			 *//*
                intent2 = new Intent(this, Drawing.class);
                this.startActivity(intent2);
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    */

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
}
