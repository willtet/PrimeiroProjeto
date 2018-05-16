package br.com.teste.primeiroprojeto;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SomGatoActivity extends Activity implements View.OnClickListener {

    private ImageView malia, mitsu, taki;
    private MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_som_gato);

        malia = findViewById(R.id.malialuisa);
        mitsu = findViewById(R.id.mitsuha);
        taki = findViewById(R.id.taki);

        malia.setOnClickListener(this);
        mitsu.setOnClickListener(this);
        taki.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.malialuisa:
                media = MediaPlayer.create(SomGatoActivity.this, R.raw.malia);
                tocar();
                break;

            case R.id.mitsuha:
                media = MediaPlayer.create(SomGatoActivity.this,R.raw.mitsuha);
                tocar();
                break;

            case R.id.taki:
                media = MediaPlayer.create(SomGatoActivity.this,R.raw.mitsuha);
                tocar();
                break;
        }
    }

    public void tocar(){
        if(media!=null){
            media.start();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(media!=null){
            media.release();
            media.stop();
        }
    }
}
