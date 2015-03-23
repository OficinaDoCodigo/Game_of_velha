package br.com.oficinadocodigo.aux;

import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

/**
 * Created by henry on 22/03/15.
 */
public class Chrono extends CountDownTimer {


    public Chrono(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        long milis      = millisUntilFinished;
        String format   = String.format("%00", TimeUnit.MILLISECONDS.toSeconds(milis));
    }

    @Override
    public void onFinish() {

    }
}
