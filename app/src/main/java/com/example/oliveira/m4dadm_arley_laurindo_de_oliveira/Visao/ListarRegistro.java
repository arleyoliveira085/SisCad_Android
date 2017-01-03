package com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.Visao;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.DAO.DataAccessObject;
import com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.Modelo.PessoaFisica;
import com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.R;

import java.util.ArrayList;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Arley Laurindo de Oliveira
//Esta atividade tem a função de tela de listar todos os usuarios cadastrados no banco de dados
//******************************************************
public class ListarRegistro extends AppCompatActivity {

    private ListView listViewPessoas;

    private ArrayList<PessoaFisica> lista_de_pessoa;

    private ArrayAdapter<PessoaFisica> adaptadorLista;

    private int adaptadorLayout = android.R.layout.simple_list_item_1;

    Button bt_retorna_menu;

    private  PessoaFisica pessoaBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_registro);

        listViewPessoas =  (ListView) findViewById(R.id.listview_de_pessoas);

        final DataAccessObject dao = new DataAccessObject(this);

        lista_de_pessoa  = dao.CarregarPessoasDoBanco();

        adaptadorLista = new ArrayAdapter<PessoaFisica>(this, adaptadorLayout, lista_de_pessoa);

        listViewPessoas.setAdapter(adaptadorLista);

        bt_retorna_menu =  (Button)findViewById(R.id.bt_retornar_menu);


        //botao para retornar ao menu principal
        bt_retorna_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarRegistro.this,TelaPrincipal.class);

                startActivity(intent);
            }
        });

        //essa função registra as acoes do menu para o listview que estamos trabalhando ou seja listview de pessoas
        registerForContextMenu(listViewPessoas);
        //evento de click longo onde surge um menu de opcoes inflater na tela
        listViewPessoas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                pessoaBean = adaptadorLista.getItem(position);

                /*Toast.makeText(ListarRegistro.this,
                        "Idade do usuário : "+pessoaBean.getIdade() , Toast.LENGTH_SHORT)
                        .show();*/

                return false;
            }
        });

    }

    /*esse metodo funciona para criar o menu e nele inflar,de acordo com o arquivo de menu criando
     em RES/MENU e o nome do arquivo como o caso menu_contexto*/
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }



    /*nesse metodo temos as funcioes de  itens de menu trabalhanco com switch cases e
    voce seta os casos de acordo com as opcoes que voce passou la no arquiv de contexto menu*/
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.ligar:
                if (pessoaBean.getTelefone() != "") {

                    efetuarLigacao(pessoaBean.getTelefone());
                    Toast.makeText(getApplication(), "Contato selecionado : "
                            + pessoaBean.getTelefone(), Toast.LENGTH_LONG).show();

                } else if (pessoaBean.getTelefone() == "") {
                    //callAlertDialog();
                    Toast.makeText(getApplication(), "Contato vazio : "
                            + pessoaBean.getTelefone(), Toast.LENGTH_LONG).show();

                }


                break;
            case R.id.informar_dados_adcionais:
               detalharDadosPessoa(pessoaBean);
                break;
        }

        return super.onContextItemSelected(item);
    }


    /*esse metodo tem como funcao pegar um numero  como parametro e passar para uma intent
     implicita de ligação o qual é recurso nativo do android*/
    private void efetuarLigacao(String numero_chamar) {
        String numero = numero_chamar;

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: "+numero));
        try {

            startActivity(intent);
        } catch (Exception e) {
            Log.d("erro : ","Não foi possivel efetuar ligação");
            e.printStackTrace();
        }


    }

    private void detalharDadosPessoa(PessoaFisica pessoa){
        /*Toast.makeText(getApplication(), "Enviando para proxima tela  : "
                + pessoaBean.getNome(), Toast.LENGTH_LONG).show();*/

        Intent intent = new Intent(ListarRegistro.this,DetalharPessoa.class);
        intent.putExtra("nome", pessoaBean.getNome());
        intent.putExtra("cpf", pessoaBean.getCpf());
        intent.putExtra("idade", pessoaBean.getIdade());
        intent.putExtra("telefone", pessoaBean.getTelefone());
        intent.putExtra("email", pessoaBean.getEmail());


        startActivity(intent);




    }

}
