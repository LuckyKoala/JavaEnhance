package tech.zuosi.javaenhance.design_pattern.builder.interfaces;

/**
 * Created by luckykoala on 19-1-18.
 */
public class Entity {
    private int head, body, tail;

    public Entity() {}

    public void setHead(int head) {
        this.head = head;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "head=" + head +
                ", body=" + body +
                ", tail=" + tail +
                '}';
    }
}
