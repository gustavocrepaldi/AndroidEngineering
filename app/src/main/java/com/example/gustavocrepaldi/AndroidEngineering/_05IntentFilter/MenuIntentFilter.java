package com.example.gustavocrepaldi.AndroidEngineering._05IntentFilter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/* INTENT FILTER
 *
 * Quando uma mensagem é enviada para o sistema operacional utilizando a classe INTENT é necessário
 * configurar a classe IntentFilter para interceptar essa mensagem com base em sua AÇÃO E CATEGORIA.
 * Até então utilizamos a classe Intent para abrir outra tela da aplicação referenciando diretamente
 * a classe da activity desejada:
 *
 *      Intent i = new Intent(this, Acitivity2.class);
 *      startActivity(i);
 *
 * No entanto, as vezes não será conhecido a activity que será invocada. Nesse cenário o Android per
 * mite definir uma ação que identifica a intent, de forma que quando a mensagem for enviada ao
 * sistema operacional ela seja identificada por essa ação. Somente a activity que estiver mapeada
 * para aquela ação será executada.
 *
 * Para definir essa ação no Android, basta criar uma Intent usando seu construtor que recebe uma
 * string que identifica a ação [e categoria]
 *
 *      Intent i = new Intent("AÇÃO_FAZER_ALGO");
 *      startActivity(i);
 *
 * A activity que será executada a partir dessa mensagem para o SO deverá ser configurada para inter
 * ceptar essa mensagem. Para isso existe a classe android.content.IntentFilter. Ela é utilizada
 * para mapear uma ação para determinada tarefa, como abrir uma tela com uma activity. IntentFilter
 * é um filtro de uma intent para decidir se a mensagem daquela intent lhe interessa ou não, e em
 * caso afirmativo, a activity (por exemplo) que contém aquele IntentFilter será executada.
 *
 * IntentFilter pode ser utilizado para abrir uma activity a partir de uma ação mas a grande mágica
 * é que essa arquitetura baseado em Intent e IntentFilter está presente no Sistema Operacional An
 * droid como um tod. Quando o SO recebe uma mensagem SMS, ele dispara uma intent com a ação
 * android.provider.Telephony.SMS_RECEIVED, que pode ser configurado por qualquer aplicação que dese
 * ja interceptar essa intent para, por exemplo, ler o SMS.
 *
 */

public class MenuIntentFilter extends ListActivity {

    private static final String[] nomes = new String[] {
            "Tela 1 ou 2 [ACAO_TESTE, DEFAULT]",
            "Tela 2 [ACAO_TESTE,CATEGORIA_TESTE]",
            "Tela 3 [ABRIR_TELA, CATEGORIA_3] ",
            "Tela 4 ou 5 [ABRIR_TELA, CATEGORIA_DUPLICADA]",
            "BroadcastReceiver",
            "Sair"};

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nomes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent it;
        switch (position) {
            case 0:
                //Mensagem endereçada para Activity 1 ou 2
                it = new Intent("ACAO_TESTE");
                startActivity(it);
                break;
            case 1:
                //Mensagem endereçada para Activity 2
                it = new Intent("ACAO_TESTE");
                it.addCategory("CATEGORIA_TESTE");
                startActivity(it);
                break;
            case 2:
                //Mensagem endereçada para Activity 3
                it = new Intent("ABRIR_TELA");
                it.addCategory("CATEGORIA_3");
                startActivity(it);
                break;
            case 3:
                //Mensagem endereçada para Activity 4 ou 5
                it = new Intent("ABRIR_TELA");
                it.addCategory("CATEGORIA_DUPLICADA");
                startActivity(it);
                break;
            case 4:
                //Abrir o BroadcastReceiver1
                //Não implementado
                //it = new Intent("TESTE_ABRIR_RECEIVER");
                //sendBroadcast(it);
                break;
            default:
                finish();
        }
    }
}
