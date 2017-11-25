package tech.zuosi.javaenhance.stream.sample;

/**
 * Created by iwar on 2017/6/13.
 */
public class Track {
    String name;
    int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public Track copy() {
        return new Track(name, length);
    }
}
