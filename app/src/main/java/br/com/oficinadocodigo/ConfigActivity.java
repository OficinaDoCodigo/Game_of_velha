package br.com.oficinadocodigo;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;

import br.com.oficinadocodigo.aux.Message;
import br.com.oficinadocodigo.aux.TempGameData;


public class ConfigActivity extends ActionBarActivity {

    private Switch ck_sound;
    private SeekBar seekbar_volume_config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        this.getSupportActionBar().hide();

       // ck_sound                = (Switch) findViewById(R.id.ck_play_sound_config);
       // seekbar_volume_config   = (SeekBar) findViewById(R.id.seekbar_volume_config);

       // ck_sound.setChecked(TempGameData.SOUND_PLAY);
        //seekbar_volume_config.setProgress(TempGameData.VOLUME);
/**
        ck_sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(TempGameData.SOUND_PLAY){
                    MenuActivity.media.stop();
                    TempGameData.SOUND_PLAY = false;
                }else{
                    MenuActivity.media = MediaPlayer.create(ConfigActivity.this,R.raw.sound_mortal);
                    MenuActivity.media.start();
                    MenuActivity.media.setLooping(true);
                    TempGameData.SOUND_PLAY = true;
                    MenuActivity.media.setVolume(TempGameData.VOLUME*0.01f,TempGameData.VOLUME*0.01f);
                }
            }
        });

        seekbar_volume_config.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TempGameData.VOLUME = progress;
                float res = progress*0.01f;
                MenuActivity.media.setVolume(res,res);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
 **/
    }


}
