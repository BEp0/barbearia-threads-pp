package br.feevale;

import static br.feevale.Estado.CORTANDO;

public class Barbeiro extends Thread {

    private String nomeBarbeiro;
    private final SalaDeEspera barbearia;
    private Cliente cliente;

    private String nomeBarbeiro;

    public Barbeiro(Barbearia barbearia, String nomeBarbeiro) {
        this.barbearia = barbearia;
        this.nomeBarbeiro = nomeBarbeiro;
        this.start();
    }

    private void realizarCorteDeCabelo() {
        try {
            this.sleep(cliente.tempoDeCorte);
        } catch (InterruptedException e) {
            System.out.printf("Erro ao tentar cortar o cabelo");
        }
    }

    private void receberCliente() {
        synchronized (barbearia){
            if(!barbearia.sofa.isEmpty()){
                cliente = barbearia.sofa.get(0);
                barbearia.sofa.remove(0);
                if(!barbearia.clientesDePe.isEmpty()){
                    barbearia.sofa.add(barbearia.clientesDePe.get(0));
                    System.out.println(" | Cliente " + barbearia.clientesDePe.get(0).identificador + " sentou no sofá");
                    barbearia.clientesDePe.remove(0);
                }
                System.out.println(" | Barbeiro " + this.nomeBarbeiro + " cortando " + cliente.identificador);
            } else {
                cliente = null;
            }
        }
    }
}
