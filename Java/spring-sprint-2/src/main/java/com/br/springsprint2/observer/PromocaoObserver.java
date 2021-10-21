package com.br.springsprint2.observer;

import com.br.springsprint2.util.ListaObj;

import java.util.ArrayList;
import java.util.List;


public abstract class PromocaoObserver {
    private List<Observer> ListaObserver = new ArrayList<>();

    public void attatch (Observer o){
        ListaObserver.add(o);
    }
    public void detach (Observer o){
        ListaObserver.remove(o);
    }
    public void notifyObservers() {
        for (Observer o: ListaObserver) {
            o.update();
        }
    }
}
