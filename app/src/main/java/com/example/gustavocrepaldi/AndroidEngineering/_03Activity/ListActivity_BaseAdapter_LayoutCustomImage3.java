package com.example.gustavocrepaldi.AndroidEngineering._03Activity;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gustavocrepaldi.AndroidEngineering.R;

import java.util.List;

public class ListActivity_BaseAdapter_LayoutCustomImage3 extends BaseAdapter{

    private Context context;
    private List<ListActivity_BaseAdapter_LayoutCustomImage2> lista;


    public ListActivity_BaseAdapter_LayoutCustomImage3(Context context, List<ListActivity_BaseAdapter_LayoutCustomImage2> lista) {
        this.context = context;
        this.lista = lista;
    }

    public int getCount() {
        return lista.size();
    }

    public Object getItem(int position){
        return lista.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int posicao, View convertView, ViewGroup parent){

        ListActivity_BaseAdapter_LayoutCustomImage2 smile = lista.get(posicao);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_smile_detalhes, null);

        TextView textNome = (TextView) v.findViewById(R.id.nome);
        textNome.setText(smile.nome);

        ImageView img = (ImageView) v.findViewById(R.id.img);
        img.setImageResource(smile.getImagem());
        return v;
    }
}
        /*
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
         *
         */
