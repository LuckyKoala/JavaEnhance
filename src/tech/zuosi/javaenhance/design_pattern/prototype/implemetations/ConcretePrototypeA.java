package tech.zuosi.javaenhance.design_pattern.prototype.implemetations;

import tech.zuosi.javaenhance.design_pattern.prototype.interfaces.Prototype;

/**
 * Created by luckykoala on 19-1-18.
 */
public class ConcretePrototypeA implements Prototype {
    private String data;

    public ConcretePrototypeA(String data) {
        this.data = data;
    }

    public ConcretePrototypeA(ConcretePrototypeA prototype) {
        this.data = prototype.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ConcretePrototypeA{" +
                "data=" + data +
                '}';
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototypeA(this);
    }
}
