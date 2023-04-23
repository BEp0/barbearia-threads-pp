package br.feevale;

import java.util.Random;

public class Cliente extends Thread {
    Long tempoDeCorte;
    Estado estado;
    public final SalaDeEspera salaDeEspera;

    public Cliente(SalaDeEspera salaDeEspera) {
        this.salaDeEspera = salaDeEspera;
        this.tempoDeCorte = new Random().nextLong(50L, 500L);
    }

    public void pagar() throws InterruptedException {
        Thread.sleep(2);
    }

    public void run() {
        try {
            salaDeEspera.entrar(this);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void esperar() throws InterruptedException {
        this.wait();
    }
}
