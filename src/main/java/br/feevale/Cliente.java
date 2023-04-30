package br.feevale;

public class Cliente extends Thread {

    int tempoDeCorte;
    public final Integer identificador;
    public final SalaDeEspera barbearia;

    public Cliente(SalaDeEspera barbearia, Integer identificador) {
        System.out.println("\n>>>> Crei um cliente novo!");
        this.barbearia = barbearia;
        this.identificador = identificador;
        this.tempoDeCorte = (int)(Math.random() * 3500);
        this.start();
    }

    public void run() {
        synchronized (barbearia) {
            if(barbearia.entrar(this)){
                barbearia.notifyAll();
            }
        }
    }
}
