package tech.zuosi.javaenhance.design_pattern.factory.implementations;

import tech.zuosi.javaenhance.design_pattern.factory.interfaces.Product;

/**
 * Created by luckykoala on 19-1-18.
 */
public class Empty implements Product {
    @Override
    public void use() {
        System.out.println("use Empty");
    }
}
