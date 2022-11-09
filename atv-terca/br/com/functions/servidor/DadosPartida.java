

package br.com.functions.servidor;
public class DadosPartida {
    private int numeroJogadoPlayer;
    private int numeroJogadoPc;


    public DadosPartida(int numeroJogadoPlayer, int numeroJogadoPc) {
        this.numeroJogadoPlayer = numeroJogadoPlayer;
        this.numeroJogadoPc = numeroJogadoPc;
    }

    public void imprimirJogadaAtual() {
        System.out.println("*** Dados da Jogada ***");
        System.out.println(" jogou o número " + this.numeroJogadoPlayer + ".");
        System.out.println("PC jogou o número " + this.numeroJogadoPc + "\n\r");
    }
}
