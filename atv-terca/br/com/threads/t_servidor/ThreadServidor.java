
package br.com.threads.t_servidor;

import br.com.functions.servidor.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadServidor extends Thread {

    private final int porta;

    private int aux_pts_player;
    private int aux_pts_pc;

    public ThreadServidor(int porta) {
        this.porta = porta;
    }
    @Override
    public void run() {
        try {

            System.out.println(
                    "O servidor está carregando o jogo...");
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {}

            System.out.println(
                    "Carregamento concluído.\r\n");
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {}

            ServerSocket server_socket = new ServerSocket(
                    this.porta);
            System.out.println(
                    "Servidor rodando na porta " + this.porta + "\n\r");
            System.out.println(
                    "Aguardando conexão...");


            while(true) {

                Socket cliente_socket = server_socket.accept();
                System.out.println(
                        "Nova conexão identificada.\n\r");



                String msg_escolha_par_impar;
                int escolha_par_impar = -1;
                int opc_jogar_novamente = -1;



                int flag_par_impar = -1;


                Pontuacao pontos = new Pontuacao();



                Scanner s = new Scanner(
                        cliente_socket.getInputStream());

                do {


                        String msg_entrada_player = "Jogador1 entrou no jogo.\n\r";
                        System.out.println(msg_entrada_player);


                     if (flag_par_impar < 1) {
                        escolha_par_impar = s.nextInt();

                        VerificarEscolha ve = new VerificarEscolha(
                                escolha_par_impar);
                        msg_escolha_par_impar = ve.verificarParImpar();
                        System.out.println(msg_escolha_par_impar);
                        flag_par_impar = 1;
                    }
                    else {
                        if ( flag_par_impar == 1) {
                            

                            int jogada_player = s.nextInt();
                            System.out.println("Jogador1 jogou!");
                            try {
                                Thread.sleep(2 * 1000);
                            } catch (InterruptedException in) {}


                            JogarPc jpc = new JogarPc();
                            int jogada_pc = jpc.jogar();
                            System.out.println("PC jogo!\n\r");
                            try {
                                Thread.sleep(2 * 1000);
                            } catch (InterruptedException in) {}


                            System.out.println("Calculando o resultado da jogada...");
                            int soma_numeros_jogados = jogada_player + jogada_pc;
                            int resto = soma_numeros_jogados % 2;
                            try {
                                Thread.sleep(2 * 1000);
                            } catch (InterruptedException in) {}

                            System.out.println("Resultado calculado com sucesso.\n\r");
                            try {
                                Thread.sleep(2 * 1000);
                            } catch (InterruptedException in) {}


                            DadosPartida dj = new DadosPartida(
                                    jogada_player, jogada_pc);

                            dj.imprimirJogadaAtual();
                            try {
                                Thread.sleep(2 * 1000);
                            } catch (InterruptedException in) {}


                            ResultadoPartida rp = new ResultadoPartida(resto, escolha_par_impar);

                            rp.imprimirResultadoGeral(pontos);
                            this.aux_pts_player = pontos.ptsPlayer();
                            this.aux_pts_pc = pontos.ptsPc();

                            try {
                                Thread.sleep(2 * 1000);
                            } catch (InterruptedException in) {}


                            PlacarGeral pg = new PlacarGeral(this.aux_pts_player, this.aux_pts_pc);

                            pg.placar();


                            opc_jogar_novamente = s.nextInt();
                            if (opc_jogar_novamente == 1) {
                                flag_par_impar = -1;
                            }
                        }
                    }

                } while (escolha_par_impar != 0 && opc_jogar_novamente != 2);

                System.out.println("Jogador1 saiu do jogo");
                cliente_socket.close();
            }
        } catch (IOException ex) {}
    }
}
