package tech.zuosi.javaenhance.design_pattern.observer.interfaces;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void publish();
}
