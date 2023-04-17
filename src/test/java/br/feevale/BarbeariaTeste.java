package br.feevale;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BarbeariaTeste {

    /**
     *  [z] três cadeiras;
     *  [z] três barbeiros;
     *  [] uma sala de espera com um sofá de quatro lugares;
     *  [] o número total de clientes permitidos na barbearia é 20;
     *  [] nenhum cliente entrará se a capacidade do local estiver satisfeita;
     *  [] se o cliente entrou e tiver lugar no sofá ele se senta, caso contrário ele espera em pé;
     *  [] quando um barbeiro está livre para atender, o cliente que está a mais tempo no sofá é atendido e o que está a mais tempo em pé se senta;
     *  [] qualquer barbeiro pode aceitar pagamento, mas somente um cliente pode pagar por vez, porque só há uma maquina de cartão (POS / TEF);
     *  [] os barbeiros dividem o seu tempo entre cortar cabelo, receber pagamento e dormir enquanto esperam por um cliente.*/


    @Test
    void teste(){

        Barbearia barbearia = new Barbearia();

        Cadeira cadeira = new Cadeira();
        cadeira.barbeiro = new Barbeiro("Bernardo");

        barbearia.clientesCortando.add(cadeira);

        barbearia.iniciarExpediente();

        System.out.println(barbearia.clientesCortando.get(0).barbeiro.nome);
        System.out.println(barbearia.clientesCortando.get(0).barbeiro.estado);
    }

    @Test
    void testeDeLista() {

        Cliente bernardo = new Cliente();
        bernardo.nome = "bernardo";

        Cliente ivan = new Cliente();
        ivan.nome = "ivan";

        Cliente lucas = new Cliente();
        lucas.nome = "lucas";

        List<Cliente> clientesCortando = new ArrayList<>(3);

        clientesCortando.add(bernardo);
        clientesCortando.add(ivan);

        System.out.println(clientesCortando.get(0).nome);
        clientesCortando.remove(bernardo);
        System.out.println(clientesCortando.get(0).nome);
        clientesCortando.add(lucas);
    }

}
