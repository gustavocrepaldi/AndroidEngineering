package com.example.gustavocrepaldi.AndroidEngineering._06BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiverANR extends BroadcastReceiver{
    private static final String CATEGORIA = "BROADCASTRECEIVER";
    //Como ver esse erro. Não entendi muito bem! Existe uma forma de logar e ver o que está ocorrendo?

    @Override
    public void onReceive(Context c, Intent intent){
      try{
          Log.i(CATEGORIA,"Teste ANR sleep ...");
          Thread.sleep(15000);
      } catch (InterruptedException e){
          e.printStackTrace();
      }
    }
}

/*  CICLO DE VIDA - ANR [APPLICATION NOT RESPONDING]
 *
 *  Um BroadcastReceiver é válido somente durante a chamada ao método onReceive(). Depois disso, o
 *  SO encerrará seu processo para liberar memória. O código do método onReceive() deve executar
 *  brevemente e assim que o método terminar, o Android vai considerar que o BroadcastReceiver não
 *  está mais ativo e pronto para ser destruído.
 *
 *  Esse método deve consumir rapidamente a intent (mensagem) recebida e retornar rapidamente. Caso
 *  demore mais de 10 SEGUNDOS para executar, o Android exibirá um erro chamado ANR [APPLICATION
 *  NOT RESPONDING] que nada mais é do que um TIMEOUT.
 *
 *  Outra forma de o erro ANR acontecer é quando a activity atual não consegue responder a um evento
 *  de entrada (tecla pressionada, por exemplo) em 5 segundos;
 *
 *  O problema desse timeout é que esses 10 segundos são fáceis de serem extrapolados. Image que vo
 *  cê precise executar algum sincronismo pela internet em segundo plano. Dependendo da velocidade
 *  da conexão e da quantidade de dados a serem tafegados, isso pode demorar mais do que 10 segundos.
 *
 *
 *
 *  Solução para ANR: Criar uma thread? Com a classe BroadcastReceiver há um problema.
 *
 *  O método onReceive() tem 10 segundos de limiete para executar. Ao abrir uma thread e demorar,
 *  por exemplo, 1 minuto para retornar o método onReceive() vai terminar sua execução já que a exe
 *  cução da thread é assíncrona e independente do método onReceive(). Como a classe BroadcastRecei
 *  ver é válido somente durante a chamada ao método onReceive(), o SO encerrará seu processo para
 *  liberar memória.
 *
 *  Dessa forma, o método onReceive() está finalizado mas thread ainda está executando. O que irá
 *  acontecer com a thread? É provável que o sistema operacional encerre seu processo porque esta
 *  thread não faz parte de nenhum ciclo de vida que o Android conheça. O resultado disso tudo é
 *  que sua thread tem grandes chances de ser encerrada e tod o processamento e sincronismo sem efei
 *  to algum.
 *
 *  Assim, se for necessário executar algum processamento pesado em segundo plano não é recomendado
 *  usar uma nova thread pois o Android não a conhece e irá encerrar seu processo caso precise libe
 *  rar memória para outros recursos.
 *
 *  Para resolver esse problema foi criada a classe android.app.Service uqe pode executar processos
 *  assíncronos em segundo plano por tempo indeterminado. Conhecido como executar um serviço em se
 *  gundo plano. A classe android.app.Service faz parte do ciclo de vida do Android e seu processo
 *  pode ficar executando durante toda a aplicação. O Android encerrará esse serviço apenas se a me
 *  mória estiver extremamente baixa e seja necessário encerrar determinados processos para liberar
 *  memória. Mesmo se isso acontecer, posteriormente o Android pode, inclusive, reiniciar o serviço
 *  para continuar o que ele estava fazendo.
 *
 */