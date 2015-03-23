package br.com.oficinadocodigo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;

import br.com.oficinadocodigo.aux.TempGameData;


public class GameActivity extends ActionBarActivity implements View.OnClickListener{


    private ProgressBar timerOne;
    private ProgressBar timerTwo;

    private TextView playerOne;
    private TextView playerTwo;

    private String simbol_one;
    private String simbol_two;

    private TextView sp1;
    private TextView sp2;

    private int totalOne = TempGameData.TIME;
    private int totalTwo = TempGameData.TIME;

    /* TIMER */
    private Chronometer timep1;
    private Chronometer timep2;
    /* Table */
    private TextView a11;
    private TextView a12;
    private TextView a13;

    private TextView a21;
    private TextView a22;
    private TextView a23;

    private TextView a31;
    private TextView a32;
    private TextView a33;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.getSupportActionBar().hide();

        settings();
        start();
        timep1.setBase(SystemClock.elapsedRealtime());
        timep2.setBase(SystemClock.elapsedRealtime());



    }


    /* START GAME */
    private void start(){
        showInitialInfo();

    }


    /* SHOW INITIAL INFO */
    private void showInitialInfo(){
        AlertDialog.Builder info = new AlertDialog.Builder(this);
        info.setTitle("Preparem-se")
        .setMessage(TempGameData.STARTER+" começa o jogo")
        .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                timer(TempGameData.STARTER).start();
            }
        })
        .create()
        .show();
    }





    private void settings(){
        timerOne = (ProgressBar) findViewById(R.id.timerPlayOne);
        timerTwo = (ProgressBar) findViewById(R.id.timerPlayTwo);

        playerOne = (TextView) findViewById(R.id.playerOneGame);
        playerTwo = (TextView) findViewById(R.id.playerTwoGame);

        sp1 = (TextView) findViewById(R.id.simbolPlayOne);
        sp2 = (TextView) findViewById(R.id.simbolPlayTwo);

        sp1.setText(TempGameData.SIMBOL_P1);
        sp2.setText(TempGameData.SIMBOL_P2);

        timerOne.setMax(totalOne);
        timerOne.setProgress(totalOne);

        timerTwo.setMax(totalTwo);
        timerTwo.setProgress(totalTwo);

        playerOne.setText(TempGameData.PLAYER_ONE);
        playerTwo.setText(TempGameData.PLAYER_TWO);


        /* TIME */
        //timep1 = (Chronometer) findViewById(R.id.timep1);
        //timep2 = (Chronometer) findViewById(R.id.timep2);

        /* Table */
        a11 = (TextView) findViewById(R.id.a11);
        a12 = (TextView) findViewById(R.id.a12);
        a13 = (TextView) findViewById(R.id.a13);
        a21 = (TextView) findViewById(R.id.a21);
        a22 = (TextView) findViewById(R.id.a22);
        a23 = (TextView) findViewById(R.id.a23);
        a31 = (TextView) findViewById(R.id.a31);
        a32 = (TextView) findViewById(R.id.a32);
        a33 = (TextView) findViewById(R.id.a33);


    }




    private Thread timer(String player){
        Thread progress = null;
        if(player.equals(playerOne.getText().toString())){
            progress = new Thread(){
                @Override
                public void run() {
                    while(totalOne >= 0){
                        try {
                            sleep(1000);
                           // totalOne--;
                            timerOne.setProgress(totalOne);

                        }catch (InterruptedException e){

                        }
                    }
                }
            };
        }
        if(player.equals(playerTwo.getText().toString())){
            progress = new Thread(){
                @Override
                public void run() {
                    while(totalTwo >= 0){
                        try {
                            sleep(1000);
                           // totalTwo--;
                            timerTwo.setProgress(totalTwo);

                        }catch (InterruptedException e){

                        }
                    }
                }
            };
        }
        return progress;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.a11:
                break;

        }
    }
}
