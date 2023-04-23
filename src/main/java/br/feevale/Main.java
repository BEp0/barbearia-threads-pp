package br.feevale;

import java.util.List;

public class Main {

    public static final Barbearia BARBEARIA = new Barbearia();

    public static void main(String[] args) {

        Barbeiro b1 = new Barbeiro();
        Barbeiro b2 = new Barbeiro();
        Barbeiro b3 = new Barbeiro();

        BARBEARIA.barbeiros = List.of(b1, b2, b3);

        int count = 0;

//        while (count++ < 20) {
        while (true) {
            Cliente cliente = new Cliente(BARBEARIA);
            cliente.start();

        }
    }
}
