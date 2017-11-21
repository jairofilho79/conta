package cbancaria;

import java.util.Date;

public class OpConta {
   private String operacao;
   private int valor;
   private Date data;

    public void faz(String operacao, int valor) {
        this.operacao = operacao;
        this.valor = valor;
        this.data = new Date();
    }

    @Override
    public String toString() {
        return "--------------------\nOpConta\n" + "Operação = " + operacao + "\n valor = " + valor + "\n data = " + data + "\n";
    }
    
    
   
}
