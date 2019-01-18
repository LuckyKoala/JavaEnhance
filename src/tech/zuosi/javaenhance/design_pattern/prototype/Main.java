package tech.zuosi.javaenhance.design_pattern.prototype;

import tech.zuosi.javaenhance.design_pattern.prototype.implemetations.ConcretePrototypeA;
import tech.zuosi.javaenhance.design_pattern.prototype.implemetations.ConcretePrototypeB;
import tech.zuosi.javaenhance.design_pattern.prototype.interfaces.Client;

/**
 * Created by luckykoala on 19-1-18.
 * Prototype method
 * Use cases:
 *  1. When new class is designate at runtime. e.g Dynamic loading
 *  2. To avoid creating a product at factory level.
 *  3. When instances of class can only be one of different type of composite.
 */
public class Main {
    public static void main(String[] args) {
        ConcretePrototypeA prototypeA = new ConcretePrototypeA("prototypeA");
        ConcretePrototypeB prototypeB = new ConcretePrototypeB(1);
        Client client = new Client(prototypeA, prototypeB);

        System.out.println(client.makePrototypeA("new prototypeA").toString());
        System.out.println(client.makePrototypeB(2).toString());
    }
}
