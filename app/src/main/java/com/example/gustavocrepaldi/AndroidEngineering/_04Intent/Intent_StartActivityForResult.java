package com.example.gustavocrepaldi.AndroidEngineering._04Intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gustavocrepaldi.AndroidEngineering.R;

public class Intent_StartActivityForResult extends Activity {

    public final static int ACTIVITY_SIM_NAO = 10;

    @Override
    protected void onCreate(Bundle icicle) {



        super.onCreate(icicle);
        setContentView(R.layout.intent_inicio_tela_sim_nao);
        Button lBtIniciar = (Button) findViewById(R.id.btIniciar);

        lBtIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                * startActivityForResult(pIntent, pRequestCode)
                *
                * pIntent:
                *   Intent para abrir a tela desejada;
                *
                * pRequestCode:
                *   Código numérico utilizado p/identificar a activity que será
                *   iniciada. O mesmo valor será passado ao método onActivityResult quando a
                *   activity chamada finalizar. Se mais de uma activity for utilizada no código
                *   essa constante deve ser utilizada para diferenciar cada tipo de retorno;
                *
                * */
                startActivityForResult(
                        new Intent(Intent_StartActivityForResult.this,Intentn_SetResult.class)
                        ,ACTIVITY_SIM_NAO);
            }
        });

    }

    /*
     * pRequestCode:
     *      Valor que originou a chamada com o método startActivityForResult();
     *
     * pResult:
     *      Constante que indica se o resultado foi bem-sucedido ou não. Pode ser
     *      qualquer constante definida na aplicação;
     *
     * pIntent:
     *      Intent que originou o retorno. Com essa intent é possível recuperar o
     *      bundle para ler os parâmetros retornados. Ou podemos recuperar a chave/valor
     *      diretamente sem recuperar o bundle inteiro. Ver considerações em Intentn_SetResult.java
     *
     */
    @Override
    protected void onActivityResult(int pRequestCode, int pResult, Intent pIntent) {

        //Observe que utilizando este método onActivityResult não é necessário
        //usar o getIntent() pois o parâmetro pIntent já é a Intent que originou o retorno
        //Exemplo de getIntent ver no projeto sobre Activity

        // Identifica se a activity que retornou foi do exemplo SIM_NAO
        if (pRequestCode == ACTIVITY_SIM_NAO) {

            //Evitando de pegar o Bundle inteiro passado pela acitivity
            String lMsg = pIntent.getStringExtra("msg");
            if(lMsg != null){
                if (pResult == 1) {
                    Toast.makeText(this, "Escolheu Sim: " + lMsg,Toast.LENGTH_SHORT).show();
                } else if (pResult == 2) {
                    Toast.makeText(this, "Escolheu Não: " + lMsg,Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Não definido: " + lMsg,Toast.LENGTH_SHORT).show();
                }
            }

//            Bundle params = pIt != null ? pIt.getExtras(): null;
//            if (params != null) {
//                String msg = params.getString("msg");
//
//                if (pResult == 1) {
//                    // Sim
//                    Toast.makeText(this, "Escolheu Sim: " + msg,Toast.LENGTH_SHORT).show();
//                } else if (pResult == 2) {
//                    // Nao
//                    Toast.makeText(this, "Escolheu Não: " + msg,Toast.LENGTH_SHORT).show();
//                } else {
//                    // cancelado talvez..
//                    Toast.makeText(this, "Não definido: " + msg,Toast.LENGTH_SHORT).show();
//                }
//            }
        }
    }

}

/*  Retornando resultados de um activity - StartActivityForResult
 *
 * Vimos que é possível utilizar a ação ACTION_PICK para ler os contatos da agenda. Depois de seleci
 * onar algum contato o método onActivityResult() é executado informando o resultado. Isso acontece
 * porque a tela nativa do Android que exibe contatos da agenda já está preparada para retornar o
 * contato selecionado, se necessário.
 *
 * Agora, neste exemplo, aprenderemos como fazer isso com uma tela da nossa app. Se uma tela foi aber
 * ta e será necessário retornar alguma informação desta tela devemos utilizar uma Intent e chamar o
 * método finish() e setResult() da classe activity, conforme a seguir:
 *
 *      Intent it = new Intent();
 *      it.putExtras(b);
 *      setResult(RESULT_OK, it);
 *      finish();
 *
 *
 */
