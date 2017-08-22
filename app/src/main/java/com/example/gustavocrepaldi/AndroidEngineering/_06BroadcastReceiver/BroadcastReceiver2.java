package com.example.gustavocrepaldi.AndroidEngineering._06BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context c, Intent i) {
        Toast.makeText(c, "BroadcastReceiver2 - Configuração Dinâmica com Ação e Categoria",
                Toast.LENGTH_SHORT).show();
    }

}
