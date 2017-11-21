/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbancaria;

import java.util.Date;
/**
 *
 * @author Jairo
 */
public class Conta {

    private int numConta =0;
    private Pessoa titular;
    private int saldo,contadorDoExtrato=0;
    private Date criacao;
    protected OpConta[] extrato;
    private OpConta novoExtrato;

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date data) {
        this.criacao = data;
    }

    public int getContadorDoExtrato() {
        return contadorDoExtrato;
    }

    public void setContadorDoExtrato(int contadorDoExtrato) {
        this.contadorDoExtrato = contadorDoExtrato;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public OpConta[] getExtrato() {
        return extrato;
    }

    public void setExtrato(OpConta[] extrato) {
        this.extrato = extrato;
    }
    
    public String extrat(){
        String str = "";
        for (int i = 0; i <this.getContadorDoExtrato(); i++) {    
        str += extrato[i].toString();
        }
        return str;
    }    
    
    

    public Conta() {
        this.extrato = new OpConta[10];
        for (int i = 0; i < 10; i++) {
            extrato[i] = new OpConta();            
        }
        this.saldo = 0;
        this.titular = new Pessoa();
        this.titular.setCpf(0);
        this.criacao = new Date();
    }
    
    public void depositar(int valor){
        if(this.getContadorDoExtrato()==9){
            System.out.println("Você chegou ao limite de operações em sua conta.\nOperação mal sucedida.");
        }
        else{
            this.setSaldo(this.getSaldo()+valor);
            System.out.println(this.titular.getNome()+", você depositou "+valor+" na sua conta. Agora com o total de "+this.getSaldo()+".");
            this.extrato[this.getContadorDoExtrato()].faz("Depositar", valor);
            this.setContadorDoExtrato(this.getContadorDoExtrato()+1);  
        }

    }
    
    public void sacar(int valor){
        if(valor>this.getSaldo()){
            System.out.println("Só pra ver");
            System.out.println("Saldo insuficiente.\nOperação mal sucedida.");
        }
        else{
            if(this.getContadorDoExtrato()==9){
            System.out.println("Você chegou ao limite de operações em sua conta.\nOperação mal sucedida.");
            }
            else{
                this.setSaldo(this.getSaldo()-valor);
                System.out.println(this.titular.getNome()+", você sacou "+valor+" da sua conta. Agora com o total de "+this.getSaldo()+".");
                this.extrato[this.getContadorDoExtrato()].faz("Sacar", valor);               
                this.setContadorDoExtrato(this.getContadorDoExtrato()+1);  
            }
         
        }

    }    
}