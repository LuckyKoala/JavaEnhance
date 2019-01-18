package tech.zuosi.javaenhance.design_pattern.prototype.implemetations;

import tech.zuosi.javaenhance.design_pattern.prototype.interfaces.Prototype;

/**
 * Created by luckykoala on 19-1-18.
 */
public class ConcretePrototypeB implements Prototype {
    private int point;

    public ConcretePrototypeB(int point) {
        this.point = point;
    }

    public ConcretePrototypeB(ConcretePrototypeB prototype) {
        this.point = prototype.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "ConcretePrototypeB{" +
                "point=" + point +
                '}';
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototypeB(this);
    }
}
