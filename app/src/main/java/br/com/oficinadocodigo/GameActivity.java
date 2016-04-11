package br.com.oficinadocodigo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;
import br.com.oficinadocodigo.aux.TempGameData;


public class GameActivity extends ActionBarActivity implements View.OnClickListener{

    String jogadorDaVez;
    int contJogadas = 0;

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
    private TextView timep1;
    private TextView timep2;
    /* Table */

    TextView[][] a;
    int aId[][] = new int[3][3];

    private TextView a11;
    private TextView a12;
    private TextView a13;

    private TextView a21;
    private TextView a22;
    private TextView a23;

    private TextView a31;
    private TextView a32;
    private TextView a33;


    long millisInFutureT1 = totalOne*1000;
    long millisInFutureT2 = totalOne*1000;

    ChronoX t1 = new ChronoX(millisInFutureT1,1000);;
    ChronoY t2 = new ChronoY(millisInFutureT2,1000);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.getSupportActionBar().hide();

        settings();
        start();

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
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                if (TempGameData.STARTER.equals(TempGameData.PLAYER_ONE)) {
                    jogadorDaVez = TempGameData.PLAYER_ONE;
                    timer(playerOne.getText().toString()).start();
                    t1.start();

                    System.out.println("\n\n----Player 1 ----  "+TempGameData.STARTER+"  ----\n\n");

                }else{
                    jogadorDaVez = TempGameData.PLAYER_TWO;
                    System.out.println("\n\n---- Player 2 ---- "+TempGameData.STARTER+" ----\n\n");
                    timer(playerTwo.getText().toString()).start();
                    t2.start();
                }

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
        timep1 = (TextView) findViewById(R.id.timep1);
        timep2 = (TextView) findViewById(R.id.timep2);

        /* Table */

        a = new TextView[3][3];
        a[0][0] = (TextView) findViewById(R.id.a11);
        a[0][1] = (TextView) findViewById(R.id.a12);
        a[0][2] = (TextView) findViewById(R.id.a13);

        a[1][0] = (TextView) findViewById(R.id.a21);
        a[1][1] = (TextView) findViewById(R.id.a22);
        a[1][2] = (TextView) findViewById(R.id.a23);

