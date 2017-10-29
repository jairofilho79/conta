/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdvelha;

import java.util.Scanner;


public class Jdvelha {
    Scanner pega = new Scanner(System.in);
    private String[][] tabuleiro = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
    private int rodada;
    private int escolha;
    private int vez;
    private String jogador1,jogador2;

    public Jdvelha() {
        this.jogador1 = " ";
        this.jogador2 = " ";
    }
    
    
    public static void main(String[] args) {
        Scanner pega = new Scanner(System.in);
        Jdvelha jogo = new Jdvelha();
        boolean resp=true;
        boolean vencedor=false;
        
        System.out.print("Jogador 01\nInsira seu nome: ");
        jogo.jogador1 = pega.nextLine();
        System.out.print("Jogador 02\nInsira seu nome: ");
        jogo.jogador2 = pega.nextLine();
        
        
        do{
            //inicializa tudo para que possa ser repetido o jogo quantas vezes quiser.
            jogo.vez = 1;
            jogo.rodada=0;
            vencedor = false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String str = Integer.toString((3*i)+(j+1));
                    jogo.tabuleiro[i][j]= str;
                }
            }
            do{
                //mostra a tabela disponível e já utilizada
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(jogo.tabuleiro[i][j]+" ");                    
                    }
                    System.out.println("");
                }
                //pede a opção do usuário
                if(jogo.vez==1){
                    System.out.print(jogo.jogador1+", escolha uma opção: ");
                }
                else
                    System.out.print(jogo.jogador2+", escolha uma opção: ");
                jogo.escolha = pega.nextInt();
                //garante que a escolha será válida
                while(jogo.escolha>0&&jogo.escolha<10){
                    System.out.println("Posição inválida. Digite novamente");
                    jogo.escolha = pega.nextInt();
                }
                //Muda para a próxima rodada. Isso ocorre aqui porque é necessário no método jogada.
                jogo.rodada++;
                //Chama a jogada
                vencedor= jogo.jogada(jogo.tabuleiro, jogo.vez, jogo.rodada,jogo.escolha,vencedor);
                //Muda a vez para o próximo jogador
                if(jogo.vez==1)
                    jogo.vez++;
                else
                    jogo.vez--;
                //Repete até que haja um vencedor ou todas as posições forem preenchidas.
            }while(!vencedor&&jogo.rodada<9);
                //Mostra a tabela final.
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(jogo.tabuleiro[i][j]+" ");                    
                    }
                    System.out.println("");
                }
            //Quando o jogo é finalizado, ele muda a vez para outro jogador, logo isso tem que ser desfeito aqui.    
            if(jogo.vez==1)
                jogo.vez++;
            else
                jogo.vez--;
            //Aqui é visto se houve vitória ou empate
            if(vencedor){
                //Aqui se vê de quem foi a vitória
                if(jogo.vez==1){
                    System.out.println("---------VITÓRIA---------");
                    System.out.println("Parabéns, "+jogo.jogador1+". Você venceu!");
                }    
                else{
                   System.out.println("----------DERROTA---------");
                   System.out.println("Parabéns, "+jogo.jogador2+". Você venceu!");
                }           
            }
            else{
                System.out.println("---------EMPATE----------");
                System.out.println("Deu velha.");
            }
            //Se quer jogar novamente + a garantia de S ou N, agora com formato minúsculo também
            System.out.println("\nDeseja jogar novamente? [S/N]");
                String conf = pega.next();
                int b=0;
                do{
                    switch(conf){
                        case "n":
                        case "N":
                            System.out.println("\nFoi um prazer! Até a próxima!");
                            resp=!resp;
                            b=1;
                            break;
                        case "s":    
                        case "S":
                            System.out.println("\nOk, então vamos continuar!\n");
                            b=1;
                            break;                    
                        default:
                            System.out.println("Caractere inválido, revalide sua resposta.");
                            conf = pega.next();
                            break;
                    }
                }while(b!=1);
                //Se o usuário decidir continuar, ele tem a opção de mudar de adversário. Foi utilizado o equals porque sem ele estava dando problema de reconhecimento.
                if("s".equals(conf)||"S".equals(conf)){
                    System.out.println("\nDeseja mudar seu adversário? [S/N]");
                    conf = pega.nextLine();
                    conf = pega.nextLine();
                    b=0;
                    do{
                        switch(conf){
                            case "n":
                            case "N":
                                System.out.println("\nOpa... revanche... essa vai ser legal!");
                                b=1;
                                break;
                            case "s":    
                            case "S":
                                System.out.print("Jogador 02\nInsira seu nome: ");
                                jogo.jogador2 = pega.nextLine();
                                b=1;
                                break;                    
                            default:
                                System.out.println("Caractere inválido, revalide sua resposta.");
                                conf = pega.next();
                                break;
                        }
                    }while(b!=1);    
                }
        }while(resp);
    }
    public boolean jogada(String[][] tabuleiro, int vez,int rodada,int escolha,boolean vencedor){
        int i=0,j=0,t=0;
        //Aqui o código sabe qual é a posição da matriz a partir do número dado.
        do{
        switch(escolha){
            case 2:
                j=1;
                break;
            case 3:
                j=2;
                break;
            case 4:
                i=1;
                break;
            case 5:
                i=j=1;
                break;
            case 6:
                i=1;
                j=2;
                break;
            case 7:
                i=2;
                break;
            case 8:
                i=2;
                j=1;
                break;
            case 9:
                i=j=2;
                break;            
        }
        //Aqui o código identifica quem jogou. Se for o Usuário, X, se for o adversário, O. Se a posição já está marcada, ele pede nova posição.
        if(tabuleiro[i][j]!= "X"&&tabuleiro[i][j]!= "O"){
            if(vez==1)
                tabuleiro[i][j] = "X";
            else
                tabuleiro[i][j] = "O";
            t=1;
        }
        else{
            System.out.println("Posição já marcada, escolha outra.");
            escolha = pega.nextInt();
        }
        }while(t!=1);
        //Uma otimização. Só poderá haver vitória a partir da 5 rodada, logo só há teste a partir desse número.
        if(rodada>4)
            vencedor = vitoria(tabuleiro);
        return vencedor;
    }
    public boolean vitoria(String[][] tabuleiro){
        //Aqui ele procura se há uma das 8 jogadas possíveis no jogo. 
            //jogada 1
            if(tabuleiro[0][0]==tabuleiro[0][1])
                if(tabuleiro[0][0]==tabuleiro[0][2])
                    return true;
            //jogada 2        
            if(tabuleiro[1][0]==tabuleiro[1][1])
                if(tabuleiro[1][0]==tabuleiro[1][2])
                    return true;
            //jogada 3
            if(tabuleiro[2][0]==tabuleiro[2][1])
                if(tabuleiro[2][0]==tabuleiro[2][2])
                    return true;
            //jogada 4
            if(tabuleiro[0][0]==tabuleiro[1][0])
                if(tabuleiro[0][0]==tabuleiro[2][0])
                    return true;
            //jogada 5
            if(tabuleiro[0][1]==tabuleiro[1][1])
                if(tabuleiro[0][1]==tabuleiro[2][1])
                    return true;
            //jogada 6
            if(tabuleiro[0][2]==tabuleiro[1][2])
                if(tabuleiro[0][2]==tabuleiro[2][2])
                    return true;
            //jogada 7
            if(tabuleiro[0][0]==tabuleiro[1][1])
                if(tabuleiro[0][0]==tabuleiro[2][2])
                    return true;
            //jogada 8
            if(tabuleiro[0][2]==tabuleiro[1][1])
                if(tabuleiro[0][2]==tabuleiro[2][0])
                    return true;            
            return false;    
    }    
}
