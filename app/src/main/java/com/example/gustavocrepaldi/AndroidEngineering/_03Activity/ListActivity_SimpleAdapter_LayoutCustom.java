package com.example.gustavocrepaldi.AndroidEngineering._03Activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.gustavocrepaldi.AndroidEngineering.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity_SimpleAdapter_LayoutCustom extends ListActivity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        //No SimpleAdapter cada linha de um ArrayList fornecido deve ser um HashMap
        for (int i = 0; i < 30; i++) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("nome", "Nome " + i);
            item.put("fone", "Fone " + i);
            item.put("endereço", "Endereço " + i);
            list.add(item);
        }

        //Cada chave definida no HashMap precisa ser mapeada para um componente no arquivo XML
        //FROM=[NOME,FONE] TO=[Text1, Text2]
        String[] from = new String[] { "nome", "fone", "endereço" };
        int[] to = new int[] { R.id.nome, R.id.fone, R.id.endereco };

        //Layout onde se encontra os ids fornecidos para a vinculação entre HashMap e XML
        int layoutCustom = R.layout.activity_contatofone;

        SimpleAdapter adaptador = new SimpleAdapter
                (
                        this,                                //--> Contexto
                        list,                                //--> Cada linha deve ser um HashMap
                        layoutCustom,                        //--> Layout pré-definido com 2 campos
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

    /*
    * LISTACTIVITY - SimpleAdapter Custom Layout
    *
    * No exemplo SimpleAdapter foi utilizado um layout padrão do Android  através da constante
    * android.R.layout.two_line_list_item. Neste exemplo foi utilizado um layout custom para
    * mostrar a flexibilidade de montar uma tela de lista com um XML próprio.
    *
    * O mapeamento do hashmap continua necessário com a vinculação no novo layout. Fique atento
    * que neste exeplo o hashmap utilizado acrescentou um novo campo 'endereço'. Isso indica
    * que podemos ter quantos elementos quisermos no hashmap e sua vinculação no XML customizado.
    *
    */

}
