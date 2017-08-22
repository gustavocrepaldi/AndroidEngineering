package com.example.gustavocrepaldi.AndroidEngineering._06BroadcastReceiver;


import android.app.ListActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuBroadcastReceiver extends ListActivity {


    protected static final String TAG = "BroadcastReceiverLog";

    private static final String[] nomes = new String[] {
            "Exemplo 1",
            "Exemplo 2",
            "Exemplo 3 Erro ANR",
            "Exemplo 4 - iniciar activity",
            "Exemplo 5 - Integrar outra aplicação ... ABRIR_APLICACAO_TESTE",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nomes));

        //Registrado dinâmicamente por API JAVA
        //registerReceiver(new BroadcastReceiver2(), new IntentFilter("ABRIR_RECEIVER_2"));

        //Note que no exemplo de IntentFilter a ação e categoria era configuração em cima de
        //um objeto Intent. Como o parâmetro do registerReceiver esperar um IntentFilter e não
        //um objeto Intent, deve-se configurar a ação e categoria por meio do objeto IntentFilter
        IntentFilter intentFilter = new IntentFilter("ABRIR_RECEIVER_2");
        intentFilter.addCategory("CATEGORY_RECEIVER_2");
        registerReceiver(new BroadcastReceiver2(), intentFilter);
        //O receiver BroadcastReceiver2 já estava declarado como receiver no arquivo AndroidManifest.xml
        /*
         * Registrar o receiver dinamicamente deve ser utilizado quando é necessário que o receiver
         * esteja apto a executar somente quando determinada tela da aplicação estiver executando,
         * caso contrário, não. Já se o receiver for definido de forma estática no arquivo AndroidManifest.xml
         * ele pode executar a qualquer momento que receber uma mensagem (intent) mesmo que a aplicação não
         * esteja executando. Ele pode ser até configurado como o ponto de partida da aplicação, para exe
         * cutá-la assim que receber determinados eventos/estímulos.
         */
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                //Chamar o BroadcastReceiver1
                sendBroadcast(new Intent("ABRIR_RECEIVER_1"));
                break;
            case 1:
                //Chamar o BroadcastReceiver2 com configuração de categoria
                //Envia broadcastreceiver através do registro dinâmico do receiver
                Intent intent = new Intent("ABRIR_RECEIVER_2");
                intent.addCategory("CATEGORY_RECEIVER_2");
                sendBroadcast(intent);
                //sendBroadcast(new Intent("ABRIR_RECEIVER_2"));
                break;
            case 2:
                //Chamar o BroadcastReceiverANR
                sendBroadcast(new Intent("TESTE_ANR"));
                break;
            case 3:
                //Chamar o BroadcastReceiver e abrir a activity TelaTeste
                sendBroadcast(new Intent("ABRIR_ACTIVITY_TESTE"));
                break;
            case 4:
                //Acionando uma outra classe de outro projeto por BroadcastReceiver
                /*
                 * Estranho que no projeto de teste de integração com broadcastReceiver foi necessário
                 * criar uma activity main e launcher para instalar a app. Caso fizesse o manifest apenas
                 * com o receiver não dava para dar play e instalar a aplicação pq dizia não ter uma
                 * default activity para executar? Mas o projeto era para ser apenas um receiver!
                 * Tentar entender isso melhor!
                 */
                sendBroadcast(new Intent("ABRIR_APLICACAO_TESTE_BROADCAST"));
                break;
            default:
                finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Remove o BroadcastReceiver
        //Como o BroadcastReceiver foi registrado dinâmicamente pela API Java é necessário chamar
        //o método abaixo informando uma instância da mesma classe utilizada para registrar.
        //Isso pode ser feito no método onDestroy() através do método unregisterReceiver()
        try  {
            unregisterReceiver(new BroadcastReceiver2());
        }
        catch (IllegalArgumentException e) {
            }
    }

}

    /*
    * BROADCASTRECEIVER
    *
    * Classe utilizada para que aplicações reagem a determinados eventos gerados por uma intent.
    *
    * A classe broadcastreceiver sempre é executada em segundo plano durante pouco tempo e sem uti
    * lizar uma interface gráfica. Seu objetivo é receber uma mensagem (intent) e processá-la sem
    * que o usuário perceba. Isso é um passo importante para integrar aplicaçõe uma vez que elas
    * podem trocar mensagens em segundo plano sem atrapalhar o usuário.
    *
    * A classe android.content.BroadcastReceiver é utilizada para responder a determinados eventos
    * enviados por uma intent, como executar determinada aplicação ao receber uma mensagem SMS,
    * uma ligação telefônica ou qualquer outra ação customizada da aplicação. Um BroadcastReceiver
    * não utiliza interface gráfica e não se comunica diretamente com o usuário, pelo contrário,
    * ele é excutado em segundo plano sem que o usuário perceba. Para configurar a classe Broadcast
    * Receiver é utilizada a tag <receiver> no arquivo AndroidManifest.xml em conjunto com a tag
    * <intent-filter> para definir a ação e categoria.
    *
    * Observe que a configuração realizada no arquivo AndroidManifest.xml é exatamente a mesma para
    * a tag <activity> e <receiver> (Que é o identificador do BroadcastReceiver) sendo que ambas de
    * claram o nome de uma classe e o <intent-filter> que tem a ação e categoria para a qual a clas
    * se deve executar.
    *
    * Diferentemente da classe Activity, que tem por objetivo exibir uma tela para o usuário utili
    * zando uma View, a classe BroadcastReceiver é utilizada para justamente executar algum proces
    * samento sem que o usuário perceba e em segundo plano.
    *
    * Portanto, é recomendado que durante a execução do BroadcastReceiver não seja exibido nenhum
    * alerta na tela para não atrapalhar o usuário ou abrir uma tela automaticamente sem a permissão.
    *
    *
    *
    * ARQUITETURA INTENT  E INTENTFILTER --> Activity e BroadcastReceiver:
    *
    *   Intent representa uma mensagem com a intenção de realizar algo e o Intentfilter é o que
    *   filtra essa mensagem por ação e categoria. Esse filtro da classe IntentFilter pode estar
    *   configurado para executar uma Activity <activity> ou um BroadcastReceiver <receiver>.
    *
    *
    *
    * ENVIO DE MENSAGEM BROADCAST COM O MÉTODO sendBroadcast(intent)
    *
    *   Existe alguma diferença entre uma Intent que abre uma tela/activity e uma Intent que será
    *   interceptada por um BroadcastReceiver? Sim, mas pouca coisa.
    *
    *       startActivity(intent) --> Intent contém info necessárias para abrir tela.
    *                                 Mensagem enviada para o SO para todas as apps;
    *                                 Projeto IntentFilterIntegracao tem um exemplo de configuração
    *                                 de ação e categoria para inicar uma app a partir de outra;
    *
    *       sendBroadcast(intent) --> Intent tem informações de filtro e é enviada ao SO para todas apps;
    *
    *   Para abrir uma nova tela da aplicação podemos usar o método startActivity(intent) informando
    *   a intent que tem as informações necessárias para abrir a tela. No caso do BroadcastReceiver,
    *   o método utilizado é o sendBroadcast(intent) que dispara uma mensagem para todas as aplicações
    *   instaladas no celular. A palavra "broadcast" é um termo comum para uma mensagem que é enviada
    *   para tod mundo ao mesmo tempo.
    *
    *   Importante entender que a intent criada para executar um BroadcastReceiver utilizando o méto
    *   do sendBroadcast() é diferente de uma intent utilizada para inciar uma activity por meio do
    *   método startActivity(). Portanto, não é possível que um BroadcastReceiver receba uma intent
    *   disparado para iniciar uma activity e vice-versa.
    *
    *   IMPORTANTE: ----> Quando o método sendBroadcast(intent) é chamado, não necessáriamente um
    *   BroadcastReceiver cadastrado em sua própria aplicação será executado. Uma intent é uma mensa
    *   gem enviada ao sistema operacional do Android e todas as apps instaladas estão aptas a rece
    *   be-las.
    *
    *  É recomendado que, se um BroadcastReceiver precise executar uma tarefa longa, a classe Service
    *  seja utilizada. No caso de o BroadcastReceiver abrir uma nova thread, o Android pode encerrar
    *  aquele processo e informações importantes podem ficar perdidas. --> Ver BroadcastReceiverANR.
    *
    *
    *
    */