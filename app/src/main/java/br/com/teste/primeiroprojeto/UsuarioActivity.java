package br.com.teste.primeiroprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UsuarioActivity extends AppCompatActivity {

    private TextView usuario;
    private Button botaoLista;
    private Button botaoEscolha;
    private Button botaoGato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        usuario = findViewById(R.id.usuario);
        Bundle extra = getIntent().getExtras();
        String nome = extra.getString("nome");

        usuario.setText("Bem vindo "+nome);


        botaoLista = findViewById(R.id.listaId);
        botaoEscolha = findViewById(R.id.escolhaId);
        botaoGato = findViewById(R.id.gatoId);

        botaoLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsuarioActivity.this, ListaActivity.class));
            }
        });

        botaoEscolha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsuarioActivity.this, EscolhaActivity.class));
            }
        });

        botaoGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsuarioActivity.this, SomGatoActivity.class));
            }
        });

    }
}
