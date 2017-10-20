/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbancaria;

import java.util.Scanner;

/**
 *
 * @author 201604940016
 */
public class Principal {
    public static void main(String[] args) {
        Scanner pega = new Scanner(System.in);
        Conta cont = new Conta();
        String str;
        int n,k=0;
        long l;
        
        System.out.println("Diga se você é: \n1 - Banco \n2 - cliente");
        n = pega.nextInt();
        
        System.out.println("Caro cliente, qual o seu nome?");
        str = pega.nextLine();
        cont.getTitular().setNome(str);
        
        System.out.println(cont.getTitular().getNome()+", qual sua rua?");
        str = pega.nextLine();
        cont.getTitular().getAd().setRua(str);
        
        System.out.println(cont.getTitular().getNome()+", qual o complemento?");
        str = pega.nextLine();
        cont.getTitular().getAd().setComplemento(str);
        
        System.out.println(cont.getTitular().getNome()+", qual o número?");
        n = pega.nextInt();
        cont.getTitular().getAd().setNumero(n);
        
        System.out.println(cont.getTitular().getNome()+", qual o CEP?");
        l = pega.nextLong();
        cont.getTitular().getAd().setCep(l);
        
        System.out.println(cont.getTitular().getNome()+", qual seu CPF? (5 dig)");
        n = pega.nextInt();
        cont.getTitular().setCpf(n);
        
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
                    str = cont.extrat();
                    System.out.println(str);
                    break;
                case 4: 
                    k=1;
                    break;
            }
            
        }while(k!=1);
        
    }
}
