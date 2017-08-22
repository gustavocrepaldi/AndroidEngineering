package com.example.gustavocrepaldi.AndroidEngineering._05IntentFilter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class IntentFilterTela4 extends Activity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //Activity chamada pela category "CATEGORIA_DUPLICADA" e action "ABRIR_TELA"
        TextView text = new TextView(this);
        text.setText("Esta é a tela 4");
        setContentView(text);
    }

}
