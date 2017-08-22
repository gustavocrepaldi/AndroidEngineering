package com.example.gustavocrepaldi.AndroidEngineering._06BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadcastReceiver3 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        //INICIALIZAÇÃO DE UMA ACITIVITY QUE FAZ PARTE DA APLICAÇÃO
        //Intent i = new Intent(context, BroadcastReceiverActivity.class);
        //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //context.startActivity(i);

        /*
         *  Se quisesse abrir uma activty de outra app?
         *
         *  Teria que ser por AÇÃO e CATEGORIA pois passando explicitamente o nome da classe
         *  esse projeto específico não conheceria uma classe de outra aplicação. Segue exemplo
         *  abaixo ou é necessário configurar a ação e categoria usando o contexto para usar o
         *  método startActivity()
         *
         */

        //INICIANDO UMA NOVA APP A PARTIR DE UM BROADCASTRECEIVER
        Intent i = new Intent("android.intent.action.MAIN");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addCategory("intentFilterIntegracao");
        context.startActivity(i);

    }
}

/*
 *  ABERTURA DE UMA TELA/ACTIVITY A PARTIR DE UM BROADCASTRECEIVER
 *
 *  Lembre-se de que um receiver é executado em segundo plano sem atrapalhar o usuário e esse é o
 *  seu sentido. Caso seja necessário abrir uma tela da aplicação a partir de um BroadcastReceiver,
 *  embora não recomendado, isso também pode ser realizado. Para isso deve-se utilizar o método
 *  startActivity(intent) normalmente mas antes é necessário configurar a flag Intent.NEW_TASK_LAUNCH.
 *
 *  Chamar uma actiivty de dentro de um BroadcastRecevier não é recomendado pelo Android, porque isso
 *  pode interromper a tarefa que o usuário está realizando. A forma correta de se alertar o usuário
 *  dentro de um BroadcastReceiver é usando uma notificação que é um alerta exibido para o usuário
 *  que fica na barra de status do celular.
 *
 *  Então, se não é recomendado usar activity/toast dentro do BroadcastReceiver qual é a maneira
 *  mais indicada de uma aplicação que está executando em segundo plano interagir com o usuário?
 *  A resposta é por meio de uma notificação. Uma notificação é um tipo de alerta especial que fica
 *  na barra de status do Android e que chama a atenção do usuáro.
 *
 *
 */
