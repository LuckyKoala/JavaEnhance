package tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.print_linkedlist_from_tail;

import java.util.Stack;

/**
 * Created by luckykoala on 19-2-27.
 * 新建一个栈，利用栈“后进先出”的特性
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class WithStack {
    public void print(Node first) {
        if(first==null) return;
        Stack<Node> stack = new Stack<>();
        Node step = first;
        //入栈
        while(step!=null) {
            stack.push(step);
            step = step.next;
        }
        //打印
        while(!stack.empty()) {
            System.out.println(stack.pop().val);
        }
    }
}
