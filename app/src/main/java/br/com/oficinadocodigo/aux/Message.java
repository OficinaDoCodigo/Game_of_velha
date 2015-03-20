package br.com.oficinadocodigo.aux;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by henry on 14/03/15.
 */
public class Message {

    public static void toast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }





}
