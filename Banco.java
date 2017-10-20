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
public class Banco {
    private Endereco add;
    private Conta[] cont;
    private long saldoB,contadorDasContas=0;

    public Endereco getAdd() {
        return add;
    }

    public void setAdd() {
        this.add = add;
    }

    public Conta[] getCont() {
        return cont;
    }

    public void setCont(Conta[] cont) {
        this.cont = cont;
    }
    
    public void abrirConta(){
        
    }

    public Banco() {
        cont = new Conta[10];
        for (int i = 0; i < 10; i++) {
            cont[i] = new Conta();            
        }
        saldoB = 0;
    }

    public long getSaldoB() {
        for (int i = 0; i < contadorDasContas; i++) {
            Conta conta = cont[i];
            
        }
        return saldoB;
    }   
}
