package tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.reverse_linkedlist;

import tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.Node;

/**
 * Created by luckykoala on 19-2-27.
 */
public class ReverseLinkedList {
    public Node reverse(Node first) {
        if(first==null) return null;

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
        return step;
    }
}