        a[2][0] = (TextView) findViewById(R.id.a31);
        a[2][1] = (TextView) findViewById(R.id.a32);
        a[2][2] = (TextView) findViewById(R.id.a33);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                a[i][j].setOnClickListener(this);
            }
        }


        if(totalOne == 60){
            timep1.setText("01:00");
            timep2.setText("01:00");
        }else if(totalOne == 5){
            timep1.setText("00:0"+totalOne);
            timep2.setText("00:0"+totalTwo);
        }
        else{
            timep1.setText("00:"+totalOne);
            timep2.setText("00:"+totalTwo);
        }

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
                            totalOne--;
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
                            totalTwo--;
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
        realizarJogada(v.getId());
    }

    public void realizarJogada(int idView){
        for (int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){

                if(idView == a[i][j].getId()){
                    if(a[i][j].getText().toString().length() != 1) {


                        if (jogadorDaVez.equals(TempGameData.STARTER)) {

                            a[i][j].setText("x");
                            if(verificarJogo()) {
                                jogoTerminado(jogadorDaVez);
                                break;
                            }

                            if(jogadorDaVez.equals(TempGameData.PLAYER_ONE)) {
                                t1.cancel();
                                t2 = new ChronoY(millisInFutureT2,1000);
                                t2.start();
                                jogadorDaVez = TempGameData.PLAYER_TWO;
                            }else {
                                t2.cancel();
                                t1 = new ChronoX(millisInFutureT1,1000);
                                t1.start();
                                jogadorDaVez = TempGameData.PLAYER_ONE;
                            }

                            contJogadas++;
                        } else {

                            a[i][j].setText("o");
                            if(verificarJogo()) {
                                jogoTerminado(jogadorDaVez);
                                break;
                            }

                            if(jogadorDaVez.equals(TempGameData.PLAYER_ONE)) {
                                t1.cancel();
                                t2 = new ChronoY(millisInFutureT2,1000);
                                t2.start();
                                jogadorDaVez = TempGameData.PLAYER_TWO;
                            }else {
                                t2.cancel();
                                t1 = new ChronoX(millisInFutureT1,1000);
                                t1.start();
                                jogadorDaVez = TempGameData.PLAYER_ONE;
                            }

                            jogadorDaVez = TempGameData.STARTER;
                            contJogadas++;
                        }

                        if(contJogadas == 9){
                            t1.cancel();
                            t2.cancel();
                            desabilitarBotoes();
                            Toast toast = Toast.makeText(this, "Empate!", Toast.LENGTH_SHORT);
                            toast.show();
                            desabilitarBotoes();
                        }

                    }


                }

            }
        }
    }

    public boolean verificarJogo(){

        for(int i = 0; i<3; i++) {
            //Linhas
            if (a[i][0].getText().toString().equals("x") && a[i][0].getText().toString().equals(a[i][1].getText().toString()) && a[i][0].getText().toString().equals(a[i][2].getText().toString())) {
                a[i][0].setTextColor(Color.RED);
                a[i][1].setTextColor(Color.RED);
                a[i][2].setTextColor(Color.RED);
                return true;
            }
            if (a[i][0].getText().toString().equals("o") && a[i][0].getText().toString().equals(a[i][1].getText().toString()) && a[i][0].getText().toString().equals(a[i][2].getText().toString())) {
                a[i][0].setTextColor(Color.RED);
                a[i][1].setTextColor(Color.RED);
                a[i][2].setTextColor(Color.RED);
                return true;
            }
            //Colunas
            if (a[0][i].getText().toString().equals("x") && a[0][i].getText().toString().equals(a[1][i].getText().toString()) && a[0][i].getText().toString().equals(a[2][i].getText().toString())) {
                a[0][i].setTextColor(Color.RED);
                a[1][i].setTextColor(Color.RED);
                a[2][i].setTextColor(Color.RED);
                return true;
            }
            if (a[0][i].getText().toString().equals("o") && a[0][i].getText().toString().equals(a[1][i].getText().toString()) && a[0][i].getText().toString().equals(a[2][i].getText().toString())) {
                a[0][i].setTextColor(Color.RED);
                a[1][i].setTextColor(Color.RED);
                a[2][i].setTextColor(Color.RED);
                return true;
            }
        }

        //diagonal principal
        if(a[0][0].getText().toString().equals("o") && a[0][0].getText().toString().equals(a[1][1].getText().toString()) && a[0][0].getText().toString().equals(a[2][2].getText().toString())){
            a[0][0].setTextColor(Color.RED);
            a[1][1].setTextColor(Color.RED);
            a[2][2].setTextColor(Color.RED);
            return true;
        }
        if(a[0][0].getText().toString().equals("x") && a[0][0].getText().toString().equals(a[1][1].getText().toString()) && a[0][0].getText().toString().equals(a[2][2].getText().toString())){
            a[0][0].setTextColor(Color.RED);
            a[1][1].setTextColor(Color.RED);
            a[2][2].setTextColor(Color.RED);
            return true;
        }
        //Diagonal secundária
        if(a[0][2].getText().toString().equals("x") && a[0][2].getText().toString().equals(a[1][1].getText().toString()) && a[0][2].getText().toString().equals(a[2][0].getText().toString())){
            a[0][2].setTextColor(Color.RED);
            a[1][1].setTextColor(Color.RED);
            a[2][0].setTextColor(Color.RED);
            return true;
        }
        if(a[0][2].getText().toString().equals("o") && a[0][2].getText().toString().equals(a[1][1].getText().toString()) && a[0][2].getText().toString().equals(a[2][0].getText().toString())){
            a[0][2].setTextColor(Color.RED);
            a[1][1].setTextColor(Color.RED);
            a[2][0].setTextColor(Color.RED);
            return true;
        }
        return false;
    }

    public void desabilitarBotoes(){
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3; j++){
                a[i][j].setEnabled(false);
            }
        }
    }

    public void jogoTerminado(String playerVencedor){
        if(playerVencedor.equals(TempGameData.PLAYER_ONE)){
            t1.cancel();
        }else{
            t2.cancel();
        }
        Toast toast = Toast.makeText(this, playerVencedor+" ganhou!", Toast.LENGTH_SHORT);
        toast.show();
        desabilitarBotoes();
    }

    /* CLASSES AUXILIADORAS */

    class ChronoX extends CountDownTimer {
        public ChronoX(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long milis) {
            millisInFutureT1 = milis;
            String format   = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(milis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milis)),                                                TimeUnit.MILLISECONDS.toSeconds(milis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milis)));
            timep1.setText(format);
        }
        @Override
        public void onFinish() {
            timep1.setText("00:00");
            t2.cancel();
            jogoTerminado(TempGameData.PLAYER_TWO);
        }
    }



    class ChronoY extends CountDownTimer {
        public ChronoY(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long milis) {
            millisInFutureT2 = milis;
            String format   =
                    String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(milis) -
                                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milis)),
                    TimeUnit.MILLISECONDS.toSeconds(milis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milis)));
            timep2.setText(format);
        }
        @Override
        public void onFinish() {
            t1.cancel();
            timep2.setText("00:00");
            jogoTerminado(TempGameData.PLAYER_ONE);
        }
    }

    @Override
    protected void onPause() {
        desabilitarBotoes();
        t1.cancel();
        t2.cancel();
        super.onPause();
        finish();
    }

}
