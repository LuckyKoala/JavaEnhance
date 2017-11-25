package tech.zuosi.javaenhance.reflection;

import java.lang.reflect.Constructor;

/**
 * Created by iwar on 2017/6/23.
 */
class Cls {
    private Cls() {}
}
public class ClassTrouble {
    public static void main(String... args) {
        try {
            Class<?> c = Class.forName("tech.zuosi.javaenhance.reflection.Cls");
            Constructor<?> constructor = c.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();  // InstantiationException

            // production code should handle these exceptions more gracefully
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
