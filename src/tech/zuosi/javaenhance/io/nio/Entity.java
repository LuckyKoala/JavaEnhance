package tech.zuosi.javaenhance.io.nio;

import java.util.StringJoiner;

public class Entity {
    private String name;
    private int health;
    private int healthMaximum;
    private double money;

    private static final String delimiter = "&";
    private static final Entity EMPTY = new Entity("nil", 0, 0, 0);

    public Entity(String name, int health, int healthMaximum, double money) {
        this.name = name;
        this.health = health;
        this.healthMaximum = healthMaximum;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealthMaximum() {
        return healthMaximum;
    }

    public void setHealthMaximum(int healthMaximum) {
        this.healthMaximum = healthMaximum;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(delimiter);
        return stringJoiner
                .add(name)
                .add(Integer.toString(health))
                .add(Integer.toString(healthMaximum))
                .add(Double.toString(money))
                .toString();
    }

    public static Entity of(String str) {
        String[] values = str.split(delimiter);
        if (values.length == 4) {
            return new Entity(values[0],
                    Integer.parseInt(values[1]),
                    Integer.parseInt(values[2]),
                    Double.parseDouble(values[3]));
        } else {
            return EMPTY;
        }
    }
}
