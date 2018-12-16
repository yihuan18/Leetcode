/*
LeetCode Q160 : 相交链表
编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {
    /**
     定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部,
     最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
     两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
        ListNode pA = headA , pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
