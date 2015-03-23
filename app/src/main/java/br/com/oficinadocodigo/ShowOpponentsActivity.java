package br.com.oficinadocodigo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.oficinadocodigo.R;
import br.com.oficinadocodigo.aux.TempGameData;

public class ShowOpponentsActivity extends ActionBarActivity {

    public static final int SPLASH_DISPLAY_LENGTH = 3000;
    private TextView p1;
    private TextView p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_opponents);
        this.getSupportActionBar().hide();

        p1 = (TextView) findViewById(R.id.label_p1_show);
        p2 = (TextView) findViewById(R.id.label_p2_show);

        p1.setText(TempGameData.PLAYER_ONE);
        p2.setText(TempGameData.PLAYER_TWO);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ShowOpponentsActivity.this, GameActivity.class));
                ShowOpponentsActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


    }

}
