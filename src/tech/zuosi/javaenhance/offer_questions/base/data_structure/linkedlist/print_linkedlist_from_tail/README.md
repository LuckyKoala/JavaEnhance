## 题目

> 6. 从尾到头打印列表

输入一个链表的头节点，从尾到头反过来打印出每个节点的值。链表节点定义如下：

```
struct ListNode
{
    int m_nKey;
    ListNode* m_pNext;
};
```

## 题解

> 最佳 利用栈"后进先出"的特性，无需修改原链表结构，空间复杂度O(n)

遍历链表的操作是少不了的，时间复杂度均为O(n)。

如果允许修改原链表结构，可以利用三个指针遍历一次将链表反转，然后再遍历一次打印即可，空间复杂度O(n)。

函数调用栈也是栈，所以可以使用递归解决本题，但是可能导致函数调用栈溢出，空间复杂度O(1)（若不算函数调用栈的空间消耗）。