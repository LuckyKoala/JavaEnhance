package tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist;

/**
 * Created by luckykoala on 19-2-27.
 */
public class Node {
    public boolean empty = false; //表示这是一个空节点
    public int val;
    public Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
