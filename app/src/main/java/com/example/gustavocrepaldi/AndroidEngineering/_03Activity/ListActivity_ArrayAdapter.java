package com.example.gustavocrepaldi.AndroidEngineering._03Activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity_ArrayAdapter extends ListActivity{

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] itens = new String[] { "Nome 1", "Nome 2", "Nome 3" };

        // Utiliza o adaptador ArrayAdapter, para exibir o array de Strings na tela.
        // Fazendo a ligação entre o componente ListView e os valores que a aplicação deseja exibir
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (
                this,                                //--> Contexto
                android.R.layout.simple_list_item_1, //--> Recurso de layout pré definido no Android
                itens                                //--> Itens que serão exibidos
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
    * LISTACTIVITY - ArrayAdapter
    *
    *  - Normalmente a tela do app depende apenas de uma classe-filha de Activity com um layout XML;
    *  - No entanto, é necessário exibir informações mais complexas como mapa e lista;
    *  - Para esses casos foram criados classes especiais: android.app.ListActivity e .MapActivity;
    *  - Elas são subclasses de Activity e já encapsulam métodos para exibir conteúdo na tela;
    *
    *  - A classe ListActivity já declara internamente um componente do tipo android.widget.ListView
    *  - Responsável por desenhar os componentes em uma lista vertical e com barra de rolagem;
    *  - O método setContentView() é chamado automaticamente pela ListActivity informado o ListView;
    *  - Dessa forma, não há necessidade de se preocupar com View da tela mas informar os dados;
    *
    *  - P/isso é necessário criar um objeto que implemente a interface android.widget.ListAdapter;
    *  - Fazendo a ligação entre o componente ListView e os valores que a aplicação deseja exibir;
    *  - Podemos utilizar o ArrayAdapter para isto e informar os valores a ele;
    *  - Importante entender que ListActivity já define internamente o componente ListView
    *  - Dessa forma, não é necessário se preocupar em chamar o método setContentView();
    *
    *  - A classe ListActivity tem por finalidade facilitar o trabalho de manipulação de uma lista;
    *  - Possui método onListItemClick() invocado automaticam. qdo user clica em cima de uma linha;
    *  - getListAdapter().getItem(position) para recuperar informações do item selecionado;
    *
    */

}
