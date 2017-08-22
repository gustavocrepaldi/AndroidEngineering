package com.example.gustavocrepaldi.AndroidEngineering._03Activity;


import android.app.ListActivity;
import android.os.Bundle;

import com.example.gustavocrepaldi.AndroidEngineering.R;

import java.util.ArrayList;

public class ListActivity_BaseAdapter_LayoutCustomImage2 {

    public static final int FELIZ = 0;
    public static final int TRISTE = 1;
    public static final int LOUCO = 2;

    public String nome;
    private final int tipo;

    public ListActivity_BaseAdapter_LayoutCustomImage2(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getImagem(){

        switch (tipo){
            case FELIZ:
                return R.drawable.feliz;
            case TRISTE:
                return R.drawable.triste;
            case LOUCO:
                return R.drawable.louco;
        }

        return R.drawable.naoencontrado;
    }
}
