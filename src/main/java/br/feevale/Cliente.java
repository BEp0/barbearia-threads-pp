package br.feevale;

public class Cliente extends Thread {
    int tempoDeCorte;
    Estado estado;
    public final Barbearia barbearia;

    public Cliente(Barbearia barbearia) {
        this.barbearia = barbearia;
        this.tempoDeCorte = (int)(Math.random() * 1000);
    }

    public void pagar(MaquinaCartao maquinaCartao) {
        System.out.println("Cliente pagando");
        maquinaCartao.operar(this.tempoDeCorte);
    }

    public void run() {
        try {
            barbearia.entrar(this);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
