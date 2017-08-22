package com.example.gustavocrepaldi.AndroidEngineering._03Activity;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Activity_DebugActivity extends Activity {

    protected static final String TAG = "livro";

    /*
    * 01 - PRIMEIRO MÉTODO A SER CHAMADO ###########################################################
    *
    * Método obrigatório e chamado uma única vez.
    * Nesse método deve-se criar uma view e chamar o método setContentView(view) para exibir na tela
    * Assim que o método onCreate é finalizado é chamado o método onStart() para iniciar
    * Nesse método, quando configura a tela é comum configurar o tratamento de eventos
    * do ciclo visível da activity
    *
    *       - Método obrigatório e chamado apenas uma única vez;
    *       - Criação da View [setContentView()] para exibir interface gráfica;
    *       - Neste método é comum configurar tratamento de eventos;
    *       - Activity não visível para usuário;
    *       - [Resumo: Criação da View]
    *
    */
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Log.i(TAG, getClassName() + ".onCreate() chamado: " + icicle);
    }

    /*
    * 02 - SEGUNDO/SÉTIMO MÉTODO A SER CHAMADO #####################################################
    *
    * Chamado após o onCreate() ou depois do onRestart() dependendo do estado da aplicação
    * O método é chamado quando a activity está se tornando visível ao usuário
    * e já possui uma view configurado pelo método onCreate()
    *
    *       - Chamado após onCreate() ou onRestart();
    *       - Já possui uma view configurado pelo método onCreate();
    *       - É aqui que o App se prepara para que a activity entre em primeiro plano;
    *               - App inicializa o código que mantém a UI;
    *               - Poderia registrar broadcastReceiver que monitoram mudunças refletidas na UI;
    *               - Deveria usar para registrar listeners (GPS) aqui e desregistrar no onStop
    *               - Se registrar no onCreate e desregistrar no onDestroy,
     *              - o GPS funcionará sempre e gastará muita bateria
    *       - Activity que estava em background volta a ter foco -> onRestart();
    *       - Activity está se tornando visível ao usuário [Como se fosse um beforeLoad?];
    *       - [Resumo: View Configurada e se tornando visível]
    *
    *
    * A final, para que ser o onStart()?
    *
    *   - https://developer.android.com/guide/components/activities/activity-lifecycle.html
           *
           * When the activity enters the Started state, the system invokes this callback.
           * The onStart() call makes the activity visible to the user, as the app prepares for
           * the activity to enter the foreground and become interactive. For example, this method
           * is where the app initializes the code that maintains the UI. It might also register a
           * BroadcastReceiver that monitors changes that are reflected in the UI.

           * The onStart() method completes very quickly and, as with the Created state,
           * the activity does not stay resident in the Started state. Once this callback finishes,
           * the activity enters the Resumed state, and the system invokes the onResume() method.
           *
           *
           * How to use onStart() ? For example, you should unregister listeners for GPS, sensors,
           * etc in onStop() and register again in onStart(). If you register it in onCreate() and
           * unregister in onDestroy() than GPS service will work always and it will drain battery.
    *
    */
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getClassName() + ".onStart() chamado.");
    }

    /*
    * 03 - TERCEIRO MÉTODO A SER CHAMADO ###########################################################
    *
    * Método onResume é chamado quando activity já está no Topo da pilha (Activity Stack)
    * Nesse método a activity já está sendo executado como a principal activity
    * Representa o estado em que a activity está executando.
    *
    * Quando o método executar o usuário já estará visualizando a tela. Por isso este método é
    * frequentemente usado para disparar threads que consultam os dados em web services ou banco
    * de dados para atualizar as informações da tela. Porque chamaria um webservice para atualizar
    * a tela em métodos anteriores se ela ainda não está visível?
    *
    *       - Chamado após onStart();
    *       - Activity está no Topo da Pilha [Activity Stack];
    *       - Activity está sendo executada como principal;
    *       - Usuário já estará visualizando a tela quando o método for executado;
    *       - Método utilizados para disparar threads que consultam dados em webService/banco de da
    *       - Dos para atualizar as informações da tela
    *       - [Resumo: Acitivity em processamento/Topo da Pilha]
    *
    */
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getClassName() + ".onResume() chamado.");
    }

    /*
    * 04 - QUARTO MÉTODO A SER CHAMADO #############################################################
    *
    * Caso uma outra activity venha ocupar como activity principal (foreground) o método
    * onPause é chamado para salvar o estado da aplicação para que, posteriormente, quando a
    * activity voltar a executar o estado possa ser recuperado no método onResume()
    *
    * Se algum evento ocorrer, como celular entrar em mode de espera/dormir ou uma Intent
    * estar sendo processada, a activity no topo da pilha pode ser temporariamente interrompida.
    *
    *       - Chamado quando a activity tem que sair de foreground [onResume()] para background;
    *       - Método é chamado para salvar estado da aplicação p/qdo voltar possa ser recuperado;
    *       - [Resumo: Acitivity interrompida/Salvar estado da aplicação]
    *
    */
    protected void onPause() {
        super.onPause();
        Log.i(TAG, getClassName() + ".onPause() chamado.");
    }

    /*
    * 05 - QUINTO MÉTODO A SER CHAMADO #############################################################
    *
    * O método onStop() é chamado quando a activity está sendo encerrada e não está mais visível
    * para o usuário. Depois de parada, a acitivity pode ser reiniciada se necessário. Caso isso
    * ocorra, o método onRestart() é invocado para reinciar a activity.
    *
    * Caso a activity fique muito tempo parada em segundo plano e o sistema operacional precise
    * limpar os recursos para livrar a memória, o método onDestroy() pode ser automaticamente cha
    * mado para remover completamente a acitivity da pilha.
    *
    *
    *       - Chamado após onPause()
    *       - Activity está sendo encerrada e não mais visível para o usuário;
    *       - Activity parada/onStop/ em background;
    *       - Depois de parada, Activity pode ser reiniciada se necessário pelo onRestart();
    *       - Se o SO precisar limpar recurso para espaço, método onDestroy() pode ser chamado;
    *       - [Resumo: Acitivity sendo encerrada/Colocada em background/Início de uma nova Activity]
    *
    */
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getClassName() + ".onStop() chamado.");
    }

    /*
    * 06 - SEXTO MÉTODO A SER CHAMADO ##############################################################
    *
    * O método onDestroy() literalmente encerra a execução de uma activity. O método pode ser
    * chamado automaticamente pelo sistema operacional ou pode ser chamado pela aplicação pelo
    * método finish() da classe activity.
    *
    * Depois do método onDestroy() ter executado a activity é removida completamente da pilha e
    * seu processo no sistema operacional é completamente encerrado.
    *
    *       - Chamado automáticamente pelo SO ou pela aplicação através do método finish();
    *       - Activity é removida completamente da pilha e seu processo no SO é encerrado
    *       - [Resumo: Encerra a execução/ Processo encerrado no SO]
    *
    */
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, getClassName() + ".onDestroy() chamado.");
    }

    /*
    * 06 - SEXTO MÉTODO A SER CHAMADO ##############################################################
    *
    * O método onRestart é chamado quando uma activity foi parada temporariamente e está sendo
    * iniciada outra vez. O método onRestart() chama o método onStart() automaticamente.
    *
    *       - Chamado quando a activity está em background, não foi destruída e irá reinicializar;
    *       - Background -> Foreground;
    *       - O método onRestart() chama o método onStart() automaticamente;
    *       - Carece de mais informações mas ele é o método que indica que uma activity estava
    *       - em background e estará em foreground. Chamará onStart() que poderemos configurar os
    *       - listeners. Mas o que podemos fazer exatamente dentro do onRestart() não tenho exemplos
    *
    */
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, getClassName() + ".onRestart() chamado.");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, getClassName() + ".onSaveInstanceState() chamado.");
    }

    private String getClassName() {
        // Retorna o nome da classe sem o pacote
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }

    /*
    * CICLOS DE VIDA COMUM PARA ACTIVITYS:
    *
    *
    *   01- ENTIRE LIFETIME
    *
    *       - Ciclo de vida completo da activity;
    *       - Ciclo ocorre apenas uma vez e define o tempo completo da activity;
    *       - Ocorre entre as chamadas onCreate() e onDestroy();
    *       - Activity pode não estar iniciada pois dependerá da config. da view em onCreate();
    *
    *   02- VISIBLE LIFETIME
    *       - Activity iniciada: pode estar em foreground ou background;
    *       - Ciclo ocorre entre os métodos onStart() e onStop();
    *       - Método onStart() é chamado logo após o método onCreate() que é executado apenas 1 vez;
    *       - No método onStart() é definido um ciclo que se repete entre as chamadas:
    *           - onStart()->onResume()->onPause()->onStop()->onRestart()->onStart();
    *       - Durante este ciclo a activity pode estar em foreground ou background;
    *       - Acitivity apenas está em foreground quando o método onResume() é executado;
    *       - Importante entender que os métodos onStart() e onStop() são frequentemente invocados;
    *
    *   03- FOREGROUND LIFETIME
    *       - Activity está no top da pilha (foreground) e interagindo com o usuário;
    *       - Este ciclo ocorre entre os métodos onResume() e onPause();
    *       - A activity pode alterar constantemente entre foreground e background();
    *       - Dessa forma, é recomendado que o código seja leve e rápido nesses 2 métodos;
    *
    *
    * SIMULAÇÃO DE LIGAÇÃO TELEFÔNICA - Visualização do cicle de vida Activity
    *
    *       - Simulação de ligação telefônica via telnet;
    *       - Necessário ativar o serviço telnet no Windows:
    *       - Painel de controle->Programas[Desinstalar]->Ativar ou Desativar uma funcionalidade;
    *       - Digitar os comandos:
    *                                  telnet localhost 5554
    *                                  gsm call 999999999
    *
    *
    *
    *   OBSERVAÇÕES GERAIS DO CICLO DE VIDA
    *
    *   1- Quando utilizamos o voltar nativo do android, o fluxo de ciclo de vida faz sentido
    *           - onPause()     -> Activity_BemVindoActivityActivity
    *           - onStop()      -> Activity_BemVindoActivityActivity
    *           - onDestroy()   -> Activity_BemVindoActivityActivity
    *
    *           - onRestart()   -> MainActivityLogin
    *           - onStart()     -> MainActivityLogin
    *           - onResume()    -> MainActivityLogin
    *
    *   2- Quando utilizamos o voltar do actionBar, o fluxo de ciclo de vida se torna estranho
    *           - onPause()     -> Activity_BemVindoActivityActivity
    *           - onStop()      -> Activity_BemVindoActivityActivity
    *           - onDestroy()   -> Activity_BemVindoActivityActivity
    *
    *           - onDestroy()   -> MainActivityLogin
    *           - onCreate()    -> MainActivityLogin
    *           - onStart()     -> MainActivityLogin
    *           - onResume()    -> MainActivityLogin
    *
    *   A questão é porque houve a necessidade de onDestroy()
    *   em uma tela anterior já criada pelo actionBar para depois criar novamente uma nova view?
    *
    *   3- Importante notar que sempre que utilizamos o back do Android o fluxo do ciclo de vida é:
    *           - onPause(); onStop(); onDestroy()
    *
    *   4- Isso faz com que o estado da aplicação não seja salvo pois o método onDestroy() é
    *       invocado. Então se tivermos uma informação no campo Login assim que restaurar a
    *       activity o campo será perdido. No entanto, se apertar o home a activity não passará
    *       pelo método onDestroy()
    *
    *
    */

}

