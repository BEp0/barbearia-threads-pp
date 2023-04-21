package br.feevale;

import java.util.ArrayList;
import java.util.List;

public class Barbearia {

    public static final SalaDeEspera salaDeEspera = new SalaDeEspera();

    public static void main(String[] args) {

        Barbeiro b1 = new Barbeiro();
        Barbeiro b2 = new Barbeiro();
        Barbeiro b3 = new Barbeiro();

        int count = 0;

        while (true) {
            Cliente cliente = new Cliente(salaDeEspera);
            cliente.start();
        }
    }
}
