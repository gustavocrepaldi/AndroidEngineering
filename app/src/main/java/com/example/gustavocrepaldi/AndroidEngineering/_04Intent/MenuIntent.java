package com.example.gustavocrepaldi.AndroidEngineering._04Intent;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuIntent extends ListActivity {


    protected static final String TAG = "IntentLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] mStrings = new String[] {
                "00 - Exemplo Abrir Browser",
                "01 - Ligar Para um Telefone",
                "02 - Visualizar Primeiro Contato",
                "03 - Visualizar Contatos startActivityForResult(...)",
                "04 - StartActivityForResult(...) / setResult / onActivityResult",
                "Sair"};

        this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mStrings));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        switch (position) {
            case 0:
                Intent intent = new Intent(this,Intent_ACTION_VIEW.class);
                Log.i(TAG, "00");
                startActivity(intent);
                break;
            case 1:
                Log.i(TAG, "01");
                startActivity(new Intent(this,Intent_ACTION_CALL_ACTION_DIAL.class));
                break;
            case 2:
                Log.i(TAG, "02");
                startActivity(new Intent(this,Intent_ACTION_VIEW_ContentProvider.class));
                break;
            case 3:
                Log.i(TAG, "03");
                startActivity(new Intent(this,Intent_ACTION_PICK.class));
                break;
            case 4:
                Log.i(TAG, "04");
                startActivity(new Intent(this, Intent_StartActivityForResult.class));
                break;
            default:
                finish();
        }
    }
}

    /*
    * INTENT
    *
    * Capítulo é sobre o coração do Android, a classe android.content.Intent. Um intent está presen
    * te em todos os lugares e representa uma mensagem da aplicação para o sistema operacional, soli
    * citando que algo seja realizado e representa um importante papel na arquitetura do Android pa
    * ra integrar diferentes aplicações.
    *
    * Cabe ao SO interpretar essa mensagem e tomar as providências necessárias que pode ser abrir
    * um Browser, abrir uma simples aplicação, fazer uma ligação entre outros. Portanto, a classe
    * intent representa uma ação  que a app deseja executar.
    *
    * Na pratica a intent é enviada ao sistema operacional como uma mensagem, chamada de broadcast.
    * Ao receber a mensagem, o sistema operacional tomará as decisões necessárias, dependendo do con
    * teúdo da mensagem.
    *
    * Uma activity geralmente representa uma tela na aplicação. Obviamente há a necessidade de nave
    * gar entre uma tela e outra e, para isso, o método startActivity(intent) é utilizado. O parâme
    * tro intent é uma instância da classe android.content.Intent que contém as informações necessá
    * rias sobre a activity que será executada.
    *
    *       Intent intent = new Intent(this, Tela2.class);
    *       startActivity(intent);
    *
    * Esse código criou uma mensagem para o sistema operacional. "Minha intenção/vontade é abrir a
    * tela 2". Ao chamar o método startAcitivty(intent), essa mensagem é enviada ao sistema opera
    * cional. Cabe ao SO analisar o oonteúdo da mensagem e encontrar a tela correta que precisa ser
    * aberta. O interessante de uma mensagem enviada por uma intent é que nem sempre ela é recebida
    * pela própria aplicação que a criou, frequentemente sendo utilizada para integrar aplicações.
    *
    * Existe uma outra forma de utilizar o construtor de intent para abrir uma tela, por exemplo,
    * que receba uma string. Essa string representa a ação que deve ser executada pelo SO do Android.
    * O valor dessa string pode ser qualquer coisa, "ACAO_GUSTAVO", "ACAO_CREPALDI" desde que faça
    * sentido para a aplicação que está sendo desenvolvida.
    *
    * No Android é possível mapear AÇÕES para executar uma activity. Por exemplo, o seguinte código
    * pode abrir a mesma tela2 anteriormente, desde que a ação ABRIR_TELA_2 represente uma ação váli
    * da.
    *
    *       Intent intent = new Intent("ABRIR_TELA_2");
    *       startActivity(intent);
    *
    *
    *       Resumindo
    *
    *       Intent i = new Intent(this, Tela2.class);   --> Recebe a classe Activity que deve ser executada;
    *       Intent i = new Intent("ACAO_TESTE");        --> Recebe a ação que deve ser executada;
    *
    *
    *       INTENTS NATIVAS
    *       Uri uri         = Uri.parse("http://www.uol.com.br");
    *       Intent i        = new Intent(Intent.ACTION_VIEW, uri);
    *
    *       Uri uri       = Uri.parse("tel:04114981458382");
    *       Intent intent = new Intent(Intent.ACTION_CALL, uri);
    *
    */
