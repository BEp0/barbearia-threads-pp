package br.feevale;

import static br.feevale.EstadoBarbeiro.LIVRE;

public class Barbeiro extends Thread {

    public EstadoBarbeiro estado;
    public String nome;

    public Barbeiro(String nome) {
        this.nome = nome;
    }

    @Override
    public synchronized void start() {
        super.start();
        estado = LIVRE;
    }
}
