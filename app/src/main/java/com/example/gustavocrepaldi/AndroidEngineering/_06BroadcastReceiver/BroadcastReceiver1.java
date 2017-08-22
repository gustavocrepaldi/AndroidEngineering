package com.example.gustavocrepaldi.AndroidEngineering._06BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context c, Intent i){
        Toast.makeText(c, "BroadcastReceiver1 - Configuração Estática", Toast.LENGTH_SHORT).show();
    }

}

   /*
    * Quando alguma intent/mensagem com a ação ABRIR_RECEIVER_1 for disparada, a classe Broadcast
    * Receiver1 será executada em segundo plano sem interferir na tela que o usuário está trabalhan
    * do.
    *
    * IMPORTANTE: O método chamado é o onReceive(context, intent) que recebe como parâmetro a mesma
    * intent que foi utilizada para enviar a mensagem.
    *
    */
