package tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.reverse_linkedlist;

import tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.Node;

/**
 * Created by luckykoala on 19-2-27.
 */
public class ReverseWithRecursiveInvoke {
    public Node reverse(Node node) {
        if(node==null) return null;

        Node next = node.next;
        if(next == null) return node; //找到头结点，开始返回
        else {
            Node ret = reverse(next); //先反转下一节点
            next.next = node; //反转
            return ret;
        }
    }
}
