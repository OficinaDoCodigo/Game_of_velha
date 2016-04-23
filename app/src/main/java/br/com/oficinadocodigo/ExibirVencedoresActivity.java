package br.com.oficinadocodigo;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.com.oficinadocodigo.aux.TempGameData;

/**
 * Created by caioalves on 22/04/16.
 */
public class ExibirVencedoresActivity extends Activity implements View.OnClickListener{

    private Button btn_menu;
    private Button btn_jogar_novamente;
    private TextView txt_vencedor;
    private ImageView icon_vencedor;
    private TextView txt_saudacao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exibir_vencedores);

        btn_menu = (Button) findViewById(R.id.btn_menu);
        btn_jogar_novamente = (Button) findViewById(R.id.btn_jogar_novamente);

        txt_saudacao = (TextView) findViewById(R.id.txt_saudacao);
        txt_vencedor = (TextView) findViewById(R.id.txt_nome_vencedor);

        if(TempGameData.RESULT != 0){
            txt_saudacao.setText("Parabéns");
            txt_vencedor.setText(TempGameData.PLAYER_WIN);
        }else{
            txt_saudacao.setText(" ");
            txt_vencedor.setText("EMPATE");
        }

        btn_jogar_novamente.setOnClickListener(this);
        btn_menu.setOnClickListener(this);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.6));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_menu:
                trocarTela(MenuActivity.class);
                break;

            case R.id.btn_jogar_novamente:
                trocarTela(SetTimeActivity.class);
        }
    }

    private void trocarTela(Class next){
        startActivity(new Intent(this,next));
        ExibirVencedoresActivity.this.finish();
    }

}
