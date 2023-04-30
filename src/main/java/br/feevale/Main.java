package br.feevale;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SalaDeEspera salaDeEspera = new SalaDeEspera();

        Barbeiro b1 = new Barbeiro(salaDeEspera, "SantosA");
        Barbeiro b2 = new Barbeiro(salaDeEspera, "SantosB");
        Barbeiro b3 = new Barbeiro(salaDeEspera, "SantosC");

        salaDeEspera.cadeiras = List.of(b1, b2, b3);

        int count = 0;

        while (true) {
            new Cliente(salaDeEspera, count++);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
