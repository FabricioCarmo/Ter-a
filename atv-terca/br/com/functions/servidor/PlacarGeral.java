package br.com.functions.servidor;

public class PlacarGeral {


    private int pontos_player;
    private int pontos_pc;

    public PlacarGeral(
           int pontos_player, int pontos_pc) {


        this.pontos_player = pontos_player;
        this.pontos_pc = pontos_pc;
    }
    public void placar() {
        System.out.println("*** Placar ***");

        if (this.pontos_player == 0 || this.pontos_player > 1) {
            System.out.println("Jogador1 = " + this.pontos_player + " pontos");
        }
        else {
            System.out.println("Jogador1 = " + this.pontos_player + " ponto");
        }

        if (this.pontos_pc == 0 || this.pontos_pc > 1)  {
            System.out.println("PC = " + this.pontos_pc + " pontos\n\r");
        }
        else {
            System.out.println("PC = " + this.pontos_pc + " ponto\n\r");
        }
    }
}
