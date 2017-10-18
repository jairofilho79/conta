/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Jairo
 */
public class Conta {

    private Pessoa titular;
    private int saldo,contadorDoExtrato=0;
    private Date criacao;
    private OpConta[] extrato;
    private OpConta   novoExtrato;

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
    
        
    public static void main(String[] args) {
        Scanner pega = new Scanner(System.in);
        Conta cont = new Conta();
        String str;
        int n,k=0;
        
        System.out.println("Caro cliente, qual o seu nome?");
        str = pega.nextLine();
        cont.titular.setNome(str);
        
        System.out.println(cont.titular.getNome()+", qual seu CPF? (5 dig)");
        n = pega.nextInt();
        cont.titular.setCpf(n);
        
        do {
            System.out.println("O que deseja fazer?\n1 - SACAR\n2 - DEPOSITAR\n3 - VER EXTRATO\n4 - SAIR");
            n = pega.nextInt();
            switch(n){
                case 1: 
                    System.out.println("Qual o valor?");
                    n = pega.nextInt();
                    cont.sacar(n);
                    break;
                case 2:
                    System.out.println("Qual o valor?");
                    n = pega.nextInt();
                    cont.depositar(n);
                    break;
                case 3:
                    for (int i = 0; i <cont.getContadorDoExtrato(); i++) {
                        System.out.println(cont.extrato[i].toString());                        
                    }
                    break;
                case 4: 
                    k=1;
                    break;
            }
            
        }while(k!=1);
        
    }
    
}
