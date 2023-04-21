package br.feevale;

import java.util.List;

public class Barbeiro extends Thread {

    public Estado estado;
    private final Cadeira cadeira;
    public static final MaquinaCartao MAQUINA_CARTAO = new MaquinaCartao();

    public Barbeiro() {
        this.cadeira = new Cadeira(this);
        estado = Estado.DORMINDO;
        this.start();
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    public void cortar(Cliente cliente) throws InterruptedException {
        Thread.sleep(2000);
        cliente.estado = Estado.CORTANDO;
        this.estado = Estado.CORTANDO;
    }
    public void receber(Cliente cliente){
//        pos.operar();
    }
    public void dormir(){

    }
}
