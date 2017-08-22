package com.example.gustavocrepaldi.AndroidEngineering._06BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiverBoot extends BroadcastReceiver{
    private static final String CATEGORIA = "BroadcastReceiverBoot";

    @Override
    public void onReceive(Context context, Intent intent){

        //Requer o uso de permissão
        //<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

        System.out.println("Boot completo com sucesso. Interceptação de " +
                "mensagem por BroadcastReceiver");
        Log.i(CATEGORIA,
                "O Boot do Sistema Operacional foi finalizado com sucesso");
    }

}

/*
 *  Execução de um BroadcastReceiver ao inicializar o Sistema Operacional
 *
 *  Quando o SO termina a inicialização, o Android faz um sendBroadcast(intent) com a ação android.
 *  intent.action.BOOT_COMPLETED para informar todas as aplicações que o boot terminou. Essa mensa
 *  gem global, chamada de 'broadcast' é enviada a todas as aplicações que estão instaladas. Nesse
 *  caso, é possível interceptar a mensagem e iniciar um BroadcastReceiver automaticamente logo
 *  depois que o sistema operacional termine sua inicialização (boot).
 *
 *  Este tipo de recurso é extremamente útil quando você precisa que uma aplicação seja executada
 *  sempre. Assim, quando o usuário ligar o celular você já pode executar sua aplicação por meio
 *  de um BroadcastReceiver. Se preferir, pode manter uma aplicação executando por um longo período
 *  de tempo com um Service ou agendar uma aplicação para executar em uma determinada data e hora,
 *  utilizando o sistema de alarmes. Com o Android é possóvel configurar facilmente uma aplicação
 *  para ser executada a cada 30 minutos, por exemplo.
 *
 *  Poderia configurar para inicializar uma activity dessa mesma app ou uma app externa configurando
 *  a ação e categoria como mostra o exemplo da classe BroadcastReceiver3.java mas foge um pouco do
 *  propósito já que o receiver é para executar algo em segundo plano e de forma rápida. Se fosse
 *  para inicializar algo após o BOOT poderia configurar como <activity> no boot mesmo e com a ação
 *  de android.intent.action.BOOT_COMPLETED.
 *
 */
