package tech.zuosi.javaenhance.algorithms.base.questions;

import java.util.*;

/**
 * Created by luckykoala on 19-1-17.
 * 《算法 第四版》 1.3.4 编写一个Stack的用例Parentheses，从标准输入中读取一个文本流并使用栈判定其中的符号是否配对完整。
 * 例如，对于[()]{}{[()()]()}程序应该打印true，对于[(])则打印false
 */
public class Parentheses {
    private Stack<Character> stack;
    private static final Map<Character, Character> charMap = new HashMap<>(3);

    static {
        charMap.put('}','{');
        charMap.put(']','[');
        charMap.put(')','(');
    }

    public Parentheses() {
        this.stack = new Stack<>();
    }

    public void add(char ch) {
        this.stack.push(ch);
    }

    public boolean test() {
        Set<Character> rightChars = charMap.keySet();
        Collection<Character> leftChars = charMap.values();
        Stack<Character> opStack = new Stack<>();

        while(!stack.isEmpty()) {
            char ch = stack.pop();
            if(rightChars.contains(ch)) {
                opStack.push(ch);
            } else if(leftChars.contains(ch)) {
                if(opStack.isEmpty()) return false;
                char op = opStack.pop();
                if(!match(op, ch)) return false;
            }
        }
        return true;
    }

    private boolean match(char a, char b) {
        return charMap.get(a) == b;
    }

    public static void main(String[] args) {
        String test1 = "[()]{}{[()()]()}";
        Parentheses parentheses1 = new Parentheses();
        for(char ch : test1.toCharArray()) parentheses1.add(ch);
        System.out.println("Test1: " + parentheses1.test());

        String test2 = "[(])";
        Parentheses parentheses2 = new Parentheses();
        for(char ch : test2.toCharArray()) parentheses2.add(ch);
        System.out.println("Test2: " + parentheses2.test());
    }
}
