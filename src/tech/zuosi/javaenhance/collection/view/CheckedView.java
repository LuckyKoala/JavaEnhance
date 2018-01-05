package tech.zuosi.javaenhance.collection.view;

import java.util.*;

public class CheckedView {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List rawList = strings;
        rawList.add(new Date()); //This will not be detected until get method is invoked.
        //String whatever = (String)rawList.get(0);
        List list = Collections.checkedList(strings, String.class);
        list.add(new Date()); //This will be detected once add method is invoked.
    }
}
