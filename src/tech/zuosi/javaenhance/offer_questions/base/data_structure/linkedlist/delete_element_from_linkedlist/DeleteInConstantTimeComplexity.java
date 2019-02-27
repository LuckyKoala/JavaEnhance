package tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.delete_element_from_linkedlist;

import tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.Node;

/**
 * Created by luckykoala on 19-2-27.
 * 对于n-1个非尾节点，时间复杂度为O(1)
 * 对于尾节点，需要遍历查找上一个节点，时间复杂度为O(n)
 * 平均下来，时间复杂度为O(1)，满足要求
 */
public class DeleteInConstantTimeComplexity {
    public void deleteNode(Node first, Node nodeToBeDeleted) {
        if(first==null || nodeToBeDeleted==null) return;

        Node next = nodeToBeDeleted.next;
        if(next!=null) {
            //该节点有下一个节点，那么直接将下一个节点的值复制过来，再删除下一节点
            //这样做的好处是不需要nodeToBeDeleted的上一个节点，也就不需要遍历查找。
            nodeToBeDeleted.val = next.val;
            nodeToBeDeleted.next = next.next;
        } else {
            //没有下一个节点，那就必须找到上一个节点了
            if(first == nodeToBeDeleted) {
                //要删除的是唯一节点，既是头节点也是尾节点
                first.empty = true;
            } else {
                //要删除的是尾节点
                Node step = first;
                while(step!=null) {
                    if(step.next == nodeToBeDeleted) {
                        step.next = null;
                        return;
                    }
                    step = step.next;
                }
            }
        }
    }
}
