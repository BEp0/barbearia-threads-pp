package br.feevale;

import java.util.ArrayList;
import java.util.List;

public class SalaDeEspera {
    private static final int CAPACIDADE_MAXIMA_SOFA = 4;
    private static final int CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE = 13;
    public List<Cliente> clientesSentados = new ArrayList<>(CAPACIDADE_MAXIMA_SOFA);
    public List<Cliente> clientesDePe = new ArrayList<>(CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE);


    public void receberCliente(Cliente cliente) {
         if (sofaEstaLivre()) {
            // cliente fica sentado
            System.out.println("Tem vaga no sofa!!!");
            clientesSentados.add(cliente);

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
        return clientesSentados.isEmpty() || clientesSentados.size() < CAPACIDADE_MAXIMA_SOFA;
    }
}
