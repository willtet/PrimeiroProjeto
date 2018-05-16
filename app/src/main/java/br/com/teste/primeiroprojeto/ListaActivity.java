package br.com.teste.primeiroprojeto;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.*;

public class ListaActivity extends AppCompatActivity {

    private ListView lista;
    private ArrayList<String> listaCrua;
    private Button botaoCriar;
    private Switch apagar;
    private AlertDialog.Builder alerta;
    private ArrayAdapter<String> listaModificada;

    private void coletorDeLista(final ArrayList<String> listas){
        if (!listas.isEmpty()) {
            lista = findViewById(R.id.tabelaId);

            atualizarTela(listas);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int posicao = position;
                    String valorClicado = lista.getItemAtPosition(posicao).toString();
                    Toast.makeText(getApplicationContext(),valorClicado,Toast.LENGTH_SHORT).show();
                }
            });
        }
            botaoCriar = findViewById(R.id.criarListaId);
            botaoCriar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intente = new Intent(ListaActivity.this, CriarListaActivity.class);
                    intente.putStringArrayListExtra("mandarLista", listas);
                    startActivity(intente);
                }
            });

    }

    private void atualizarTela(final ArrayList<String> listaAAtualizar){
        listaModificada = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaAAtualizar //Lista de Array
        );
        listaModificada.notifyDataSetChanged();
        lista.setAdapter(listaModificada);
    }


    private void apagarComAlerta(){
        apagar = findViewById(R.id.apagarId);
        apagar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                            alerta = new AlertDialog.Builder(ListaActivity.this);
                            alerta.setTitle("Apagar item da Lista");
                            alerta.setMessage("Deseja realmente deletar o texto?");
                            alerta.setCancelable(false);
                            alerta.setIcon(android.R.drawable.ic_delete);
                            alerta.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(),"Texto inalterado",Toast.LENGTH_SHORT).show();
                                }
                            });
                            alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    listaCrua.remove(position);
                                    atualizarTela(listaCrua);
                                    Toast.makeText(getApplicationContext(),"Texto apagado",Toast.LENGTH_SHORT).show();
                                }
                            });

                            alerta.create();
                            alerta.show();
                        }
                    });

                }
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lista = findViewById(R.id.tabelaId);
        Bundle listaExtra = getIntent().getExtras();

        if (listaExtra == null){
            listaCrua = new ArrayList<String>();
            coletorDeLista(listaCrua);
        }else{
            Intent i = getIntent();
            listaCrua = i.getStringArrayListExtra("retornoLista");
            String is = listaCrua.get(0).toString();
            coletorDeLista(listaCrua);
        }

        apagarComAlerta();
    }
}

