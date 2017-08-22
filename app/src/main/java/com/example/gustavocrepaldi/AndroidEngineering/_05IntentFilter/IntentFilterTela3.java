package com.example.gustavocrepaldi.AndroidEngineering._05IntentFilter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class IntentFilterTela3 extends Activity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //Activity chamada pela category "CATEGORIA_3" e action "ABRIR_ACTIVITY"
        TextView text = new TextView(this);
        text.setText("Esta é a tela 3");
        setContentView(text);
    }

}
