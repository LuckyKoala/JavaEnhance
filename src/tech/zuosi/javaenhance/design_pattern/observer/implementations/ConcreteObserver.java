package tech.zuosi.javaenhance.design_pattern.observer.implementations;

import tech.zuosi.javaenhance.design_pattern.observer.interfaces.Observable;
import tech.zuosi.javaenhance.design_pattern.observer.interfaces.Observer;

public class ConcreteObserver implements Observer {
    @Override
    public void update(Observable observable) {
        System.out.print("Update !");
    }
}
