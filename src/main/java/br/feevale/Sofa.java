package br.feevale;

import java.util.ArrayList;

public class Sofa extends ArrayList {


    public void remover(int index, Barbeiro barbeiro, Cliente cliente) throws InterruptedException {
        super.remove(index);
        barbeiro.cortar(cliente);
    }
}
