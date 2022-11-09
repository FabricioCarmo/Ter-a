

package br.com.functions.cliente;

import java.util.Scanner;

public class MenuPrincipal {
    private int opc_escolhida = -1;
    private String msg_escolha = "Escolha uma das opções abaixo:";

    public int menu() {

        do {
            System.out.println(this.msg_escolha);
            System.out.println("1- Par");
            System.out.println("2- Ímpar");
            System.out.println("0- Sair\n\r");

            System.out.print("Digite uma opção: ");
            Scanner t = new Scanner(System.in);
            this.opc_escolhida = t.nextInt();

            switch (this.opc_escolhida) {
                case 1:
                    return this.opc_escolhida;
                case 2:
                    return this.opc_escolhida;
                case 0:
                    return this.opc_escolhida;
                default:
                    System.out.println("Opção inválida. Aguarde para escolher novamente.\n\r");
                    try {
                        Thread.sleep(2 * 1000);
                    } catch (InterruptedException e) {}
                    this.msg_escolha = "Escolha novamente uma das opções abaixo:";
                    break;
            }

        } while (this.opc_escolhida > 2);
        return 0;
    }
}
