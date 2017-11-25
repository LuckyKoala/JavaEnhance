package tech.zuosi.javaenhance.util;

/**
 * Created by iwar on 2017/6/13.
 */
public class TestUtil {
    //TODO use junit instead
    private static TestUtil ourInstance = new TestUtil();

    public static TestUtil getInstance() {
        return ourInstance;
    }

    private TestUtil() {
    }

    public static void assertEquals(Object a, Object b) {
        if(!a.equals(b)) System.out.println("Not equal");
    }
}
