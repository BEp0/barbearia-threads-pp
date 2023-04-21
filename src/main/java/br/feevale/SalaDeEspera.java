package br.feevale;

import java.util.ArrayList;
import java.util.List;

public class SalaDeEspera {
    final int CAPACIDADE_MAXIMA_SOFA = 4;
    final int CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE = 13;

    List<Cliente> sofa = new ArrayList<>(CAPACIDADE_MAXIMA_SOFA);
    List<Cliente> clientesDePe = new ArrayList<>(CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE);



    public void receberCliente(Cliente cliente) {
         if (sofaEstaLivre()) {
            // cliente fica sentado
            System.out.println("Tem vaga no sofa!!!");
            sofa.add(cliente);

        } else if (haEspacoParaFicarDePe()) {
            // cliente fica de pe
            System.out.println("Tem vaga de pé!!!");
            clientesDePe.add(cliente);
        } else {
            throw new BarbeariaLotadaException("Barbearia está lotada");
        }
    }


    private synchronized boolean haEspacoParaFicarDePe() {
        return clientesDePe.isEmpty() || clientesDePe.size() < CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE;
    }

    private synchronized boolean sofaEstaLivre() {
        return sofa.isEmpty() || sofa.size() < CAPACIDADE_MAXIMA_SOFA;
    }

    public boolean sofaLivre() {
        return sofa.size() < 4;
    }

    public boolean espacoDePe() {
        return clientesDePe.size() < 13;
    }

    public synchronized void entrar(Cliente cliente) {

        if(this.sofaLivre()){
//            try {
                this.sofa.add(cliente);
                System.out.println("Sentei no sofa");
//                cliente.esperar();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        } else if (this.espacoDePe()) {
            System.out.println("Estou esperando de pe");
            this.clientesDePe.add(cliente);
        } else {
            System.out.println("morri");
        }
    }
}
