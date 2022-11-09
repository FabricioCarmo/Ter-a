package br.com.threads.t_cliente;

import br.com.functions.cliente.MenuPrincipal;
import br.com.functions.cliente.JogarPlayer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ThreadCliente extends Thread {
    private final int porta;

    public ThreadCliente(int porta) {
        this.porta = porta;
    }
    @Override
    public void run() {
        try {
            System.out.println("Aguarde enquando o jogo é carregado...");
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException in) {}

            System.out.println("Jogo carregado com sucesso.\n\r");
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException in) {}


            System.out.println("***** Bem Vindo ao Jogo do Par ou Ímpar *****\n\r");
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException in) {}

            Socket cliente_sock = new Socket("127.0.0.1", this.porta);

            Scanner t = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente_sock.getOutputStream());

            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException in) {}

            int opc_jogar_nov;
            int n_rodada = 0;

            do {

                n_rodada++;
                System.out.println("\n\r*** RODADA " + n_rodada + " ***\n\r");

                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException in) {}

                MenuPrincipal mp = new MenuPrincipal();
                int escolha_menu = mp.menu();
                if (escolha_menu > 1) {
                    System.out.println("Você escolheu ímpar.\n\r");
                }
                else if (escolha_menu == 1) {
                    System.out.println("Você escolheu par.\n\r");
                }
                else {
                    System.out.println("Você escolheu fechar o jogo.\n\r");
                    try {
                        Thread.sleep(1 * 1000);
                    } catch (InterruptedException in) {}
                    System.out.println("Aguarde enquanto finalizamos todos os módulos...");
                    try {
                        Thread.sleep(3 * 1000);
                    } catch (InterruptedException in) {}
                    System.out.println("Jogo finalizado com sucesso.\n\r");
                    System.exit(0);
                }
                saida.println(escolha_menu);

                JogarPlayer jpl = new JogarPlayer();
                int jogada_player = jpl.jogar();
                System.out.println("Você jogou " + jogada_player);
                saida.println(jogada_player);

                try {
                    Thread.sleep(12 * 1000);
                } catch (InterruptedException in) {}

                /* menu jogar novamente */

                System.out.println("\nConfira no server o resultado da partida\n");
                System.out.println("Você deseja jogar novamente?");
                System.out.println("1- Sim");
                System.out.println("2- Não\n\r");
                System.out.print("Digite uma opção: ");
                opc_jogar_nov = t.nextInt();

                if (opc_jogar_nov == 2) {
                    System.out.println("Você escolheu não jogar novamente.\n\r");
                    try {
                        Thread.sleep(2 * 1000);
                    } catch (InterruptedException in) {}
                    System.out.println("Aguarde enquanto finalizamos todos os módulos...");
                    try {
                        Thread.sleep(2 * 1000);
                    } catch (InterruptedException in) {}
                    System.out.println("Jogo finalizado com sucesso.");
                    try {
                        Thread.sleep(2 * 1000);
                    } catch (InterruptedException in) {}

                    saida.println(opc_jogar_nov);
                }

                saida.println(opc_jogar_nov);

            } while (opc_jogar_nov != 2);

            saida.close();
            t.close();
            cliente_sock.close();
        }
        catch (IOException ex) {}
    }
}