/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbancaria;

/**
 *
 * @author Jairo
 */
public class Pessoa {
    private String nome;
    private int cpf;
    private Endereco ad;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Pessoa(int cpf) {
        this.nome = " ";
        this.cpf = cpf;
    }

    public Pessoa() {
        this.nome = " ";
        this.cpf = 0;
    }

    public Endereco getAd() {
        return ad;
    }

    public void setAd(Endereco ad) {
        this.ad = ad;
    }
    
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ad + '}';
    }
       
}