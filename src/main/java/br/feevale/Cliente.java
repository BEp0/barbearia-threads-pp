package br.feevale;

import javax.swing.plaf.TableHeaderUI;
import java.math.BigDecimal;

public class Cliente extends Thread{
    Long tempoDeCorte;
    Estado estado;
    public final SalaDeEspera salaDeEspera;

    public Cliente(SalaDeEspera salaDeEspera){
        this.salaDeEspera = salaDeEspera;
    }

    public void pagar() throws InterruptedException {
        Thread.sleep(2);
    }

    public void run(){
        salaDeEspera.entrar(this);
    }

    public void esperar() throws InterruptedException {
        this.wait();
    }
}
