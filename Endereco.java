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
public class Endereco {
    private String rua;
    private int numero;
    private String complemento;
    private long cep;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public Endereco(String rua, int numero, String complemento, long cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public Endereco() {
        this.rua = "dos bobos";
        this.numero = 0;
        this.complemento = " ";
        this.cep = 000000000;
    }

    @Override
    public String toString() {
        return "rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + '}';
    }
    
    
    
}
