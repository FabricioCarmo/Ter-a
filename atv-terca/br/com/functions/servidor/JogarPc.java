
package br.com.functions.servidor;

import java.util.Random;

public class JogarPc {
    public int jogar() {
        Random rand = new Random();
        int n_jogado_pc = rand.nextInt(6);

        return n_jogado_pc;
    }
}
