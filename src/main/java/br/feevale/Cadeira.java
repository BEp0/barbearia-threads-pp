package br.feevale;

import static br.feevale.EstadoBarbeiro.LIVRE;

public class Cadeira extends Thread{
    public Barbeiro barbeiro;
    public Cliente cliente;
//    EstadoBarbeiro estado;


    @Override
    public synchronized void run() {
        while(true){
            try {
                this.wait();
                barbeiro.estado = EstadoBarbeiro.CORTANDO;
                Thread.sleep(cliente.tempoDeCorte);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            barbeiro.estado = EstadoBarbeiro.LIVRE;
        }
    }

    public synchronized void liberarCorte(){
        this.notify();
    }

    @Override
    public void start() {
        super.start();
        barbeiro.estado = LIVRE;
    }
}
