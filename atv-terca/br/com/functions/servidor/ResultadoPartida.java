package br.com.functions.servidor;

public class ResultadoPartida {
    private int restoDivisao;
    private int escolhaPlayer;


    public ResultadoPartida(
            int restoDivisao, int escolhaPlayer) {
        this.restoDivisao = restoDivisao;
        this.escolhaPlayer = escolhaPlayer;
    }

    public void imprimirResultadoGeral(Pontuacao pontos) {

       if (this.restoDivisao > 0) {
           System.out.println(
                   "O resultado final da partida foi ÍMPAR!");
           if (this.escolhaPlayer > 1) {
               System.out.println(
                       "Parabéns, Jogador1 ganhou!\n\r");

               pontos.darPtsPlayer();
           }
           else {
               System.out.println(
                       "Sinto muito, Jogador1 perdeu...\n\r");

               pontos.darPtsPc();
           }
       }
       else {
           System.out.println(
                   "O resultado final da partida foi PAR!");
           if (this.escolhaPlayer < 2) {
               System.out.println(
                       "Parabéns,  você ganhou!\n\r");

               pontos.darPtsPlayer();
           }
           else {
               System.out.println(
                       "Sinto muito, Jogador1 perdeu...\n\r");

               pontos.darPtsPc();
           }
       }
    }
}
