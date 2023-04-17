package br.feevale;

import java.util.ArrayList;
import java.util.List;

public class SalaDeEspera {
    private static final int CAPACIDADE_MAXIMA_SOFA = 4;
    private static final int CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE = 13;
    public List<Cliente> clientesSentados = new ArrayList<>(CAPACIDADE_MAXIMA_SOFA);
    public List<Cliente> clientesDePe = new ArrayList<>(CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE);

}
