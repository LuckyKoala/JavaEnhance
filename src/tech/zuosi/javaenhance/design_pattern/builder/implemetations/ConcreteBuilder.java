package tech.zuosi.javaenhance.design_pattern.builder.implemetations;

import tech.zuosi.javaenhance.design_pattern.builder.interfaces.Builder;
import tech.zuosi.javaenhance.design_pattern.builder.interfaces.Entity;

/**
 * Created by luckykoala on 19-1-18.
 */
public class ConcreteBuilder implements Builder {
    private Entity entity;

    public ConcreteBuilder() {
        this.entity = new Entity();
    }

    @Override
    public void buildHead() {
        entity.setHead(1);
    }

    @Override
    public void buildBody() {
        entity.setBody(2);
    }

    @Override
    public void buildTail() {
        entity.setTail(3);
    }

    @Override
    public Entity getEntity() {
        return entity;
    }
}
