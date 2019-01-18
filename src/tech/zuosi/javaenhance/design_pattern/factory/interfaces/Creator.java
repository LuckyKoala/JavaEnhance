package tech.zuosi.javaenhance.design_pattern.factory.interfaces;

import tech.zuosi.javaenhance.design_pattern.factory.implementations.Apple;
import tech.zuosi.javaenhance.design_pattern.factory.implementations.Banana;
import tech.zuosi.javaenhance.design_pattern.factory.implementations.Empty;
import tech.zuosi.javaenhance.design_pattern.factory.implementations.Orange;

/**
 * Created by luckykoala on 19-1-18.
 */
public class Creator {
    public static final int APPLE = 0;
    public static final int ORANGE = 1;
    public static final int BANANA = 2;

    public Product create(int productId) {
        if(productId == APPLE) return new Apple();
        if(productId == ORANGE) return new Orange();
        if(productId == BANANA) return new Banana();
        else return new Empty();
    }
}
