package com.example.oliveira.m4dadm_arley_laurindo_de_oliveira.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Oliveira on 05/12/2016.
 */

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Arley Laurindo de Oliveira
//Esta classe tem como objetivo servir de modelo para instancia uma pessoa no momento de execução ,
//estou utilizando parcable, como já estudei sou acostumado com esse procedimento.
//******************************************************

public class PessoaFisica {


    private int id;
    private String nome;
    private String cpf;
    private String idade;
    private String telefone;
    private String email;


    public PessoaFisica(){}

    public PessoaFisica (Parcel in)  {readFromParcelable(in); }

    private void readFromParcelable (Parcel in){
        nome = in.readString();
        cpf= in.readString();
        idade= in.readString();
        telefone= in.readString();
        email= in.readString();


    }

    public void writeToParcel (Parcel out, int flags){

        out.writeString(nome);
        out.writeString(cpf);
        out.writeString(idade);
        out.writeString(telefone);
        out.writeString(email);


    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        public PessoaFisica createFromParcel(Parcel in){
            return new PessoaFisica(in);
        }

        public PessoaFisica [] newArray(int size){
            return new PessoaFisica[size];
        }
    };

    public String toString(){
        return "Nome: " + this.nome ;
    }

    public int describeContents(){
        //TODO Não é necessário implementar agora.
        return 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
