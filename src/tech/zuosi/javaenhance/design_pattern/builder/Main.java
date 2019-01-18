package tech.zuosi.javaenhance.design_pattern.builder;

import tech.zuosi.javaenhance.design_pattern.builder.implemetations.ConcreteBuilder;
import tech.zuosi.javaenhance.design_pattern.builder.interfaces.Builder;
import tech.zuosi.javaenhance.design_pattern.builder.interfaces.Director;

/**
 * Created by luckykoala on 19-1-18.
 * Builder method
 * Use cases:
 *  1. When algorithm of creating complex object should be independent with parts of objects and how they be built.
 *  2. When object being created must be allowed to have different representations.
 */
public class Main {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        System.out.println(director.construct().toString());
    }
}
