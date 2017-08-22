package com.example.gustavocrepaldi.AndroidEngineering._05IntentFilter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class IntentFilterTela1 extends Activity {

    @Override
    protected void onCreate(Bundle icicle) {

        super.onCreate(icicle);

        //Activity chamada pela action "ACAO_TESTE"
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            String msg = extras.getString("mensagem");
            TextView text = new TextView(this);
            text.setText("Esta é a tela 1\nMensagem: " + msg);
            setContentView(text);
        } else {

            TextView text = new TextView(this);
            text.setText("Esta é a tela 1");
            setContentView(text);
        }
    }

}
