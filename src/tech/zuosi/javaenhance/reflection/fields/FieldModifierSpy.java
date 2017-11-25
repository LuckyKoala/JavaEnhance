package tech.zuosi.javaenhance.reflection.fields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

/**
 * Created by iwar on 2017/6/24.
 * <br><a href="https://docs.oracle.com/javase/tutorial/reflect/member/fieldModifiers.html">From Oracle Document</a>
 * <br>The set of synthetic fields is compiler-dependent;
 * however commonly used fields include this$0 for inner classes
 * (i.e. nested classes that are not static member classes) to reference the outermost enclosing class
 * and $VALUES used by enums to implement the implicitly defined static method values().
 * The names of synthetic class members are not specified
 * and may not be the same in all compiler implementations or releases.
 * These and other synthetic fields will be included in the array returned by Class.getDeclaredFields()
 * but not identified by Class.getField() since synthetic members are not typically public.
 */
enum Spy { BLACK , WHITE }

public class FieldModifierSpy {
    volatile int share;
    int instance;
    class Inner {}
    private static final String CLASS_NAME = FieldModifierSpy.class.getName();
    private static final Map<String, Integer> MODIFIER_MAP = new HashMap<>(7);

    static {
        MODIFIER_MAP.put("public", Modifier.PUBLIC);
        MODIFIER_MAP.put("protected", Modifier.PROTECTED);
        MODIFIER_MAP.put("private", Modifier.PRIVATE);
        MODIFIER_MAP.put("static", Modifier.STATIC);
        MODIFIER_MAP.put("final", Modifier.FINAL);
        MODIFIER_MAP.put("transient", Modifier.TRANSIENT);
        MODIFIER_MAP.put("volatile", Modifier.VOLATILE);
    }

    public static void main(String[] args) {
        on(CLASS_NAME, "volatile");
        on(Spy.class.getName(), "public");
        on(Inner.class.getName(), "final");
        on(Spy.class.getName(), "private", "final", "static");
    }

    public static void on(String... args) {
        try {
            Class<?> c = Class.forName(args[0]);
            int searchMods = 0x0;
            for (int i = 1; i < args.length; i++) {
                searchMods |= modifierFromString(args[i]);
            }

            Field[] flds = c.getDeclaredFields();
            out.format("Fields in Class '%s' containing modifiers:  %s%n",
                    c.getName(),
                    Modifier.toString(searchMods));
            boolean found = false;
            for (Field f : flds) {
                int foundMods = f.getModifiers();
                // Require all of the requested modifiers to be present
                if ((foundMods & searchMods) == searchMods) {
                    out.format("%-8s [ synthetic=%-5b enum_constant=%-5b ]%n",
                            f.getName(), f.isSynthetic(),
                            f.isEnumConstant());
                    found = true;
                }
            }

            if (!found) {
                out.format("No matching fields%n");
            }

            // production code should handle this exception more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private static int modifierFromString(String s) {
        return MODIFIER_MAP.getOrDefault(s, 0x0);
    }
}
