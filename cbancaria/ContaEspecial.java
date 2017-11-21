/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbancaria;

/**
 *
 * @author 201604940016
 */
public class ContaEspecial extends Conta {
    private int limite;
    public ContaEspecial() { 
        this(0); 
    }
    public ContaEspecial(int limite) {
        super();
        this.limite = limite; 
    }
    
    protected boolean autoriza (int valor){
        if(getSaldo()+limite>=valor)
            return true;
        return false;
    }
    
    @Override
    public void sacar(int valor){
        if(valor>this.getSaldo()){
            if(autoriza(valor)){
                System.out.println("Você sacou "+valor+" da sua conta, sendo "+(valor-this.getSaldo())+" do seu limite. Agora seu saldo é 0 e "+(limite-(valor-this.getSaldo()))+" é o saldo restando do seu limite.");
                limite = limite-(valor-this.getSaldo());
                this.setSaldo(getSaldo()-valor);
            }
            else{
                System.out.println("Saldo insuficiente.\nOperação mal sucedida.\n");        
            }
        }    
        else{
            if(this.getContadorDoExtrato()==9){
            System.out.println("Você chegou ao limite de operações em sua conta.\nOperação mal sucedida.");
            }
            else{
                this.setSaldo(this.getSaldo()-valor);
                System.out.println(this.getTitular().getNome()+", você sacou "+valor+" da sua conta. Agora com o total de "+this.getSaldo()+".");
                this.extrato[this.getContadorDoExtrato()].faz("Sacar", valor);               
                this.setContadorDoExtrato(this.getContadorDoExtrato()+1);  
            }
         
        }

    }
}
