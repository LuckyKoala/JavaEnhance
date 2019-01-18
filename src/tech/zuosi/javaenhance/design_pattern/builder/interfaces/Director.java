package tech.zuosi.javaenhance.design_pattern.builder.interfaces;

/**
 * Created by luckykoala on 19-1-18.
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Entity construct() {
        builder.buildHead();
        builder.buildBody();
        builder.buildTail();
        return builder.getEntity();
    }
}
