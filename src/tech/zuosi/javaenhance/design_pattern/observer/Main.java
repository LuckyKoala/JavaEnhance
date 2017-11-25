package tech.zuosi.javaenhance.design_pattern.observer;

public class Main {
    public static void main(String[] args) {
        Observable observable = new ConcreteObservable();
        Observer observer = new ConcreteObserver();
        observable.addObserver(observer);
        observable.publish();
    }
}
