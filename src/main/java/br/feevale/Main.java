package br.feevale;

import java.util.List;

public class Main {

    public static final Barbearia BARBEARIA = new Barbearia();

    public static void main(String[] args) {

        Barbeiro b1 = new Barbeiro(BARBEARIA, "SantosA");
        Barbeiro b2 = new Barbeiro(BARBEARIA, "SantosB");
        Barbeiro b3 = new Barbeiro(BARBEARIA, "SantosC");

        BARBEARIA.barbeiros = List.of(b1, b2, b3);

        int count = 0;

        while (count++ < 100) {
//        while (true) {
            System.out.println("Crei um cliente novo!");
            Cliente cliente = new Cliente(BARBEARIA, count);
            cliente.start();
        }
    }
}
