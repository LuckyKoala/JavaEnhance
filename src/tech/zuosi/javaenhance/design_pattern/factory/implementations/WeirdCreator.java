package tech.zuosi.javaenhance.design_pattern.factory.implementations;

import tech.zuosi.javaenhance.design_pattern.factory.interfaces.Creator;
import tech.zuosi.javaenhance.design_pattern.factory.interfaces.Product;

/**
 * Created by luckykoala on 19-1-18.
 */
public class WeirdCreator extends Creator {
    @Override
    public Product create(int productId) {
        //This is weird indeeed, but we only want to use this class to illustrate that
        //  we can create a concrete creator which handle some identification of product differently
        //  compared with its parent class -- creator
        if(productId == APPLE) return new Orange();
        if(productId == ORANGE) return new Apple();

        return super.create(productId);
    }
}
