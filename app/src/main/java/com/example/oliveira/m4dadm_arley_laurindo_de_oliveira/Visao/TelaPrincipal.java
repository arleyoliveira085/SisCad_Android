package com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.Visao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.R;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Arley Laurindo de Oliveira
//Esta atividade tem a função de tela de menu principal onde se decide qual funcao queres tomar, lista os usuários cadastrados ou cadastrar novos.
//******************************************************
public class TelaPrincipal extends AppCompatActivity {


    Button botao_cadastrar;
    Button botao_listar_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        botao_cadastrar = (Button) findViewById(R.id.bt_cadastrar_pessoa);

        botao_listar_registro = (Button) findViewById(R.id.bt_listar_registro);


        //esse metodo  de click do botao tem como funcao direcionar para a tela de cadastrar novos usuários
        botao_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TelaPrincipal.this,CadastrarPessoas.class);

                startActivity(intent);
            }
        });


        //esse metodo  de click do botao tem como funcao direcionar de ir para tela de listrar usuario cadastrados
        botao_listar_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TelaPrincipal.this,ListarRegistro.class);

                startActivity(intent);
            }
        });
    }
}
