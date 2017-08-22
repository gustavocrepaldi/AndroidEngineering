package com.example.gustavocrepaldi.AndroidEngineering._04Intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gustavocrepaldi.AndroidEngineering.R;


public class Intentn_SetResult extends Activity {

    @Override
    protected void onCreate(Bundle icicle) {

        super.onCreate(icicle);
        setContentView(R.layout.intent_tela_sim_nao);

        //Vinculando Evento ao botão SIM
        Button lBtnSim = (Button) findViewById(R.id.btSim);
        lBtnSim.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //Cria a Intent
                //Seta a mensagem de retorno
                //Seta o status do resultado e a Intent

                /*
                 *  setResult(int pResultCode, Intent pData)
                 *
                 *  pResultCode:
                 *      Código de retorno para a acitivity originadora
                 *      (RESULT_CANCELED or RESULT_OK)
                 *
                 *  pData:
                 *      Dados de retorno para a activity originadora
                 */

                Intent lIt = new Intent();
                lIt.putExtra("msg", "Clicou em Sim !");
                setResult(1,lIt);
                finish();

                /*      Passagem de parâmetros de forma encapsulada e não encapsulada
                 *
                 *      Forma Encapsulada                       Forma Não-Encapsulada
                 *      Intent lIntent = new Intent();          Intent lIntent = new Intent();
                 *      lIntent.putExtra("chave", "valor");     Bundle lParams = new Bundle();
                 *      startActivity(lIntent);                 lParams.putString("chave", "valor");
                 *                                              lIntent.putExtras(lParams);
                 *                                              startActivity(lIntent);
                 *
                 *      Recuperação Direta da Chave/Valor       Recuperação Completa do Bundle
                 *      Intent lIntent = getIntent();           Intent lIntent = getIntent();
                 *      String nome                             Bundle args = lIntent.getExtras();
                 *          = lIntent                           String lNome = args.getString("nome");
                 *              .getStringExtra("chave");       String lTel = args.getString("tel");
                 *
                 *      CONCLUSÃO:
                 *          .putExtras .getExtras (PLURAL) sempre será necessário o bundle
                 *          .putExtra .getExtra atribui ou recupera diretamente a chave/valor
                 */

            }});

        //Vinculando Evento ao botão NÃO
        Button lBtnNao = (Button) findViewById(R.id.btNao);
        lBtnNao.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //Cria a Intent
                //Seta a mensagem de retorno
                //Seta o status do resultado e a Intent

                /*
                 *  setResult(int pResultCode, Intent pData)
                 *
                 *  pResultCode:
                 *      Código de retorno para a acitivity originadora
                 *      (RESULT_CANCELED or RESULT_OK)
                 *
                 *  pData:
                 *      Dados de retorno para a activity originadora
                 */

                Intent lIt = new Intent();
                lIt.putExtra("msg", "Clicou em Não !");
                setResult(2,lIt);
                finish();
            }});
    }

}
