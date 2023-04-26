package br.feevale;

public class MaquinaCartao {
    public synchronized void operar(int tempo) {
        try {
            System.out.println("Realizando operação de cartão");
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            System.out.println("Não conseguiu pagar");
        }
    }
}
