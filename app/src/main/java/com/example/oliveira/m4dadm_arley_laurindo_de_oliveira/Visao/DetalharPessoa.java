package com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.Visao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.R;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Arley Laurindo de Oliveira
//Esta atividade tem a função de tela de lista todos os dados  do usuário selecionado do listview
//******************************************************
public class DetalharPessoa extends AppCompatActivity {

    TextView nome;
    TextView cpf;
    TextView idade;
    TextView telefone;
    TextView email;
    Button bt_retornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhar_pessoa);

        //recebedndo os valores que vem da tela

        bt_retornar = (Button) findViewById(R.id.botao_retornar);

        nome= (TextView)findViewById(R.id.tetx_nome_pessoa);
        cpf= (TextView)findViewById(R.id.textview_cpf);
        idade= (TextView)findViewById(R.id.textView_idade);
        telefone= (TextView)findViewById(R.id.textView_telefone);
        email= (TextView)findViewById(R.id.textView_email);

        Bundle bundle = getIntent().getExtras();

        //aqui trabalhamos com chave-valor  estamos recebendo valores de acordo com as chaves citadade na atividade anterior e setando nas propriedadas da view.
        nome.setText(bundle.getString("nome"));
        cpf.setText(bundle.getString("cpf"));
        idade.setText(bundle.getString("idade"));
        telefone.setText(bundle.getString("telefone"));
        email.setText(bundle.getString("email"));

        //evento do botao que retornar para tela antetrior ou seja teka de listarregistro
        bt_retornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalharPessoa.this,ListarRegistro.class);
                startActivity(intent);
            }
        });

    }
}
