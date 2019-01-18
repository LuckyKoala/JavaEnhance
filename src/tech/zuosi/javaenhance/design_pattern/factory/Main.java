package tech.zuosi.javaenhance.design_pattern.factory;

import tech.zuosi.javaenhance.design_pattern.factory.implementations.WeirdCreator;
import tech.zuosi.javaenhance.design_pattern.factory.interfaces.Creator;

/**
 * Created by luckykoala on 19-1-18.
 * Factory method
 * Use cases:
 *  1. The class don't know the class of object which it must create.
 *  2. The class wants its children class to designate what object should be created.
 *  3. The class wants delegate its responsibility to one of local helper classes.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Factory method ===");
        System.out.println("1. normal top level creator");
        Creator creator = new Creator();
        creator.create(Creator.APPLE).use();
        creator.create(Creator.ORANGE).use();

        System.out.println("2. concrete weird creator which override something from its parent");
        Creator weirdCreator = new WeirdCreator();
        weirdCreator.create(Creator.APPLE).use();
        weirdCreator.create(Creator.ORANGE).use();
    }
}
