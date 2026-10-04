package org.observer;

import java.util.Observable;
import java.util.Observer;

public class Torcedor implements Observer {

    private String nome;
    private String notificacao;

    public Torcedor(String nome) {
        this.nome = nome;
    }

    public void querComprar(BlusaVasco blusaVasco){
        blusaVasco.addObserver(this);
    }

    public String getNotificacao(){
        return notificacao;
    }

    @Override
    public void update(Observable blusaVasco, Object arg) {
        this.notificacao = this.nome + ", chegou " + blusaVasco.toString()  + " no estoque! Corre para comprar!";
    }
}
