package tech.zuosi.javaenhance.reflection.fields;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by iwar on 2017/6/24.
 */
public class FieldSpy<T> {
    public boolean[][] b = {{ false, false }, { true, true } };
    public String name  = "Alice";
    public List<Integer> list;
    public T val;
    private static final String CLASS_NAME = FieldSpy.class.getName();

    public static void on(String... args) {
        try {
            Class<?> c = Class.forName(args[0]);
            Field f = c.getField(args[1]);
            System.out.format("Type: %s%n", f.getType());
            System.out.format("GenericType: %s%n", f.getGenericType());

            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException | NoSuchFieldException x) {
            x.printStackTrace();
        }
    }

    public static void main(String[] args) {
        on(CLASS_NAME, "b");
        on(CLASS_NAME, "name");
        on(CLASS_NAME, "list");
        on(CLASS_NAME, "val");
    }
}
