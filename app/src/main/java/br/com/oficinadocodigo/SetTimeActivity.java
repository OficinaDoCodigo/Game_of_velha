package br.com.oficinadocodigo;

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

public class SetTimeActivity extends ActionBarActivity {

    private int tempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);
        this.getSupportActionBar().hide();
    }

}
