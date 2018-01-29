package tech.zuosi.javaenhance.basic;

import java.util.HashMap;
import java.util.Map;

public class InstanceInitializer {
    //the initializer can improve code readability by keeping the initialization logic
    //  next to the variable being initialized
    private int theAnswer;
    {
        int SIX = 6;
        int NINE = 7;
        theAnswer = SIX * NINE;
    }

    //actually write instance initializer in new anonymous class
    //this can increase readability
    void construct(String[] args) {
        Map<String, String> map = new HashMap<String, String>() {{
            put("key1", "value1");
            put("key2", "value2");
        }};
    }
}
