package br.com.oficinadocodigo;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.oficinadocodigo.aux.TempGameData;


public class MenuActivity extends ActionBarActivity implements View.OnClickListener   {


    public static MediaPlayer media;
    private Button btn_novo;
    private Button btn_config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.getSupportActionBar().hide();
        //media = MediaPlayer.create(MenuActivity.this, R.raw.sound_mortal);
        //media.start();
        //media.setLooping(true);

        btn_novo = (Button) findViewById(R.id.btn_jogar_menu);
        btn_config = (Button) findViewById(R.id.btn_config_menu);

        btn_novo.setOnClickListener(this);
        btn_config.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_jogar_menu:
                trocarTela(ChoosePlayerOne.class);
                break;
            case R.id.btn_config_menu:
                trocarTela(ConfigActivity.class);
                break;
        }
    }

    private void trocarTela(Class next) {
        startActivity(new Intent(this, next));
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MenuActivity.this);
        alert.setIcon(R.id.icon);
        alert.setTitle("").setMessage("Deseja sair?").create();
        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        alert.setNegativeButton("Não", null);
        alert.show();
    }
}
