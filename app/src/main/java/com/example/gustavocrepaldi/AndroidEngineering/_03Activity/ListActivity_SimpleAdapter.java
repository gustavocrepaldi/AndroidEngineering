package com.example.gustavocrepaldi.AndroidEngineering._03Activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity_SimpleAdapter extends ListActivity{

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        //No SimpleAdapter cada linha de um ArrayList fornecido deve ser um HashMap
        for (int i = 0; i < 30; i++) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("nome", "Nome " + i);
            item.put("fone", "Fone " + i);
            list.add(item);
        }

        //Cada chave definida no HashMap precisa ser mapeada para um componente no arquivo XML
        //FROM=[NOME,FONE] TO=[Text1, Text2]
        String[] from = new String[] { "nome", "fone" };
        int[] to = new int[] { android.R.id.text1, android.R.id.text2 };

        //Layout onde se encontra os ids fornecidos para a vinculação entre HashMap e XML
        int layoutNativo = android.R.layout.two_line_list_item;

        SimpleAdapter adaptador = new SimpleAdapter
                (
                        this,                                //--> Contexto
                        list,                                //--> Cada linha deve ser um HashMap
                        layoutNativo,                        //--> Layout pré-definido com 2 campos
                        from,                                //--> Define as chaves do HashMap
                        to                                   //--> Define os componentes do XML
                );


        setListAdapter(adaptador);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // Pega o item naquela posição
        Object o = this.getListAdapter().getItem(position);
        String item = o.toString();
        Toast.makeText(this, "Você selecionou: " + item, Toast.LENGTH_SHORT).show();
    }

}

   /*
    * LISTACTIVITY - SimpleAdapter
    *
    * A classe SimpleAdapter recebe como parâmetro uma java.util.List onde cada item da lista
    * é mapeado para uma linha do componente ListView definido internamente pela ListActivity.
    *
    * No SimpleAdapter cada linha de um ArrayList fornecido deve ser um HashMap, que por sua vez,
    * contém as chaves e valores necessários para compor a linha. Cada chave definida no HashMap
    * precisa ser mapeada para um componente no arquivo XML.
    *
    * O exemplo cria um ArrayList onde cada linha da lista é um HashMap com os valores de cada linha
    * com as chaves do HashMap[nome,fone].
    *
    * Para isso o contrutor da classe SimpleAdapter recebe:
    *            - ArrayList
    *            - Array de string com chaves do HashMap
    *            - Array de int com os ids dos componentes definidos no XML
    *            - Layout onde se encontra os ids fornecidos para a vinculação entre HashMap e XML
    *
    * O arquivo XML de layout utilizado é predefinido no Android chamado android.R.layout.two_line_
    * list_item que tem dois campos no XML [text1 e text2]. Por este motivo o array com os ids foi
    * definido como int[] to = new int[] { android.R.id.text1, android.R.id.text2 };
    *
    * Nesse caso, um layout padrão foi utilizado o que pode economizar algumas linhas de código, mas
    * em aplicações mais complexas serã necessário customizar o layout da tela e criar um arquivo
    * XML de layout customizado.
    *
    */
