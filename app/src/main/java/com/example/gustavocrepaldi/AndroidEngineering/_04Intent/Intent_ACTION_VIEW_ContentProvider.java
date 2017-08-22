package com.example.gustavocrepaldi.AndroidEngineering._04Intent;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gustavocrepaldi.AndroidEngineering.R;


public class Intent_ACTION_VIEW_ContentProvider extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.intent_visualizar_id1);

        final Button button = (Button) findViewById(R.id.btVisualizarId1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("content://com.android.contacts/contacts/1");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //envia a mensagem ao sistema operacional
                startActivity(intent);
            }
        });
    }

}

/*
 *  Intent.ACTION_VIEW com uri content provider
 *
 * A notação content://... é de um provedor de conteúdo o qual será explicado em capítulos posterio
 * res. A mesma anotação pode ser utilizada para tudo. Por exemplo, se em uma aplicação fosse criado
 * um banco de dados para salvar informações sobre carros, um provedor de conteúdo poderia ser cria
 * do para visualizar um carro da mesma forma, por exemplo, utilizando uma uri no formato content://
 *
 */