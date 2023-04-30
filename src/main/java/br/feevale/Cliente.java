package br.feevale;

public class Cliente extends Thread {
    int tempoDeCorte;
    public final Integer identificador;
    public final SalaDeEspera barbearia;

    public Cliente(Barbearia barbearia, Integer identificador) {
        this.barbearia = barbearia;
        this.identificador = identificador;
        this.tempoDeCorte = (int)(Math.random() * 1000);
    }

    public void pagar(MaquinaCartao maquinaCartao) {
        System.out.println("Cliente pagando");
        maquinaCartao.operar(this.tempoDeCorte);
    }

    public void run() {
        synchronized (barbearia) {
            if(barbearia.entrar(this)){
                barbearia.notifyAll();
            }
        }
    }

    public void notificaThread(){
        this.notify();
    }
}
