package br.feevale;

import java.util.Random;

public class Cliente extends Thread {
    Long tempoDeCorte;
    Estado estado;
    public final Barbearia barbearia;

    public Cliente(Barbearia barbearia) {
        this.barbearia = barbearia;
        this.tempoDeCorte = new Random().nextLong(100L, 1000L);
    }

    public void pagar() throws InterruptedException {
        Thread.sleep(2);
    }

    public void run() {
        try {
            barbearia.entrar(this);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void esperar() throws InterruptedException {
        this.wait();
    }
}
