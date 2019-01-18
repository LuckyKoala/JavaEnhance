package tech.zuosi.javaenhance.design_pattern.builder.interfaces;

/**
 * Created by luckykoala on 19-1-18.
 */
public interface Builder {
    void buildHead();
    void buildBody();
    void buildTail();
    Entity getEntity();
}
