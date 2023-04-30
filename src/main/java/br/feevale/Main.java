package br.feevale;

import java.util.List;

public class Main {

    public static final Barbearia BARBEARIA = new Barbearia();

    public static void main(String[] args) {

        Barbeiro b1 = new Barbeiro(BARBEARIA, "SantosA");
        Barbeiro b2 = new Barbeiro(BARBEARIA, "SantosB");
        Barbeiro b3 = new Barbeiro(BARBEARIA, "SantosC");

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
