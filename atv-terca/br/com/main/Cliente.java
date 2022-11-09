

package br.com.main;

import br.com.threads.t_cliente.ThreadCliente;

public class Cliente {

    void cliente() {
        int porta = 4400;
        ThreadCliente tc = new ThreadCliente(porta);
        tc.start();
    }

    public static void main(String[] args) {
        Cliente cli = new Cliente();
        cli.cliente();
    }
}
