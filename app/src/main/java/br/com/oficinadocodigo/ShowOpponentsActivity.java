package br.com.oficinadocodigo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import br.com.oficinadocodigo.R;

public class ShowOpponentsActivity extends ActionBarActivity {

    public static final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_opponents);
        this.getSupportActionBar().hide();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ShowOpponentsActivity.this, GameActivity.class));
                ShowOpponentsActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


    }

}
