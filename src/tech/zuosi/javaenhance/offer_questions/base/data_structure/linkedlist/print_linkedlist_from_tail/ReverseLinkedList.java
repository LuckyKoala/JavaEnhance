package tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.print_linkedlist_from_tail;

import tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.Node;

/**
 * Created by luckykoala on 19-2-27.
 * 反转链表再打印，需要修改链表结构
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class ReverseLinkedList {
    public void print(Node first) {
        if(first==null) return;
        //反转链表
        Node last = null;
        Node step = first;
        Node next = step.next;
        while(next!=null) {
            step.next = last;
            last = step;
            step = next;
            next = step.next;
        }
        step.next = last;
        //打印
        while(step!=null) {
            System.out.print(step.val);
            step = step.next;
        }
    }
}
