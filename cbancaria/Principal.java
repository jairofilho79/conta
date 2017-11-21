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
        ContaEspecial espe = new ContaEspecial(100); 
        int k=0;
        System.out.println("Sua conta é \n1 - Comum\n2 - Especial");
        switch(pega.nextInt()){
            case 1:
              do {
            System.out.println("O que deseja fazer?\n1 - SACAR\n2 - DEPOSITAR\n3 - VER EXTRATO\n4 - SAIR");
            switch(pega.nextInt()){
                case 1: 
                    System.out.println("Qual o valor?");
                    cont.sacar(pega.nextInt());
                    break;
                case 2:
                    System.out.println("Qual o valor?");
                    cont.depositar(pega.nextInt());
                    break;
                case 3:
                    System.out.println(cont.extrat());
                    break;
                case 4: 
                    k=1;
                    break;
            }
            
        }while(k!=1);  
                break;
            case 2:
                do {
            System.out.println("O que deseja fazer?\n1 - SACAR\n2 - DEPOSITAR\n3 - VER EXTRATO\n4 - SAIR");
            switch(pega.nextInt()){
                case 1: 
                    System.out.println("Qual o valor?");
                    espe.sacar(pega.nextInt());
                    break;
                case 2:
                    System.out.println("Qual o valor?");
                    espe.depositar(pega.nextInt());
                    break;
                case 3:
                    System.out.println(espe.extrat());
                    break;
                case 4: 
                    k=1;
                    break;
            }
            
        }while(k!=1);
                break;
        }
        
        
    }
}
