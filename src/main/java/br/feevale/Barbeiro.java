package br.feevale;

import static br.feevale.Estado.CORTANDO;

public class Barbeiro extends Thread {

    public Estado estado;
    private final Barbearia barbearia;
    private static final MaquinaCartao maquinaCartao = new MaquinaCartao();
    private Cliente cliente;

    private String nomeBarbeiro;

    public Barbeiro(Barbearia barbearia, String nomeBarbeiro) {
        this.barbearia = barbearia;
        estado = Estado.DORMINDO;
        this.nomeBarbeiro = nomeBarbeiro;
        this.start();
    }

    public void run() {
        while (true) {
            try {
                cliente = barbearia.proximoCliente();
                cortar();
            } catch (BarbeariaVaziaException exception) {
                this.estado = Estado.LIVRE;
            }
        }
    }

//    public void cortar(Cliente cliente) {
//        this.cliente = cliente;
//        this.cortar();
//    }

    private void cortar() {
        synchronized (cliente) {
            estado = CORTANDO;
            cliente.estado = CORTANDO;
            System.out.println(">>>>>> Cliente " + cliente.identificador + "foi cortar cabelo com " + nomeBarbeiro);
            try {
//                this.sleep(cliente.tempoDeCorte);
                this.sleep(5000);
                cliente.notificaThread();
            } catch (Exception e) {
                System.out.println("Deu ruim ");
            }
            maquinaCartao.operar((int) (Math.random() * 500));
        }
    }

    public boolean estaLivre() {
        return this.estado.equals(Estado.LIVRE) ||
                this.estado.equals(Estado.DORMINDO);
    }
}
