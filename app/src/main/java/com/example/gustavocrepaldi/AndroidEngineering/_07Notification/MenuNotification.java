package com.example.gustavocrepaldi.AndroidEngineering._07Notification;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MenuNotification extends ListActivity {

    protected static final String TAG = "BroadcastReceiverLog";

    private static final String[] nomes = new String[]{
            "Exemplo 1 Notification - Simple Notification"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                //Exemplo básico de Notification
                startActivity(new Intent(this, NotificationBasicExample.class));
                break;
            default:
                finish();
        }
    }
}

    /*
    * NOTIFICATION
    *
    * Uma notificação é uma mensagem especial que aparece na barra de status do Android para chamar
    * a atenção do usuário. Ao receber a notificação o usuario pode decidir visualizar seu conteúdo
    * ou simplesmente ignorar a mensagem. Quando o usuário clicar na notificação, será disparada uma
    * Intent para iniciar uma Activity, Broadcastreceiver ou service. O conteúdo dessa intent, ou
    * seja, os parâmetros é o programador quem decide.
    *
    * Uma aplicação em segundo plano nunca deve exibir um alerta para o usuário, ou pior ainda,
    * abrir uma tela sem a sua permissão. Lembre-se de que o usuário pode estar lendo emails ou estar
    * em uma chamada com telefônica.
    *
    * Um exemplo de notificação seria uma aplicação de chat na qual o usuário pode receber uma noti
    * ficação quando chegar uma nova mensagem. Ao selecionar a notificação, o usuário pode decidir
    * visualizar a mensagem ou não. Outro exemplo, seria um serviço que executa em segundo plano,
    * fazendo alguma atualização de informações. No momento em que a atualização terminar, a aplica
    * ção poderia informar o usuário utilizando uma notificação.
    *
    * A partir do Android 4.1, as notificações podem ser criadas com mais conteúdo, chamadas de
    * BIG VIEW NOTIFICATIONS. Outra melhoria do Android 4.1 foi o suporte às ações diretamente nas
    * notificações, que são botões customizados que aparecem na notificação.
    *
    * Alteração Git
    *
    */
