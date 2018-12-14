package it.unive.dais.commandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;

import it.unive.dais.legodroid.lib.plugs.TachoMotor;

public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.MENU_1:
			/*
			 	Codice di gestione della voce MENU_1
			 */
                Intent intent = new Intent(this, OnBoarding.class);
                this.startActivity(intent);

                break;
            case R.id.MENU_2:
			/*
			 	Codice di gestione della voce MENU_2
			 */
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
