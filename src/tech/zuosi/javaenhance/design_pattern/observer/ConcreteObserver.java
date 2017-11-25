package tech.zuosi.javaenhance.design_pattern.observer;

public class ConcreteObserver implements Observer {
    @Override
    public void update(Observable observable) {
        System.out.print("Update !");
    }
}
