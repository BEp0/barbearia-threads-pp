package br.feevale;

public class BarbeariaVaziaException extends RuntimeException {
    public BarbeariaVaziaException() {
        super("Barbearia está vazia");
    }
}
