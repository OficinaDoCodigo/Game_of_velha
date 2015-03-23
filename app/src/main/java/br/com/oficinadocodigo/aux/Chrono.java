package br.com.oficinadocodigo.aux;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by henry on 22/03/15.
 */
public class Chrono extends CountDownTimer {

    private String time;
    public void uni(TextView time){
       time.setText(""+this.time);
    }

    public Chrono(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        long milis      = millisUntilFinished;
        String format   = String.format("%00", TimeUnit.MILLISECONDS.toSeconds(milis));
        time = format;
    }

    @Override
    public void onFinish() {

    }
}
