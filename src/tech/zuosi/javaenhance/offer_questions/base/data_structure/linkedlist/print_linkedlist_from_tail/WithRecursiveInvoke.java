package tech.zuosi.javaenhance.offer_questions.base.data_structure.linkedlist.print_linkedlist_from_tail;

/**
 * Created by luckykoala on 19-2-27.
 * 递归调用，但可能导致函数调用栈溢出
 * 利用函数调用栈
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class WithRecursiveInvoke {
    public void print(Node first) {
        if(first==null) return;
        //先打印下一节点
        print(first.next);
        //递归返回之后再打印当前节点
        System.out.println(first.val);
    }
}
