package com.example.gustavocrepaldi.AndroidEngineering._03Activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gustavocrepaldi.AndroidEngineering.R;


public class Activity_MainActivityActivity extends Activity_DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLogin = (Button) findViewById(R.id.btLogin);

        /*
        * No Android para tratar eventos de um botão é utilizado o método setOnClickListener(listener)
        *
        * Esse método recebe como argumento uma instância da INTERFACE android.view.View.OnClickListener.
        * Esse método deve receber uma implementação da INTERFACE View.OnClickListener.
        *
        * A INTERFACE View.onClickListener define o método onClick(view) o qual é chamado quando o evento
        * ocorrer, passando como argumento o objeto da view que gerou o evento, neste caso, o botão.
         */

        btLogin.setOnClickListener(onClickLogin());
    }

    /*
     *  FORMA 01- Tratamento de Evento Android
     *
     *  Implementação do Conceito de classes anônimas do Java.
     *  A instância da interface define o método onClick()
     *
     *  btLogin.setOnClickListener( new View.OnClickListener () {
     *       @Override
     *       public void onClick(View v) {
     *         //...
     *      }
     *  }
     */

    /*
     *  FORMA 02- Classe Activity Implementar a interface View.OnClickListener
     *
     *  A própria classe implementa View.onClickListener
     *  Desvantagem: Se possuir mais que um botão na tela o método onClick(View) será
     *  chamado para todos os botões. Portanto, o parâmetro View indica qual componente
     *  gerou o evento, e deve ser utilizado para descobrir em qual botão foi feito o clique
     *
     *  public class Activity_MainActivityActivity extends Activity_DebugActivity implements View.OnClickListener {
     *    @Override
     *   protected void onCreate(Bundle savedInstanceState) {
     *   super.onCreate(savedInstanceState);
     *   setContentView(R.layout.activity_main);
     *
     *   Button btLogin1 = (Button) findViewById(R.id.btLogin1);
     *   btLogin1.setOnClickListener(this); //this representa a instância da classe
     *
     *   Button btLogin2 = (Button) findViewById(R.id.btLogin2);
     *   btLogin2.setOnClickListener(this); //this representa a instância da classe
     *
     *   }
     *
     *   @Override
     *   public void onClick(View view) {
     *      if(view.getId() == R.id.btLogin1) {
     *          //Clicou botão1
     *      } else if(view.getId() == R.id.btLogin2) {
     *          //Clicou botão2
     *      }
     *   }
     *
     *   }
    */

    /*
     *  FORMA 03- Criação de um método para cada botão
     *
     *  Vantagem: Fácil de separar cada clique em um método.
     *  O método onClickLogin retorna uma implementação de View.OnClickListener
     *
     *  Segue a mesma idéia da definição de classes anônimas mas ao invés de declarar diretamente
     *  no argumento do método setOnClickListener, fazemos uma função para separar o click do componente
     *  por nome de função separado. Se notarmos a a implementação é muito parecido com o a FORMA 03.
     */

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tLogin = (TextView)
                        findViewById(R.id.tLogin);
                TextView tSenha = (TextView)
                        findViewById(R.id.tSenha);
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                if("gustavo".equals(login) && "Access123".equals(senha)) {
                    // Navega para a próxima tela

                    Intent intent = new Intent(getContext(),Activity_BemVindoActivityActivity.class);
                    Bundle params = new Bundle();
                    params.putString("nome", "GUSTAVO CREPALDI");
                    intent.putExtras(params);
                    startActivity(intent);
                } else {
                    alert("Login e senha incorretos.");
                }
            }
        };
    }

    private Context getContext() {
        return this;
    }

    private void alert(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    /*@Override
    public boolean onCreateOptionsMenu(MenuIntent menu) {
        // Infla o menu da action bar (/res/menu/main.xml)
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            // Clicou no botão settings da action bar (o toast é um breve alerta que vai sumir)
            Toast.makeText(this,"Clicou no settings",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

}
