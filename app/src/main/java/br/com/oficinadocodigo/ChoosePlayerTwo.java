package br.com.oficinadocodigo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

import br.com.oficinadocodigo.aux.TempGameData;


public class ChoosePlayerTwo extends ActionBarActivity implements View.OnClickListener{

    private Spinner spinner_player_menu;
    private Button btn_novo;
    private TextView txt_apelidio_escolherPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_player_two);
        this.getSupportActionBar().hide();

        spinner_player_menu = (Spinner) findViewById(R.id.spinner_players_menu);
        btn_novo = (Button) findViewById(R.id.btn_novo_escolherPlayer);
        txt_apelidio_escolherPlayer = (TextView) findViewById(R.id.txt_apelidio_escolherPlayer);

        fillSpinner();

        btn_novo.setOnClickListener(this);

        spinner_player_menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nome = parent.getItemAtPosition(position).toString();
                if(!nome.equals("selecione aqui...")){
                    TempGameData.PLAYER_TWO = nome;
                    txt_apelidio_escolherPlayer.setText(nome);
                    btn_novo.setText("PRÓXIMO");
                }else{
                    txt_apelidio_escolherPlayer.setText("Nome do jogador");
                    btn_novo.setText("NÃO SOU CADASTRADO");
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_novo_escolherPlayer:
                if (btn_novo.getText().toString().equals("PRÓXIMO")) {
                    trocarTela(SetTimeActivity.class);
                }
                else{
                    trocarTela(CadastreAvatarActivity.class);
                }
                break;
        }
    }


    private void fillSpinner() {
        String array[] = {" ","Henry","Kaio","Fabiano","Axl"};
        Arrays.sort(array);
        array[0] = "selecione aqui...";
        ArrayAdapter<String> users = new ArrayAdapter<String>(this,R.layout.spinner_layout_model,array);
        spinner_player_menu.setAdapter(users);
    }


    private void trocarTela(Class next){
        startActivity(new Intent(this,next));
    }


}
