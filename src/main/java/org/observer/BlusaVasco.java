package org.observer;

import java.util.Observable;

public class BlusaVasco extends Observable {

    private String nomeBlusa;
    private double valor;

    public BlusaVasco(String nomeBlusa, double valor) {
        this.nomeBlusa = nomeBlusa;
        this.valor = valor;
    }

    public void adicionarEstoque(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "BlusaVasco{" +
                "nomeBlusa='" + nomeBlusa + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
