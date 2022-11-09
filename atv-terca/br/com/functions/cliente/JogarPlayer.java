package br.com.functions.cliente;

import java.util.Scanner;

public class JogarPlayer {

    public int jogar() {
        int numero_jogado_player;

        System.out.print("Digite um número de 0 à 5: ");
        Scanner t = new Scanner(System.in);
        numero_jogado_player = t.nextInt();
        System.out.print("\n\r");

        if (numero_jogado_player < 0 || numero_jogado_player > 5) {
            System.out.println("Número inválido. Aguarde para jogar novamente.\n\r");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException in) {}
            jogar();
        }

        return numero_jogado_player;
    }
}
