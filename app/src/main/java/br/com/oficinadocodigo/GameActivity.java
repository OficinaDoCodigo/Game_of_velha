package br.com.oficinadocodigo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.oficinadocodigo.aux.TempGameData;


public class GameActivity extends ActionBarActivity {


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.getSupportActionBar().hide();

        timerOne = (ProgressBar) findViewById(R.id.timerPlayOne);
        timerTwo = (ProgressBar) findViewById(R.id.timerPlayTwo);

        playerOne = (TextView) findViewById(R.id.playerOneGame);
        playerTwo = (TextView) findViewById(R.id.playerTwoGame);

        sp1 = (TextView) findViewById(R.id.simbolPlayOne);
        sp2 = (TextView) findViewById(R.id.simbolPlayTwo);

        sp1.setText(TempGameData.SIMBOL_P1);
        sp2.setText(TempGameData.SIMBOL_P2);

        /*
        timerOne.setMax(totalOne);
        timerTwo.setMax(totalTwo);
        timerOne.setProgress(totalOne);
        timerTwo.setProgress(totalTwo);
         */
        playerOne.setText(TempGameData.PLAYER_ONE);
        playerTwo.setText(TempGameData.PLAYER_TWO);




        Thread progressOne = new Thread(){
            @Override
            public void run() {
                timerOne.setMax(totalOne);
                timerOne.setProgress(totalOne);

                while(totalOne >= 0){
                    try {
                        sleep(1000);
                        totalOne--;
                        timerOne.setProgress(totalOne);
                    }catch (InterruptedException e){

                    }
                }
            }
        };

        progressOne.start();


    }

}
