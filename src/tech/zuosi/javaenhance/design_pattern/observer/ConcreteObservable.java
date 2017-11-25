package tech.zuosi.javaenhance.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteObservable implements Observable {
    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void publish() {
        this.observerList.forEach(o -> o.update(this));
    }
}
