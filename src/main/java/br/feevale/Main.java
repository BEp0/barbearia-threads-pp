package br.feevale;

public class Main {

    public static class Pessoa {
        public static String nome;

        public Pessoa(String nome) {
            this.nome = nome;
        }
    }


    public static void main(String[] args) {

        Pessoa bernardo = new Pessoa("bernardo");
        Pessoa ivan = new Pessoa("ivan");

        System.out.println(bernardo.nome);
        System.out.println(Pessoa.nome);
    }
}