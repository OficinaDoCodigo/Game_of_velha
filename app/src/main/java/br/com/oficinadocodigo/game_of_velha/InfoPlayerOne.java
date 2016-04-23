package br.com.oficinadocodigo.game_of_velha;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.oficinadocodigo.ChoosePlayerTwo;
import br.com.oficinadocodigo.R;
import br.com.oficinadocodigo.aux.TempGameData;


public class InfoPlayerOne extends ActionBarActivity implements View.OnClickListener {

    private Button btn_next;
    private EditText nomePlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_player_one);
        this.getSupportActionBar().hide();

        btn_next = (Button) findViewById(R.id.btn_escolherPlayer);
        nomePlayer1 = (EditText) findViewById(R.id.namePlayerOne);

        btn_next.setOnClickListener(this);

        nomePlayer1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if(nomePlayer1.getText().toString().equals("")){
                    btn_next.setAlpha(0.5f);
                    btn_next.setClickable(false);
                }else{
                    btn_next.setAlpha(1);
                    btn_next.setClickable(true);
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_escolherPlayer:
                TempGameData.PLAYER_ONE = nomePlayer1.getText().toString();
                trocarTela(InfoPlayerTwo.class);
        }
    }

    private void trocarTela(Class next){
        startActivity(new Intent(this,next));
        //InfoPlayerOne.this.finish();
    }

}
