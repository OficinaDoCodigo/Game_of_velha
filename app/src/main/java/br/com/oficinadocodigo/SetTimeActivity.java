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
import android.widget.Spinner;

import java.util.Arrays;

import br.com.oficinadocodigo.R;
import br.com.oficinadocodigo.aux.Message;
import br.com.oficinadocodigo.aux.TempGameData;

public class SetTimeActivity extends ActionBarActivity implements View.OnClickListener {

    private Spinner spinnerSetTime;
    private Button btn_save_adjust;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);
        this.getSupportActionBar().hide();


        spinnerSetTime = (Spinner) findViewById(R.id.spinner_timer_setTime);
        btn_save_adjust = (Button) findViewById(R.id.btn_save_adjust);

        btn_save_adjust.setOnClickListener(this);

        fillSpinner();



        spinnerSetTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                String vals[] = item.split(" ");
                if(!vals[0].equals("sem")){
                    TempGameData.TIME = Integer.parseInt(vals[0]);
                }else{
                    TempGameData.TIME = 0;
                }
                Message.toast(SetTimeActivity.this,TempGameData.PLAYER_ONE+" vs "+TempGameData.PLAYER_TWO+"\n\nTime: "+TempGameData.TIME);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    private void fillSpinner(){
        String array[] = {"sem tempo...","5 seg","15 seg","30 seg","60 seg"};
        ArrayAdapter<String> users = new ArrayAdapter<String>(this,R.layout.spinner_layout_model,array);
        spinnerSetTime.setAdapter(users);
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
