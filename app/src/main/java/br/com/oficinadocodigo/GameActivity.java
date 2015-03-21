package br.com.oficinadocodigo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import br.com.oficinadocodigo.aux.TempGameData;


public class GameActivity extends ActionBarActivity {

    private ProgressBar timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.getSupportActionBar().hide();

        timer = (ProgressBar) findViewById(R.id.timer);

        timer.setMax(TempGameData.TIME);
        timer.setProgress(TempGameData.TIME-3);



    }

}
