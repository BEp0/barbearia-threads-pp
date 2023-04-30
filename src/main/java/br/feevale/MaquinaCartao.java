package br.feevale;

import java.util.Random;

public class MaquinaCartao {
    public synchronized void operar(Cliente cliente) {
        System.out.println(" | Cliente " + cliente.identificador + " pagando R$35,00");
        try {
            Thread.sleep((int) (Math.random() * 2000));
        } catch (InterruptedException e) {
            System.out.println("Erro ao tentar pagar");
        }
    }
}
