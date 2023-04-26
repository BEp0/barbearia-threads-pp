package br.feevale;

import java.util.ArrayList;
import java.util.List;

public class Barbearia {

    final int CAPACIDADE_MAXIMA_BARBEIRO = 3;
    final int CAPACIDADE_MAXIMA_SOFA = 4;
    final int CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE = 13;

    List<Barbeiro> barbeiros = new ArrayList<>(CAPACIDADE_MAXIMA_BARBEIRO);
    List<Cliente> sofa = new ArrayList<>(CAPACIDADE_MAXIMA_SOFA);
    List<Cliente> clientesDePe = new ArrayList<>(CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE);

    private Barbeiro getBarbeiroLivre() {
        return barbeiros.stream()
                .filter(Barbeiro::estaLivre)
                .findFirst()
                .orElseThrow();
    }

    public void entrar(Cliente cliente) {

        if (haBarbeirosLivres()) {
            Barbeiro barbeiro = getBarbeiroLivre();
            barbeiro.cortar(cliente);
        } else if (sofaEstaLivre()) {
            sofa.add(cliente);
            System.out.println("Cliente no sofa!!!");
        } else if (haEspacoParaFicarDePe()) {
            clientesDePe.add(cliente);
            System.out.println("Tem vaga de pé!!!");
        } else {
            throw new BarbeariaLotadaException();
        }
    }

    public synchronized Cliente proximoCliente() {
        if (sofa.size() > 0) {
            Cliente cliente = sofa.get(0);
            sofa.remove(0);
            if (clientesDePe.size() > 0) {
                sofa.add(clientesDePe.get(0));
                clientesDePe.remove(0);
            }
            return cliente;
        }
        throw new BarbeariaVaziaException();
    }

    private synchronized boolean haEspacoParaFicarDePe() {
        return clientesDePe.isEmpty() || clientesDePe.size() < CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE;
    }

    private synchronized boolean sofaEstaLivre() {
        return sofa.isEmpty() || sofa.size() < CAPACIDADE_MAXIMA_SOFA;
    }

    private synchronized boolean haBarbeirosLivres() {
        return barbeiros.stream()
                .anyMatch(Barbeiro::estaLivre);
    }
}
