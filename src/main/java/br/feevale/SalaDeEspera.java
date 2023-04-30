package br.feevale;

import java.util.ArrayList;
import java.util.List;

public class SalaDeEspera {

    private static final int CAPACIDADE_MAXIMA_BARBEIRO = 3;
    private static final int CAPACIDADE_MAXIMA_SOFA = 4;
    private static final int CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE = 13;

    List<Barbeiro> cadeiras = new ArrayList<>(CAPACIDADE_MAXIMA_BARBEIRO);
    List<Cliente> sofa = new ArrayList<>(CAPACIDADE_MAXIMA_SOFA);
    List<Cliente> clientesDePe = new ArrayList<>(CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE);

    public boolean entrar(Cliente cliente) {
        if(sofa.isEmpty() || sofa.size() < CAPACIDADE_MAXIMA_SOFA){
            sofa.add(cliente);
            System.out.println("Cliente " + cliente.identificador + " sentou no sofa");
            return true;
        }
        else if(clientesDePe.isEmpty() || clientesDePe.size() < CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE){
            clientesDePe.add(cliente);
            System.out.println("Cliente " + cliente.identificador + " está aguardando de pé");
            return true;
        }
        return false;
    }
}
