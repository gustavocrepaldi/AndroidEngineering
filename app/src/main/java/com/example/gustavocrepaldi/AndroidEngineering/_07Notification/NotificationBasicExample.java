package com.example.gustavocrepaldi.AndroidEngineering._07Notification;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.View;
import android.widget.Button;

import com.example.gustavocrepaldi.AndroidEngineering.R;

public class NotificationBasicExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_main);

        Button btLogin = (Button) findViewById(R.id.btNotification);
        btLogin.setOnClickListener(onClickLogin());
    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NotificationBasicExample.this, NotificationStartNotification.class);

                //Criação da PendinIntent que contém a intent original
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(NotificationBasicExample.this);
                //Esta linha mantém a activity pai na pilha de activities
                stackBuilder.addParentStack(intent.getComponent());
                //Configura a intent que vai abrir ao clicar na notificação
                stackBuilder.addNextIntent(intent);
                //Cria a PendingIntent e atualiza caso exista uma com o mesmo id
                PendingIntent pendingIntent = stackBuilder.getPendingIntent(11, PendingIntent.FLAG_UPDATE_CURRENT);

                //Criação da notificação
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationBasicExample.this);

                //Ativa configurações Padrões
                //Configura um som padrão, vibração e acende luzes.
                //A constante Default_All aplica Default_Sound,Default_Vibrate e Default_Lights
                builder.setDefaults(Notification.DEFAULT_ALL);
                //Ícone da notificação
                builder.setSmallIcon(R.drawable.feliz);
                //Título da Notificação
                builder.setContentTitle("AndroidEngineering Notification");
                //Mensagem da notificação
                builder.setContentText("You have a new message");
                //Intent que será chamada ao clicar nela
                builder.setContentIntent(pendingIntent);
                //Noticicação é cancelada ao clicar nela
                builder.setAutoCancel(false);


                builder.setTicker("Esse cara eu não sei do que se trata");
                builder.setSubText("SubTexto mostrado ao lado do ícone");

                NotificationManagerCompat manager = NotificationManagerCompat.from(NotificationBasicExample.this);
                manager.notify(11, builder.build());
            }
        };
    }


}

    /*
    * NOTIFICATION - Notification.Builder
    *
    * A classe Notification.Builder contém vários métodos utilitários para configurar um objeto do
    * tipo Notification e segue o famoso padrões de design Builder do Gof (Gang of Four):
    *
    *   http://pt.wikipedia.org/wiki/Builder
    *   http://pt.wikipedia.org/wiki/Design_Patterns
    *
    * Como nem todas as funcionalidades das notificações existem em todas as versões do Android foi
    * criada uma classe de compatibilidade NotificationCompat.Builder que tem como objetivo esconder
    * essa complexidade do desenvolvedor. Ao utilizar a classe de compatibilidade, as novas funciona
    * lidades serão habiliradas se possível, ou serão ignoradas, tudo de forma transparente.
    *
    * Neste exemplo, basiacamente estamos usando a classe NotificationCompat.Builder para criar a
    * notificação com os parâmetros informados. Notte que alguns parâmetros estão fixos. O ponto
    * mais importante do código é criar o INTENT e o PENDINGINTENT que será disparada ao clicar na
    * notificação. A PENDINGINTENT é um tipo especial de intent que encapsula uma intent real a fim
    * de ser disparada ao clicar na notificação.
    *
    * Essa primeira notificação é a mais simples e pode ser utilizada em todas as versões do Android
    * pois mostra apenas um ícone, título e mensagem. O interessante da notificação é que elas podem
    * executar mesmo com o aplicativo fechado.
    *
    */
