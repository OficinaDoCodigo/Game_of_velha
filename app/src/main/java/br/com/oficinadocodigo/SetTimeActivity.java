package br.com.oficinadocodigo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

import br.com.oficinadocodigo.R;
import br.com.oficinadocodigo.aux.Message;
import br.com.oficinadocodigo.aux.TempGameData;

public class SetTimeActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView simbolP1;
    private TextView simbolP2;
    private TextView P1;
    private TextView P2;
    private Button btn_save_adjust;
    private RadioGroup  rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);
        this.getSupportActionBar().hide();

        btn_save_adjust = (Button) findViewById(R.id.btn_save_adjust);
        rg              = (RadioGroup) findViewById(R.id.rg);
        simbolP1        = (TextView) findViewById(R.id.simbolP1);
        simbolP2        = (TextView) findViewById(R.id.simbolP2);
        P1 = (TextView) findViewById(R.id.p1);
        P2 = (TextView) findViewById(R.id.p2);

        P1.setText(TempGameData.PLAYER_ONE);
        P2.setText(TempGameData.PLAYER_TWO);



        gerar();

        btn_save_adjust.setOnClickListener(this);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = rg.getCheckedRadioButtonId();

                if (id == R.id.rb1) {
                    TempGameData.TIME = 60;
                }
                if (id == R.id.rb2) {
                    TempGameData.TIME = 30;
                }
                if (id == R.id.rb3) {
                    TempGameData.TIME = 15;
                }
                if (id == R.id.rb4) {
                    TempGameData.TIME = 5;
                }
            }
        });



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save_adjust:
                trocarTela(ShowOpponentsActivity.class);
            break;
        }
    }


    private void gerar(){

        Random r = new Random();
        int val  = r.nextInt(2);
        if(val == 1){
            simbolP1.setText("x");
            simbolP2.setText("o");
            TempGameData.SIMBOL_P1 = "x";
            TempGameData.SIMBOL_P2 = "o";
            TempGameData.STARTER = TempGameData.PLAYER_ONE;
        }else{
            simbolP1.setText("o");
            simbolP2.setText("x");
            TempGameData.SIMBOL_P1 = "o";
            TempGameData.SIMBOL_P2 = "x";
            TempGameData.STARTER = TempGameData.PLAYER_TWO;
        }
    }

    private void trocarTela(Class c){
        startActivity(new Intent(SetTimeActivity.this,c));
    }

}
