package com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.Visao;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.DAO.DataAccessObject;
import com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.Modelo.PessoaFisica;
import com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.R;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Arley Laurindo de Oliveira
//Esta atividade tem a função de tela de cadastro de  usuários
//******************************************************

public class CadastrarPessoas extends AppCompatActivity {

    Button bt_gravar_dados;

    Button bt_retornar_tela_principal;

     EditText nome;
     EditText cpf;
     EditText idade;
     EditText telefone;
     EditText email;
    String valorA;

    DataAccessObject gravarPessoa = new DataAccessObject(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_pessoas);

        nome = (EditText) findViewById(R.id.ed_nome);
        cpf = (EditText) findViewById(R.id.ed_cpf);
        idade = (EditText) findViewById(R.id.ed_idade);
        telefone = (EditText) findViewById(R.id.ed_telefone);
        email = (EditText) findViewById(R.id.ed_ema);


        bt_gravar_dados = (Button) findViewById(R.id.bt_gravar);

        bt_retornar_tela_principal = (Button) findViewById(R.id.bt_retornar);

        //metodo de click do botao gravar dados onde captura os dados da view passando por paramatro para um objeto e o mesmo objeto é persitido usando um objeto do tipo dao.
        bt_gravar_dados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nome.length()>0 && cpf.length()>0 && idade.length()>0 && telefone.length()>0 && email.length()>0 ){

                    AlertDialog.Builder adb = new AlertDialog.Builder(CadastrarPessoas.this);
                    adb.setTitle("Sucesso!");
                    adb.setMessage("Cadastro realizado!");
                    adb.show();
                    PessoaFisica novaPessoa = new PessoaFisica();

                    novaPessoa.setNome(nome.getText().toString());
                    novaPessoa.setCpf(cpf.getText().toString());
                    novaPessoa.setIdade(idade.getText().toString());
                    novaPessoa.setTelefone(telefone.getText().toString());
                    novaPessoa.setEmail(email.getText().toString());

                    /*Toast.makeText(CadastrarPessoas.this,
                            "DADOS CADASTRADOS" , Toast.LENGTH_SHORT)
                            .show();*/



                    gravarPessoa.inserirPessoa(novaPessoa);


                }else {
                    //se os campos tiverem vazios seram tratados aqui com o alerta
                    AlertDialog.Builder adb = new AlertDialog.Builder(CadastrarPessoas.this);
                    adb.setTitle("Erro!");
                    adb.setMessage("Todos os campos devem ser preenchidos!");
                    adb.show();}





            }
        });



        //metod de click de botoa para retornar ao menu principal
        bt_retornar_tela_principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastrarPessoas.this,TelaPrincipal.class);

                startActivity(intent);
            }
        });
    }
}
