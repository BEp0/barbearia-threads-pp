package br.feevale;

public class Cliente extends Thread {
    int tempoDeCorte;
    Estado estado;
    public final Barbearia barbearia;
    public final Integer identificador;

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
        try {
            barbearia.entrar(this);
            this.wait();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void notificaThread(){
        this.notify();
    }
}
