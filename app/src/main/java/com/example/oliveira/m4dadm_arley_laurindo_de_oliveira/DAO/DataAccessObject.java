package com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.Modelo.PessoaFisica;

import java.util.ArrayList;

/**
 * Created by Oliveira on 05/12/2016.
 */
//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Arley Laurindo de Oliveira
//Esta classe tem função de criar operacoes de banco de dados, com apenas 2 metodos inserir e listar
//******************************************************

public class DataAccessObject  extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "pessoa_fisica.db";

    private static final String TABLE_PESSOAS_FISICA = "pessoa";

    private static final int DATABASE_VERSION = 1;


    // Criando as TAGS para imprimir o Log de cada operação
    private static final String TAG_D = "DELETAR REGISTRO";
    private static final String TAG_U = "UPDATE DATA";
    private static final String TAG_I = "INSERIR REGISTRO";
    private static final String TAG_S = "SELECIONAR REGISTROS";

    public DataAccessObject(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //comandos e operacoes sql criando tabela
    public void onCreate(SQLiteDatabase db) {

        Log.d("Teste ","criando Banco");

        String sql = "CREATE TABLE " + TABLE_PESSOAS_FISICA
                + "(id INTEGER PRIMARY KEY, " +
                "nome TEXT, " +
                "cpf TEXT, " +
                "idade TEXT, " +
                "telefone TEXT, " +
                "email TEXT);";

        db.execSQL(sql);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABLE_PESSOAS_FISICA;

        db.execSQL(sql);

        onCreate(db);

    }

    //metodo de busca os dados de acordo com a tabela e receber  o resultado jogando dentro de uma lista
    public ArrayList<PessoaFisica> CarregarPessoasDoBanco() {

        // Passo 01 - Criar o arraylist de PessoaFisica
        ArrayList<PessoaFisica> listaPessoasFisicas = new ArrayList<PessoaFisica>();

        // Passo 02 - Criar o SQL para selecionar os registros do banco
        String sql = "SELECT * FROM " + TABLE_PESSOAS_FISICA;

        // Passo 03 - Recuperar os registros
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        // Passo 04 - Percorrer o cursor e salvar os registros de PessoaFisica
        while (cursor.moveToNext()) {
            // Criação da instancia de PessoaFisica utilizando informações
            // provenientes da base de dados
            PessoaFisica pessoaFisica = new PessoaFisica();

            // Construindo o objeto a partir dos registros da base de dados
            pessoaFisica.setId(cursor.getInt(0));
            pessoaFisica.setNome(cursor.getString(1));
            pessoaFisica.setCpf(cursor.getString(2));
            pessoaFisica.setIdade(cursor.getString(3));
            pessoaFisica.setTelefone(cursor.getString(4));
            pessoaFisica.setEmail(cursor.getString(5));




            listaPessoasFisicas.add(pessoaFisica);
            Log.i(TAG_S, "O registro de id: "+pessoaFisica.getNome()+" foi selecionado");
        }

        return listaPessoasFisicas;
    }

    /*esse método tem como função receber os dados de um objeto e em seguida
     jogar dentro da função a nivel de banco o qual persiste os dados.*/
    public void inserirPessoa(PessoaFisica bean){

        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", bean.getNome());
        contentValues.put("cpf ", bean.getCpf());
        contentValues.put("idade", bean.getIdade());
        contentValues.put("telefone", bean.getTelefone());
        contentValues.put("email", bean.getEmail());




        getWritableDatabase().insert(TABLE_PESSOAS_FISICA, null, contentValues);

    }

}
