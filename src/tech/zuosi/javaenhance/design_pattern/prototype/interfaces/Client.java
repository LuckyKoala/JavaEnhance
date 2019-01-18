package tech.zuosi.javaenhance.design_pattern.prototype.interfaces;

import tech.zuosi.javaenhance.design_pattern.prototype.implemetations.ConcretePrototypeA;
import tech.zuosi.javaenhance.design_pattern.prototype.implemetations.ConcretePrototypeB;

/**
 * Created by luckykoala on 19-1-18.
 */
public class Client {
    private ConcretePrototypeA prototypeA;
    private ConcretePrototypeB prototypeB;

    public Client(ConcretePrototypeA prototypeA, ConcretePrototypeB prototypeB) {
        this.prototypeA = prototypeA;
        this.prototypeB = prototypeB;
    }

    public ConcretePrototypeA makePrototypeA(String data) {
        ConcretePrototypeA newPrototypeA = (ConcretePrototypeA) this.prototypeA.clone();
        newPrototypeA.setData(data);
        return newPrototypeA;
    }

    public ConcretePrototypeB makePrototypeB(int point) {
        ConcretePrototypeB newPrototypeB = (ConcretePrototypeB) this.prototypeB.clone();
        newPrototypeB.setPoint(point);
        return newPrototypeB;
    }
}
