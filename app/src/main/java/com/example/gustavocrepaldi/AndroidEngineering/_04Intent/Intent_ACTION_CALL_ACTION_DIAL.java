package com.example.gustavocrepaldi.AndroidEngineering._04Intent;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gustavocrepaldi.AndroidEngineering.R;

public class Intent_ACTION_CALL_ACTION_DIAL extends Activity {

    @Override
    public void onCreate(Bundle icicle) {

        super.onCreate(icicle);
        setContentView(R.layout.intent_form_telefone);

        final Button button = (Button) findViewById(R.id.botaoOk);
        button.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                EditText campoTelefone = (EditText) findViewById(R.id.campoTelefone);
                                String telefone = campoTelefone.getText().toString();

                                //URI do número do telefone
                                Uri uri = Uri.parse("tel:" + telefone);

                                /**
                                 * Precisa de permissão: <uses-permission android:name="android.permission.CALL_PHONE"/>
                                 * A partir da API 23 a solicitação de permissão é em tempo de execução
                                 * No AndroidManifest o uses-permission deve estar como parte da implementação do sistema
                                 * O que muda é que na instalação não é solicitado a autorização de todas as permissões
                                 * A solicitação acontece em tempo de execução e sob demanda
                                 */
                                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                                //Intent intent = new Intent(Intent.ACTION_DIAL,uri);

                                //SOLICITAÇÃO DE PERMISSÃO EM TEMPO DE EXECUÇÃO PARA VERSÕES API <= 23
                                if (ContextCompat.checkSelfPermission(Intent_ACTION_CALL_ACTION_DIAL.this, Manifest.permission.CALL_PHONE)
                                        != PackageManager.PERMISSION_GRANTED) {

                                    ActivityCompat.requestPermissions(Intent_ACTION_CALL_ACTION_DIAL.this,
                                            new String[]{Manifest.permission.CALL_PHONE},
                                            111);

                                } else {

                                    //Envia a mensagem ao sistema operacional
                                    startActivity(intent);
                                }
                            }
        });
    }


    /*
     * CallBack após a verificação de solicitação de permissão em tempo de execução
     * https://developer.android.com/training/permissions/requesting.html?hl=pt-br
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 111: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}

/*
 *  Intent.ACTION_CALL
 *
 *  Ao desenvolver uma app, talvez seja preciso automatizar a ligação para determinado número de te
 *  lefone. Para isso, basta crair uma mensagem com a ação Intent.ACTION_CALL e informar o número do
 *  telefone desejado. Uma ação parecida com o ACTION_CALL é a ACTION_DIAL que apenas disca o número
 *  desejado mas espera a confirmação do usuário para efetuar a ligação
 *
 *
 */