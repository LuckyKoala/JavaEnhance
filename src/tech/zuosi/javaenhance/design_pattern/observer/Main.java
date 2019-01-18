package tech.zuosi.javaenhance.design_pattern.observer;

import tech.zuosi.javaenhance.design_pattern.observer.implementations.ConcreteObservable;
import tech.zuosi.javaenhance.design_pattern.observer.implementations.ConcreteObserver;
import tech.zuosi.javaenhance.design_pattern.observer.interfaces.Observable;
import tech.zuosi.javaenhance.design_pattern.observer.interfaces.Observer;

/**
 * Created by luckykoala on 19-1-18.
 * Observer method (also known as Dependents, Publish-Subscribe)
 * Use cases:
 *  1. When a abstract model involves two aspects and one depends on other. Encapsulate these two aspects
 *          in a separate object so they can be changed and reused independently.
 *  2. When change of one object involves change of some other objects.
 *  3. Wehn one object must notify other objects and it can't assume what are them.
 */

public class Main {
    public static void main(String[] args) {
        Observable observable = new ConcreteObservable();
        Observer observer = new ConcreteObserver();
        observable.addObserver(observer);
        observable.publish();
    }
}
