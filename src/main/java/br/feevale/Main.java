package br.feevale;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Barbearia barbearia = new Barbearia();

        Barbeiro barbeiroA = new Barbeiro("santosA", EstadoBarbeiro.LIVRE);
        Barbeiro barbeiroB = new Barbeiro("santosB", EstadoBarbeiro.LIVRE);
        Barbeiro barbeiroC = new Barbeiro("santosC", EstadoBarbeiro.LIVRE);

        Cadeira cadeiraA = new Cadeira();
        cadeiraA.barbeiro = barbeiroA;

        Cadeira cadeiraB = new Cadeira();
        cadeiraB.barbeiro = barbeiroB;

        Cadeira cadeiraC = new Cadeira();
        cadeiraC.barbeiro = barbeiroC;

        List<Cadeira> cadeiras = new ArrayList<>(3);

        cadeiras.add(cadeiraA);
        cadeiras.add(cadeiraB);
        cadeiras.add(cadeiraC);

        barbearia.cadeiras = cadeiras;
        barbearia.iniciarExpediente();

        Cliente bernardo = new Cliente();
        bernardo.nome = "bernardo";
        bernardo.tempoDeCorte = 5000L;

        Cliente ivan = new Cliente();
        ivan.nome = "ivan";
        ivan.tempoDeCorte = 5000L;

        Cliente lucas = new Cliente();
        lucas.nome = "lucas";
        lucas.tempoDeCorte = 10000L;


        barbearia.receberCliente(List.of(bernardo,ivan,lucas));


//        Thread.sleep(20000L);
//        barbearia.receberCliente(bernardo);
//        barbearia.receberCliente(ivan);
//        barbearia.receberCliente(lucas);

    }

}