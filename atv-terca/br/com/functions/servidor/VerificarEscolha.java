
package br.com.functions.servidor;

public class VerificarEscolha {

    private int escolha;


    public VerificarEscolha(int escolha) {
        this.escolha = escolha;
    }
    public String verificarParImpar() {
        String msg_escolha;
        
        if (this.escolha > 1) {
            msg_escolha =  "Jogador1 escolheu ímpar e o PC par.\n\r";
        }
        else {
            msg_escolha = "Jogador1 escolheu par e o PC ímpar.\n\r";
        }
        return msg_escolha;
    }
}
