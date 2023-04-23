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

    public void cortar(Cliente cliente) throws InterruptedException {
        cliente.estado = Estado.CORTANDO;
        this.estado = Estado.CORTANDO;
        this.wait(cliente.tempoDeCorte);
        cliente.wait(cliente.tempoDeCorte);
    }

    public boolean estaLivre(){
        return this.estado.equals(Estado.LIVRE) ||
                this.estado.equals(Estado.DORMINDO);
    }

    public void receber(Cliente cliente){
//        pos.operar();
    }
    public void dormir(){

    }
}
