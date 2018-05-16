package br.com.teste.primeiroprojeto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    private Button entrarConta;
    private EditText usuario;
    private EditText senha;
    private TextView texto;
    private CheckBox boxManterConectado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrarConta = findViewById(R.id.entrar);
        usuario = findViewById(R.id.login);
        senha = findViewById(R.id.password);
        /*
        boxManterConectado = findViewById(R.id.checkBoxConectar);


        if (boxManterConectado.isChecked()) {
            boxManterConectado.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    TextView box = findViewById(R.id.checkBoxConectar);
                    box.setText("Conectado");
                }
            });
        }
        */

        entrarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuario.getText().toString();
                String pass = senha.getText().toString();

                if (user.equals("admin") && pass.equals("123")){
                    Intent intent = new Intent(MainActivity.this, UsuarioActivity.class);
                    intent.putExtra("nome",user);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario inexistente",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
