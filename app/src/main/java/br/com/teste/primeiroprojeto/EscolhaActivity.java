package br.com.teste.primeiroprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EscolhaActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonEscolhido;
    private Button botao;
    private TextView respota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);

        radioGroup = findViewById(R.id.grupo);
        botao = findViewById(R.id.ver);
        respota = findViewById(R.id.resposta);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioEscolhido = radioGroup.getCheckedRadioButtonId();
                radioButtonEscolhido = findViewById(idRadioEscolhido);
                respota.setText("Gosta de "+radioButtonEscolhido.getText());
            }
        });

    }
}
