package com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.Visao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.R;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Arley Laurindo de Oliveira
//Esta atividade tem a função de criar  uma treade o qual funciona o contador com o tempo de execucao para mostrar a tela de boas vindas e não sendo possivel ser mais utilizada
//******************************************************
public class SplashScreamAtividade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scream_atividade);


        //iniica o process para execucao logo depois do tempo acabar passa a executacao para outra atividade ou seja Telapricinpal
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                startActivity(new Intent(SplashScreamAtividade.this,TelaPrincipal.class));
                finish();
            }
        }).start();
    }
}
