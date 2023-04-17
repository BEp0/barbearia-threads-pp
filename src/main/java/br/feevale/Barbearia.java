package br.feevale;

import java.util.ArrayList;
import java.util.List;

public class Barbearia {

    private static final int CAPACIDADE_MAXIMA_DE_BARBEIROS = 3;

    public List<Cadeira> cadeiras = new ArrayList<>(CAPACIDADE_MAXIMA_DE_BARBEIROS);
    public SalaDeEspera salaDeEspera = new SalaDeEspera();


    public void iniciarExpediente() {
        for (Cadeira c : cadeiras) {
            String msg = String.format(">>>>> %s iniciando o expediente", c.barbeiro.nome);
            System.out.println(msg);
            c.start();
        }
    }

    public void receberCliente(List<Cliente> clientes) throws InterruptedException {
        for(Cliente cliente: clientes){
            if (haBarbeirosLivres()) {
                // barbeiro pega o cliente
                System.out.println("Tem barbeiro livre!!!");
                cliente.estado = Estado.CORTANDO;
                Cadeira cadeira = getCadeiraLivre();
                cadeira.cliente = cliente;
                cadeira.liberarCorte();

                String msg = String.format(">>>> %s está sentado para cortar o cabelo com %s!!!", cliente.nome, cadeira.barbeiro.nome);
                System.out.println(msg);
            }else{
                salaDeEspera.receberCliente(cliente);
            }
        }
    }

    private Cadeira getCadeiraLivre() {
        return cadeiras.stream()
                .filter(cadeira -> cadeira.barbeiro.estado.equals(EstadoBarbeiro.LIVRE))
                .findFirst()
                .orElseThrow();
    }


    private synchronized boolean haBarbeirosLivres() {
        return cadeiras.stream()
                .anyMatch(cadeira -> cadeira.barbeiro.estado.equals(EstadoBarbeiro.LIVRE));
    }
}
