package com.example.gustavocrepaldi.AndroidEngineering._05IntentFilter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class IntentFilterTela2 extends Activity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        //Activity chamada pela category "CATEGORIA_TESTE" e action "ACAO_TESTE"
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String msg = extras.getString("mensagem");

            TextView text = new TextView(this);
            text.setText("Esta é a tela 2\nMensagem: " + msg);
            setContentView(text);
        } else {

            TextView text = new TextView(this);
            text.setText("Esta é a tela 2");
            setContentView(text);
        }
    }
}
