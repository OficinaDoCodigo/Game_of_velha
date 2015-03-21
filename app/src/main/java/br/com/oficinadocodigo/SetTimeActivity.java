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

import java.util.Arrays;

import br.com.oficinadocodigo.R;
import br.com.oficinadocodigo.aux.Message;
import br.com.oficinadocodigo.aux.TempGameData;

public class SetTimeActivity extends ActionBarActivity implements View.OnClickListener {

    private Button btn_save_adjust;
    private RadioGroup  rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);
        this.getSupportActionBar().hide();

        btn_save_adjust = (Button) findViewById(R.id.btn_save_adjust);
        rg              = (RadioGroup) findViewById(R.id.rg);

        btn_save_adjust.setOnClickListener(this);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id  = rg.getCheckedRadioButtonId();

                if(id == R.id.rb1){
                    TempGameData.TIME = 60;
                }
                if(id == R.id.rb2){
                    TempGameData.TIME = 30;
                }
                if(id == R.id.rb3){
                    TempGameData.TIME = 15;
                }
                if(id == R.id.rb4){
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



    private void trocarTela(Class c){
        startActivity(new Intent(SetTimeActivity.this,c));
    }

}
