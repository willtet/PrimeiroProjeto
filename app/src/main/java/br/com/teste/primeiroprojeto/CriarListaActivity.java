package br.com.teste.primeiroprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CriarListaActivity extends AppCompatActivity {

    private EditText titulo;
    private Button botao;
    private ArrayList<String> listas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);

        Bundle extra = getIntent().getExtras();
        ArrayList<String> lista = extra.getStringArrayList("mandarLista");

        titulo = findViewById(R.id.stringTitulo);

        listas = lista;

        botao = findViewById(R.id.enviarTextoId);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringTitulo = titulo.getText().toString();
                listas.add(stringTitulo);

                Intent intente = new Intent(CriarListaActivity.this, ListaActivity.class);
                intente.putStringArrayListExtra("retornoLista", listas);
                startActivity(intente);
            }
        });



    }
}
