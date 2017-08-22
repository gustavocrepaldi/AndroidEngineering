package com.example.gustavocrepaldi.AndroidEngineering._04Intent;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.gustavocrepaldi.AndroidEngineering.R;

public class Intent_ACTION_PICK extends Activity implements OnClickListener {

    // Constante para identificar a sub-activity lançada
    private static final int SELECIONAR_CONTATO = 1;
    private static final String CATEGORIA = "livro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_visualizar_todos_contatos);
        Button button = (Button) findViewById(R.id.visualizarTodosOk);
        button.setOnClickListener(this);
    }

    public void onClick(View view) {

        Uri uri = Uri.parse("content://com.android.contacts/contacts/");
        Intent it = new Intent(Intent.ACTION_PICK, uri);
        // Envia a mensagem assíncrona ao sistema operacional
        startActivityForResult(it, SELECIONAR_CONTATO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent it) {

        if (it == null) {
            Toast.makeText(this, "Nenhum contato", Toast.LENGTH_SHORT).show();
            return;
        }

        // URI que identifica o contato
        Uri uri = it.getData();
        Toast.makeText(this, "Contato: " + uri, Toast.LENGTH_SHORT).show();

        // Solicita o Android para visualizar o contato
        // startActivity(new Intent(Intent.ACTION_VIEW,uri));

        imprimirNome(it);

            /*        // Busca o contato no banco de dados
        Cursor c = managedQuery(uri, null, null, null, null);

        c.moveToNext();

        // Recupera o nome do contato
        String[] s = c.getColumnNames();
        if (s != null) {
            for (int i = 0; i < s.length; i++) {
                Log.i(CATEGORIA, String.valueOf(s[i]));
                String valor = c.getString(c.getColumnIndexOrThrow(s[i]));
                Log.i(CATEGORIA, valor != null ? valor : "?");
            }
        }*/
    }

    private void imprimirNome(Intent it) {
        // Visualizar o Contato selecionado

        Uri uri = it.getData();

        Log.i(CATEGORIA, "Visualizando contato: " + uri);

        // Busca o contato no banco de dados
        Cursor c = managedQuery(uri, null, null, null, null);

        c.moveToNext();

        // Recupera o nome do contato
        String[] s = c.getColumnNames();
        if (s != null) {
            for (int i = 0; i < s.length; i++) {
                Log.i(CATEGORIA, String.valueOf(s[i]));
                String valor = c.getString(c.getColumnIndexOrThrow(s[i]));
                Log.i(CATEGORIA, valor != null ? valor : "?");
            }
        }

        // Coluna: display_name
        int index = c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME);

        //int index = c.getColumnIndexOrThrow("primary_email");
//		Log.i(TAG,"index primary_email : " + index);

        String nome = c.getString(index);

        Toast.makeText(this, "Nome: " + nome, Toast.LENGTH_SHORT).show();
    }

}

/*
 *  Intent.ACTION_PICK
 *
 * O código a seguir utiliza a ação Intent.ACTION_PICK para exibir a lista completa da agenda de con
 * tatos, permitindo que o usuário selecione algum contato da lista. Observe que a uri utilizada pa
 * ra exibir todos os contatos é content://com.android.contacts/contacts/
 *
 * ACTION_PICK: Pick an item from data returning what was selected.
 *
 */