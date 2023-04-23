package br.feevale;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SalaDeEspera {

    final int CAPACIDADE_MAXIMA_BARBEIRO = 3;
    final int CAPACIDADE_MAXIMA_SOFA = 4;
    final int CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE = 13;

    List<Barbeiro> barbeiros = new ArrayList<>(CAPACIDADE_MAXIMA_BARBEIRO);
    List<Cliente> sofa = new ArrayList<>(CAPACIDADE_MAXIMA_SOFA);
    List<Cliente> clientesDePe = new ArrayList<>(CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE);

    public void receberCliente(Cliente cliente) {



//        if (barbeiroLivre()) {
//
//        } else if (sofaEstaLivre()) {
//            System.out.println("Tem vaga no sofa!!!");
//            sofa.add(cliente);
//        } else if (haEspacoParaFicarDePe()) {
//            System.out.println("Tem vaga de pé!!!");
//            clientesDePe.add(cliente);
//        } else {
//            throw new BarbeariaLotadaException("Barbearia está lotada");
//        }
    }

    private synchronized Barbeiro getBarbeiroLivre() {
        return barbeiros.stream()
                .filter(Barbeiro::estaLivre)
                .findFirst()
                .orElseThrow();
    }

    private synchronized boolean barbeiroLivre() {
        return Objects.nonNull(getBarbeiroLivre());
    }

    private synchronized boolean haEspacoParaFicarDePe() {
        return clientesDePe.isEmpty() || clientesDePe.size() < CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE;
    }

    private synchronized boolean sofaEstaLivre() {
        return sofa.isEmpty() || sofa.size() < CAPACIDADE_MAXIMA_SOFA;
    }

    public void entrar(Cliente cliente) {
        try {
            System.out.println("Cliente indo cortar cabelo");
            Barbeiro barbeiro = getBarbeiroLivre();
            barbeiro.cortar(cliente);
        } catch (RuntimeException runtimeException) {
            if (sofaEstaLivre()) {
                System.out.println("Tem vaga no sofa!!!");
                sofa.add(cliente);
            } else if (haEspacoParaFicarDePe()) {
                System.out.println("Tem vaga de pé!!!");
                clientesDePe.add(cliente);
            } else {
                throw new BarbeariaLotadaException("Barbearia está lotada");
            }
        }
        catch (InterruptedException e) {
            System.out.println("deu ruim");
        }
    }
}
