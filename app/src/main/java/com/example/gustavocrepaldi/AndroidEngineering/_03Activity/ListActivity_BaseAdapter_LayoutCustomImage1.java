package com.example.gustavocrepaldi.AndroidEngineering._03Activity;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity_BaseAdapter_LayoutCustomImage1 extends ListActivity{

    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);

        ArrayList<ListActivity_BaseAdapter_LayoutCustomImage2> list = new ArrayList<ListActivity_BaseAdapter_LayoutCustomImage2>();

        list.add(new ListActivity_BaseAdapter_LayoutCustomImage2("Feliz", ListActivity_BaseAdapter_LayoutCustomImage2.FELIZ));
        list.add(new ListActivity_BaseAdapter_LayoutCustomImage2("Triste", ListActivity_BaseAdapter_LayoutCustomImage2.TRISTE));
        list.add(new ListActivity_BaseAdapter_LayoutCustomImage2("Louco", ListActivity_BaseAdapter_LayoutCustomImage2.LOUCO));

        setListAdapter(new ListActivity_BaseAdapter_LayoutCustomImage3(this, list));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        ListActivity_BaseAdapter_LayoutCustomImage2 smile = (ListActivity_BaseAdapter_LayoutCustomImage2) this.getListAdapter().getItem(position);

        Toast.makeText(this, "Você selecionou o smile : " + smile.nome, Toast.LENGTH_SHORT).show();
    }
}

 /*
    * LISTACTIVITY - SimpleAdapter com LayoutCustomImage
    *
    * As vezes é necesário usar um setListAdapter customizado para controlar totalmente a interface
    * visual de cada linha da lista como, por exemplo, exibir imagens junto com um texto que tem
    * correspondecia de significado: Triste->Imagem de um boneco triste e assim por diante. Para
    * isso será necessário a utilização de imagens que estarão na pasta drawable com acesso pela
    * constante R [r.drawable.smile].
    *
    * O exemplo segue a mesma proposta do exemplo anterior envolvendo simpleAdapter com XML customi
    * zado. Mas, neste caso, foi criado um arrayList de ListActivity_SimpleAdapter_
    * LayoutCustomImage2 ao invés de hashMap com chave e valor. Esse LayoutCustomImage2 deve ser
    * mapeado para os campos de um arquivo XML de layout: activity_smile_detalhes.xml.
    *
    * No arquivo de layout está definido os ids nome e img para as tags <TextView> e <ImagemView>.
    * Esses são os campos que exibem o nome e a imagem do ListActivity_BaseAdapter_LayoutCustomImage2.
    * Observe que a classe acima contém um método getImagem() que retorna o id do recurso da imagem
    * inserido na pasta drawable.
    *
    * Até este ponto, o código está similar ao código que definimos nos exemplos anteriores de
    * ArrayAdapter e SimpleAdapter.
    *
    *   Resumindo:
    *       -> Tela de lista: extends ListActivity
    *       -> setListAdapter(Parametro) -> Esse parâmetro pode ser ArrayAdapter, SimpleAdapter
    *                                       ou BaseAdapter para controlar totalmente a interface
    *                                       visual de cada linha da lista
    *
    *           * ArrayAdapter  -> Utiliza um String[] para os itens;
    *           * SimpleAdapter -> Utiliza um ArrayList<> de hashMap;
    *           * BaseAdapter   -> Utiliza um ArrayList<> customizado;
    *
    * Então, no parâmetro devemos passar uma adaptador que até agora vimos que pode ser ArrayAdapter
    * ou SimpleAdapter. Nesse exemplo devemos criar um ListAdapter customizado para ligar os valores
    * de cada ListActivity_BaseAdapter_LayoutCustomImage2 do ArrayList aos campos definidos no XML.
    *
    * Para este exemplo que estamos utilizando um ArrayList<> customizado com a classe
    * ListActivity_BaseAdapter_LayoutCustomImage2, vamos passar como parâmetro para o setListAdapter()
    * uma classe que é filha de BaseAdapter para controlar totalmente a interface visual de cada linha
    * da lista.
    *
    * A classe ListActivity_BaseAdapter_LayoutCustomImage3 é filha de BaseAdapter e implementa alguns
    * métodos simples e o que merece atenção é o método getView(posicao, convertView, parent).
    *
    * O método getView() é chamado automaticamente toda vez que é necessário mapear um registro de uma
    * linha para o XML, neste caso, o texto que será mapeado em imagem!
    *
    * Para isso o parâmetro posicao é utilizado para recuperar o LayoutCustomImage2 da posição
    * desejada. Depois que o LayoutCustomImage2 é recuperado, a classe LayoutInflater é usada para
    * criar um objeto View a partir do id de um arquivo XML de layout.
    *
    * Depois que a View foi criada a partir de um XML de layout, o método findViewById() é utilizado
    * para recuperar os campos desejados e os valores dos campos são atualizados conforme os valores
    * do LayoutCustomImage2 atual.
    *
    *       Resumindo o exemplo: informamos um 'adaptador' customizado para fazer a ligação entre a
    *       lista de LayoutCustomImage2 e cada linha da tela através da classe BaseAdapter. Dessa for
    *       ma, o método getView() da classe LayoutCustomImage2 é chamado automaticamente para retor
    *       nar uma instancia de View para desenhar cada linha da lista. Esse é o método que desenha
    *       cada linha com o nome e imagem. Para isso, o arquivo xml de layout foi acessado e a clas
    *       se LayoutInflater foi usado para converter esse arquivo em um objeto do tipo View.
    *
    */
