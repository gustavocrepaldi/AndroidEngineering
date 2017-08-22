package com.example.gustavocrepaldi.AndroidEngineering._04Intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gustavocrepaldi.AndroidEngineering.R;


public class Intent_ACTION_VIEW extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.intent_form_browser);

        final Button button = (Button) findViewById(R.id.botaoOk);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText campoEndereco = (EditText) findViewById(R.id.campoEndereco);
                String endereco = campoEndereco.getText().toString();

                // Representa o endereço que desejamos abrir
                // Uniform Resource Identifier
                Uri uri = Uri.parse(endereco);

                // Cria a Intent com o endereço
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                // Envia a mensagem ao sistema operacional
                startActivity(intent);

            }
        });
    }

}

/*
 * Intent.ACTION_VIEW
 *
 *      Intent intent = new Intent(Intent.ACTION_VIEW, URI);
 *
 * Como a ação informada é definida pela constante Intent.ACTION_VIEW, o Android sabe que precisa
 * tratar essa mensagem e abrir o Browser. No momento que startActivity(intent) é chamado, uma men
 * sagem é enviada para o sistema operacional.
 *
 * O importante entender é que não existe diferença em criar uma intent para uma ação local de sua
 * aplicação e uma intent que será respondida pelo próprio sistema operacional. Como pode notar nes
 * te exemplo o método startActivity(intent) foi utilizado da mesma forma que poderia ser utilizado
 * para abrir uma tela da própria aplicação.
 *
 * Depois que a mensagem é enviada ao Sistema Operacional alguém precisa interpretá-la baseada em
 * seu conteúdo. Nesse caso, a aplicação do browser, que é nativa do Android, fez esse papel automa
 * ticamente e, dessa forma, acabamos de demonstrar como integrar diferentes aplicações.
 *
 * A arquitetura formada pelas classes Intent e Activity está presente em tudo e o Android não dife
 * rencia uma activity criada na sua aplicação de uma activity nativa da plataforma, como a do brow
 * ser.
 *
 * Para abrir uma activity local da aplicação, utilizamos o construtor da classe Intent que recebe a
 * classe da Activity que precisa ser executada. Também é possível fornecer uma string com a ação
 * desejada. Mas para isso a ação precisaria ser mapeada ára executar determinada classe, que poderi
 * a ser uma activity, service ou broadcastreceiver. Esse mapeamento é configurado utilizando a tag
 * <intent-filter> no arquivo AndroidManifest.xml.
 */


