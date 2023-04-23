package br.feevale;

import java.util.List;

public class Barbearia {

    public static final SalaDeEspera salaDeEspera = new SalaDeEspera();

    public static void main(String[] args) {

        Barbeiro b1 = new Barbeiro();
        Barbeiro b2 = new Barbeiro();
        Barbeiro b3 = new Barbeiro();

        salaDeEspera.barbeiros = List.of(b1, b2, b3);

        int count = 0;

//        while (count++ < 20) {
        while (true) {
            Cliente cliente = new Cliente(salaDeEspera);
            cliente.start();

        }
    }
}
