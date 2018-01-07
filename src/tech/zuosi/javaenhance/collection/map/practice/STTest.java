package tech.zuosi.javaenhance.collection.map.practice;

public class STTest {
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        st.put("one", 1);
        st.put("two", 2);
        System.out.println("Size: " + st.size());
        st.delete("two");
        System.out.println("Size: " + st.size());
    }
}
