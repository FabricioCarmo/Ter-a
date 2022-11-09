
package br.com.functions.servidor;

public class Pontuacao {

    private int pts_player;
    private int pts_pc;

    public Pontuacao() {
    }

    public void darPtsPlayer() {
        this.pts_player++;
    }

    public void darPtsPc() {
        this.pts_pc++;
    }

    public int ptsPlayer() {
        return this.pts_player;
    }

    public int ptsPc() {
        return this.pts_pc;
    }
}
