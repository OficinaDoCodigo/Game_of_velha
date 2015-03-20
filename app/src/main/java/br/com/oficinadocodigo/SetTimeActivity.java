package br.com.oficinadocodigo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;

import br.com.oficinadocodigo.R;
import br.com.oficinadocodigo.aux.Message;
import br.com.oficinadocodigo.aux.TempGameData;

public class SetTimeActivity extends ActionBarActivity {

    private Spinner spinnerSetTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);
        this.getSupportActionBar().hide();


        spinnerSetTime = (Spinner) findViewById(R.id.spinner_timer_setTime);

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

}
