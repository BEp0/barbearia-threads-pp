package br.feevale;

import java.util.ArrayList;
import java.util.List;

public class Barbearia {

    private static final int CAPACIDADE_MAXIMA_DE_BARBEIROS = 3;

    public List<Cadeira> clientesCortando = new ArrayList<>(CAPACIDADE_MAXIMA_DE_BARBEIROS);
    public SalaDeEspera salaDeEspera = new SalaDeEspera();


    public void iniciarExpediente() {
        for (Cadeira c : clientesCortando) {
            String msg = String.format(">>>>> %s iniciando o expediente", c.barbeiro.nome);
            System.out.println(msg);
            c.barbeiro.start();
        }
    }

//    public void receberCliente(Cliente cliente) {
////        if (/*haBarbeirosLivres()*/true) {
////            // barbeiro pega o cliente
////
////            System.out.println("Tem barbeiro livre!!!");
////
////            cliente.estado = Estado.CORTANDO;
//////            clientesCortando.add(cliente);
//////            Barbeiro b = getBarbeiroLivre();
////
////            String msg = String.format(">>>> %s está sentado para cortar o cabelo com %s!!!", cliente.nome);
////            System.out.println(msg);
////
////        } else if (sofaEstaLivre()) {
////            // cliente fica sentado
////            System.out.println("Tem vaga no sofa!!!");
////            clientesSentados.add(cliente);
////
////        } else if (haEspacoParaFicarDePe()) {
////            // cliente fica de pe
////            System.out.println("Tem vaga de pé!!!");
////        } else {
////            throw new BarbeariaLotadaException("Barbearia está lotada");
////        }
//    }

//    private Barbeiro getBarbeiroLivre() {
//        return barbeiros.stream()
//                .filter(barbeiro -> barbeiro.estado.equals(LIVRE))
//                .findFirst()
//                .orElseThrow();
//    }

//    private synchronized boolean haEspacoParaFicarDePe() {
//        return clientesDePe.isEmpty() || clientesDePe.size() < CAPACIDADE_MAXIMA_DE_CLIENTES_EM_PE;
//    }
//
//    private synchronized boolean sofaEstaLivre() {
//        return clientesSentados.isEmpty() || clientesSentados.size() < CAPACIDADE_MAXIMA_SOFA;
//    }

//    private synchronized boolean haBarbeirosLivres() {
//        return barbeiros.stream()
//                .anyMatch(barbeiro -> barbeiro.estado.equals(LIVRE));
//    }
}
