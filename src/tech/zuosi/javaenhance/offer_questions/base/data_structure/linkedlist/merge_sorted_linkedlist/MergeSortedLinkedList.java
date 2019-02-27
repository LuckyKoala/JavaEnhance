package tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.merge_sorted_linkedlist;

import tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.Node;

/**
 * Created by luckykoala on 19-2-27.
 */
public class MergeSortedLinkedList {
    public Node mergeRecursive(Node a, Node b) {
        //递归实现
        if(a==null) return b;
        if(b==null) return a;

        if(a.val <= b.val) {
            a.next = mergeRecursive(a.next, b);
            return a;
        }
        else {
            b.next = mergeRecursive(a, b.next);
            return b;
        }
    }

    public Node mergeInterative(Node a, Node b) {
        //迭代实现
        if(a==null) return b;
        if(b==null) return a;

        Node head, step;
        //初始化头指针和当前指针
        if(a.val <= b.val) {
            head = a;
            a = a.next;
        }
        else {
            head = b;
            b = b.next;
        }
        step = head;

        while(a!=null && b!=null) {
            if(a.val <= b.val) {
                step.next = a;
                a = a.next;
            } else {
                step.next = b;
                b = b.next;
            }
            step = step.next; //步进
        }
        if(a!=null) step.next = a;
        else step.next = b;

        return head;
    }
}
