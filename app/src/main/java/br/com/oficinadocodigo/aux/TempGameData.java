package br.com.oficinadocodigo.aux;

import android.net.Uri;

import java.net.URI;

import br.com.oficinadocodigo.R;

/**
 * Created by henry on 20/03/15.
 */
public class TempGameData {


    public static boolean   SOUND_PLAY = true;
    public static int       VOLUME = 100;

    public static String    PLAYER_ONE = "player1";
    public static String    PLAYER_TWO = "player2";
    public static String    STARTER;

    public static Uri ICON_PLAYER_ONE = Uri.parse("R.drawable.iconeloiro");
    public static Uri ICON_PLAYER_TWO = Uri.parse("R.drawable.icon");

    public static int       RESULT;
    public static String    PLAYER_WIN = "";
    public static Uri       ICON_PLAYER_WIN;

    public static int       TIME = 60;

    public  static String SIMBOL_P1;
    public  static String SIMBOL_P2;



    /*
    public String getPLAYER_ONE(){
        return this.PLAYER_ONE;
    }
    public void setPLAYER_ONE(String player){
        this.PLAYER_ONE = player;
    }

    public String getPLAYER_TWO(){
        return this.PLAYER_TWO;
    }
    public void setPLAYER_TWO(String player){
        this.PLAYER_TWO = player;
    }


    public int getTime(){
        return this.TIME;
    }
    public void setTime(int time){
        this.TIME = time;
    }
    */

}
